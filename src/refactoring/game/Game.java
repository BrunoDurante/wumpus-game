package refactoring.game;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Entity;
import refactoring.game.entities.Hero;
import refactoring.game.entities.main.Wumpus;

import java.util.Map;
import java.util.Scanner;

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
        config.showBoard();
        config.showRules();
        config.showStatus(hero);

        while (gaming) {
            round(sc, mapEntities, hero, config);
            config.showBoard();
            if (endGame()) {
                gaming = false;
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
                hero.shoot(mapEntities.get("wumpus"));
                break;
            }
            case "status":{
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
        return false;
    }
}
