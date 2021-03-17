package refactoring.game;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Hero;

import java.util.Scanner;

public class Game {

    public Cave cave;
    public Hero hero;

    public static void main(String[] args) {
        //showIntro();
        //inputNameHero();

        Hero hero = new Hero("");
        Scanner sc = new Scanner(System.in);

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
                hero.shoot();
                break;
            }
            default: {
                break;
            }
        }

        //checar e passar um status do que ocorreu na rodada
        //para inserir infos na tela, passar hero como parâmetro
        //verificar fim do jogo
        sc.close();

    }

}
