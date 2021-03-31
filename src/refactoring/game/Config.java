package refactoring.game;

import refactoring.game.entities.Entity;
import refactoring.game.entities.main.Gold;
import refactoring.game.entities.main.Pit;
import refactoring.game.entities.main.Wumpus;

import java.util.*;

public class Config {

    public String inputNameHero(Scanner sc) {
        System.out.print("~ Enter the Hero name...\n:");
        return sc.next();
    }

    public void showIntro() {
        System.out.println("Intro do game.");
    }

    public void showBoard() {
        System.out.println("");
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
