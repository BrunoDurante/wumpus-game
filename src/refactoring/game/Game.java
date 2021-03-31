package refactoring.game;

import refactoring.game.entities.Entity;
import refactoring.game.entities.Hero;
import refactoring.game.entities.main.Wumpus;

import java.util.Scanner;

public class Game {
    public static boolean gaming = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Config config = new Config();
        config.showIntro();

        Hero hero = new Hero(config.inputNameHero(sc));

        // welcome message

        config.prepareGame();


        Entity wumpus = new Wumpus();

        while (gaming) {
            System.out.print("Your action is...\n:");
            switch (sc.next()) {
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
                    hero.shoot(wumpus);
                    break;
                }
                case "hack board": {
//                    config.showBoardElements();
                }
                default: {
                    System.out.println("~ Unknown command, please type again.");
                    break;
                }
            }
        }

        //checar e passar um status do que ocorreu na rodada
        //para inserir infos na tela, passar hero como parâmetro
        //verificar fim do jogo
        sc.close();

    }


}
