package refactoring.game;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Entity;
import refactoring.game.entities.main.Gold;
import refactoring.game.entities.main.Pit;
import refactoring.game.entities.main.Wumpus;

import java.util.*;

public class Config {

    public Config(){}

    public String inputNameHero(Scanner sc) {
        System.out.println("\n~ So... come on?\n");
        System.out.print("> enter the Hero name...\n: ");
        return sc.next();
    }

    public void showIntro(){
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
        System.out.println("~Cave");
        System.out.println(Cave.getCaveBoard());
    }

    public void showStatus(){
        System.out.println("STATUS");
    }

    public void welcomeHero(String name){
        System.out.println("~Welcome " + name + "!");
        System.out.println("~This is the cave...");

    }

    public Map<String, Entity> prepareGame() {
        Entity gold = new Gold();
        gold.putEntityBoard(new Random(), null);

        Entity wumpus = new Wumpus();
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
