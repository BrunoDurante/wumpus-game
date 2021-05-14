package game;

import game.entities.Cave;
import game.entities.Entity;
import game.entities.Hero;
import game.entities.main.Gold;
import game.entities.main.Pit;
import game.entities.main.Wumpus;

import java.util.*;

public class Config {
    private Wumpus wumpus;

    public Config() {
    }

    public void showRules() {
        System.out.println("Game Conditions\n" +
                "~ You win if you find the gold or hit the Wumpus with an arrow.\n" +
                "~ You lose if you fall into the pit or if you are in the same position as Wumpus.");
        System.out.println("Commands\n" +
                "~ To walk through the cave type \"walk\".\n"
                + "~ To turn right, type \"turnR\".\n"
                + "~ To turn left, type \"turnL\". \n"
                + "~ To shoot type \"shoot\".\n");
    }

    public String inputNameHero() {
        System.out.println("\n~ Let's start!");
        System.out.print("> Enter the Hero name...\n: ");

        return Game.sc.nextLine();
    }

    public void showIntro() {
        System.out.println("----------------------------------------------------------");
        System.out.println("--------- Welcome to WUMPUS WORLD GAME (remake) ----------");
        System.out.println("----------------------------------------------------------");
        System.out.println("A reinterpretation of the original Wumpus World game.\n");

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

    public void showBoard(Hero hero) {
        System.out.println("\n" + Cave.getCaveBoard(hero));
    }

    public void showStatus(Hero hero) {
        System.out.println("> Game status");
        System.out.println("Your position on the board: [" + hero.getPositionFormatted() + "]");
        System.out.println("Your current direction: " + hero.getDirectionFormatted());
        System.out.println("Has arrow? " + hero.hasArrow());
        System.out.println("Is Wumpus alive? " + wumpus.isAlive());
    }

    public void welcomeHero(String name) {
        System.out.println("\n~ Welcome " + name + "! This is the cave...");

    }

    public Map<String, Entity> prepareGame() {
        Entity gold = new Gold();
        gold.putEntityBoard(new Random(), null);

        Wumpus wumpus = new Wumpus();
        this.wumpus = wumpus;
        wumpus.putEntityBoard(new Random(), gold);

        Pit pit = new Pit();
        pit.putEntityBoard(new Random(), gold, wumpus);

        Map<String, Entity> mapEntities = new HashMap<>();
        mapEntities.put("gold", gold);
        mapEntities.put("wumpus", wumpus);
        mapEntities.put("pit", pit);

        return mapEntities;
    }

}
