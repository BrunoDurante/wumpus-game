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
 */

public class Game {
    public static boolean gaming = true;
    public static Scanner sc;

    // colocar um thread sleep nas mensagens do game para o jogador, simulando games de rpg.

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Config config = new Config();
        config.showIntro();

        Cave.createCave();
        Hero hero = new Hero(config.inputNameHero(sc));

        config.welcomeHero(hero.getName());

        Map<String, Entity> mapEntities = config.prepareGame();
        mapEntities.put("hero", hero);
        config.showBoard(hero);
        config.showRules();
        config.showStatus(hero);

        while (gaming) {
            round(sc, mapEntities, hero, config);
            config.showBoard(hero);
            if (endGame(mapEntities)) {
                gaming = false;
                System.out.println("FIMMMMM");
                sc.close();
//               Mensagens de término de jogo
            }
        }

    }

    public static void round(Scanner sc, Map<String, Entity> mapEntities, Hero hero, Config config) {
        System.out.print("\nType your action...\n:");
        switch (sc.nextLine().toLowerCase()) {
            case "walk": {
                hero.walk();
                break;
            }
            case "turn left": {
                hero.turnLeft();
                break;
            }
            case "turn right": {
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
    public static Boolean endGame(Map mapEntities) {
        return Checking.lose(mapEntities) || Checking.win(mapEntities);
    }
}
