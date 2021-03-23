package refactoring.game;

import refactoring.game.entities.main.Hero;
import refactoring.game.entities.main.Wumpus;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Config config = new Config();
        config.showIntro();

        Hero hero = new Hero(config.inputNameHero(sc));
        Wumpus wumpus = new Wumpus();

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
                config.showBoardElements();
            }
            default: {
                System.out.println("~ Unknown command, please type again.");
                break;
            }
        }

        //checar e passar um status do que ocorreu na rodada
        //para inserir infos na tela, passar hero como parâmetro
        //verificar fim do jogo
        sc.close();

    }

}
