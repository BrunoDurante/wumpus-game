package refactoring.game;

import kernel.Kernel;
import refactoring.game.entities.Cave;
import refactoring.game.entities.Hero;

import java.util.Scanner;

public class Game {

    public Cave cave;
    public Kernel kernel;
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
            case "turnL": {
                hero.turnL();
                break;
            }
            case "turnR": {
                hero.turnR();
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
        //verificar fim do jogo

    }

}
