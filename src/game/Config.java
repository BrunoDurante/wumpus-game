package game;

import game.entities.Cave;
import game.entities.entity.Entity;
import game.entities.entity.hero.Hero;
import game.entities.entity.Gold;
import game.entities.entity.Pit;
import game.entities.entity.Wumpus;

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
                "~ To walk through the cave enter \"walk\".\n"
                + "~ To turn right, enter \"turnR\".\n"
                + "~ To turn left, enter \"turnL\". \n"
                + "~ To shoot type \"shoot\".\n"
                + "~ To view your status, enter \"status\".");
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
        System.out.println("\n> Game status");
        System.out.println("Your position on the board: [" + hero.getPositionFormatted() + "]");
        System.out.println("Your current direction: " + hero.getDirection().name());
        System.out.println("Has arrow? " + hero.hasArrow());
        System.out.println("Is Wumpus alive? " + wumpus.isAlive());
    }

    public void welcome(String name) {
        System.out.println("\n~ Welcome " + name + "! This is the cave...");

    }

    public Map<String, Entity> prepareGame() {
        Gold gold = new Gold();
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

    public void end(String name) {
        System.out.println("\nThanks for trying it out, " + name + "! To play again, click 'run' in your IDE.");
    }

    public void showSensor(Map<String, Entity> mapEntities) {
        Checking.hasSensor(mapEntities);
    }
}
