package game;

import game.entities.Cave;
import game.entities.entity.hero.Hero;
import game.entities.entity.Wumpus;
import game.entities.entity.Entity;

import java.util.Map;
import java.util.Scanner;

/**
 * > Documentar o projeto
 */

public class Game {
    private static boolean gaming = true;
    public static Scanner sc;
    private static Map<String, Entity> mapEntities;
    private static Config config;
    private static Hero hero;

    public static void main(String[] args) {

        startGame();
        while (gaming) {
            round(hero);
            if (endGame()) {
                gaming = false;
                config.end(hero.getName());
                sc.close();
            } else {
                config.showSensor(mapEntities);
            }
        }
    }

    private static void startGame() {
        sc = new Scanner(System.in);
        config = new Config();
        config.showIntro();
        Cave.createCave();
        hero = new Hero(config.inputNameHero());
        config.welcome(hero.getName());
        mapEntities = config.prepareGame();
        mapEntities.put("hero", hero);
        pausarConsole(2);
        config.showBoard(hero);
        pausarConsole(5);
        config.showRules();
        pausarConsole(10);
        config.showStatus(hero);
        pausarConsole(5);
    }

    private static void pausarConsole(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void round(Hero hero) {
        pausarConsole(2);
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
        config.showBoard(hero);

        pausarConsole(1);
    }

    //verificar fim do jogo
    public static Boolean endGame() {
        return Checking.lose(mapEntities) || Checking.win(mapEntities);
    }
}
