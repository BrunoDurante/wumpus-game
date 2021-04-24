package refactoring.game;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Entity;
import refactoring.game.entities.Hero;
import refactoring.game.entities.main.Gold;
import refactoring.game.entities.main.Pit;
import refactoring.game.entities.main.Wumpus;

import java.util.*;

public class Config {
    private Hero hero;
    private Wumpus wumpus;

    public Config() {
    }

    public void showRules() {
        System.out.println("~ To walk through the cave type \"walk\".\n"
                + "~ To turn right, type \"turnR\".\n"
                + "~ To turn left, type \"turnL\". \n"
                + "~ To shoot type \"shoot\".");
    }

    public String inputNameHero(Scanner sc) {
        System.out.println("\n~ So... come on?\n");
        System.out.print("> enter the Hero name...\n: ");
        return sc.nextLine();
    }

    public void showIntro() {
        System.out.println("----------------------------------------------------------");
        System.out.println("--------- Welcome to WUMPUS WORLD GAME (remake) ----------");
        System.out.println("----------------------------------------------------------");
        System.out.println("A reinterpretation of the original game Wumpus Wolrd.\n");

        System.out.println("                    >>> Rules <<<                         ");
        System.out.println("It's simple... walk through the cave until you find the \ngold or hit the wumpus with a sharp arrow.");
        System.out.println("You can walk, turn right, turn left and shoot.");
        System.out.println("Remember, you are entitled to only one arrow. Use it wisely.");
        System.out.println("Enjoy the game!\n");

        System.out.println("             >>> Development informations <<<             ");
        System.out.println("This game was developed by Bruno Durante, using the Java \nprogramming language, version 11.");
        System.out.println("Send a message if you find any bugs, if you have suggestions \nfor improvements. I am extremely receptive to feedbacks.\n");

        System.out.println("See more about the project:");
        System.out.println("https://github.com/BrunoDurante/wumpus-game");
        System.out.println("----------------------------------------------------------");

    }

    public void showBoard() {
        System.out.println(Cave.getCaveBoard());
    }

    public void showStatus(Hero hero) {
        System.out.println("\n> Game status");
        System.out.println("Has an arrow? " + hero.hasArrow());
        System.out.println("Is wumpus alive? " + wumpus.isAlive());
        System.out.println("Your position on the board: " + "[" + hero.getPositionToString() + "]");
        System.out.println("Your current direction: " + hero.getDirection());
    }

    public void welcomeHero(String name) {
        System.out.println("\n~ Welcome " + name + "!");
        System.out.println("~ This is the cave...\n");

    }

    public Map<String, Entity> prepareGame() {
        Entity gold = new Gold();
        gold.putEntityBoard(new Random(), null);

        Wumpus wumpus = new Wumpus();
        this.wumpus = wumpus;
        wumpus.putEntityBoard(new Random(), gold);

        Entity pit = new Pit();
        pit.putEntityBoard(new Random(), gold, wumpus);

        Map<String, Entity> mapEntities = new HashMap<>();
        mapEntities.put("gold", gold);
        mapEntities.put("wumpus", wumpus);
        mapEntities.put("pit", pit);

        return mapEntities;
    }

}
