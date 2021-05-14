package game;

import game.entities.Cave;
import game.entities.Hero;
import game.entities.main.Wumpus;
import game.entities.Entity;

import java.util.Map;
import java.util.Scanner;

//TODO
/**
 * > Ajustar disposição dos elementos no board (brisa e buraco estão aparecendo na mesma posição)
 * > Incluir mensagem dos sensores no console.
 * > Documentar o projeto
 */

public class Game {
    public static boolean gaming = true;
    public static Scanner sc;
    private static Map<String, Entity> mapEntities;
    private static Config config;

    // colocar um thread sleep nas mensagens do game para o jogador, simulando games de rpg.

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        config = new Config();

        config.showIntro();
        Cave.createCave();
        Hero hero = new Hero(config.inputNameHero());

        config.welcomeHero(hero.getName());

        mapEntities = config.prepareGame();
        mapEntities.put("hero", hero);

        pausarConsole(3);
        config.showBoard(hero);
        pausarConsole(5);
        config.showRules();
        pausarConsole(10);

        config.showStatus(hero);
        pausarConsole(5);

        while (gaming) {
            round(hero);

            config.showBoard(hero);
            config.showStatus(hero);
            if (endGame()) {
                gaming = false;
                System.out.println("FIMMMMM");
                sc.close();
//               Mensagens de término de jogo
            }
        }
    }

    private static void pausarConsole(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void round(Hero hero) {
        System.out.print("\nType your action...\n:");
        switch (sc.nextLine().toLowerCase()) {
            case "walk": {
                hero.walk();
                break;
            }
            case "turn l":
            case "turn left":
            case "turnl":
            case "turnleft": {
                hero.turnLeft();
                break;
            }
            case "turn r":
            case "turn right":
            case "turnr":
            case "turnright": {
                hero.turnRight();
                break;
            }
            case "shoot": {
                hero.shoot((Wumpus) mapEntities.get("wumpus"));
                break;
            }
            case "status": {
                config.showStatus(hero);
                break;
            }
            default: {
                System.out.println("> Unknown command, please type again.\n");
                break;
            }
        }
    }

    //verificar fim do jogo
    public static Boolean endGame() {
        return Checking.lose(mapEntities) || Checking.win(mapEntities);
    }
}
