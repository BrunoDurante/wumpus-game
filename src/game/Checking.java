package game;

import game.entities.Hero;
import game.entities.main.Gold;
import game.entities.main.Pit;
import game.entities.main.Wumpus;

import java.util.Map;

public class Checking {
    public static boolean win(Map mapEntities) {
        Wumpus wumpus = (Wumpus) mapEntities.get("wumpus");
        Hero hero = (Hero) mapEntities.get("hero");
        Gold gold = (Gold) mapEntities.get("gold");

        if (!wumpus.isAlive()) {
            System.out.println("YOU WIN !!! You killed Wumpus!!");
            return true;
        }
        if (foundGold(hero, gold)) {
            System.out.println("YOU WIN !!! You found the gold!!");
            return true;
        }

        return false;
    }

    private static boolean foundGold(Hero hero, Gold gold) {
        return hero.getLinePosition() == gold.getLinePosition() && hero.getColumnPosition() == gold.getColumnPosition();
    }

    public static boolean lose(Map mapEntities) {
        Hero hero = (Hero) mapEntities.get("hero");
        Pit pit = (Pit) mapEntities.get("pit");
        Wumpus wumpus = (Wumpus) mapEntities.get("wumpus");

        if (fallPit(hero, pit)){
            System.out.println("So bad, you lost! You fell in the pit...");
            return true;
        }
        if (foundWumpus(hero, wumpus)){
            System.out.println("So bad, you lost! Wumpus killed you...");
        }
        return false;
    }

    private static boolean foundWumpus(Hero hero, Wumpus wumpus) {
        return hero.getLinePosition() == wumpus.getLinePosition() && hero.getColumnPosition() == wumpus.getColumnPosition();
    }

    private static boolean fallPit(Hero hero, Pit pit) {
        int[][] positions = pit.getPositions();
        for (int index = 0; index < 3; index++) {
            if (positions[index][0] == hero.getLinePosition() && positions[index][1] == hero.getColumnPosition())
                return true;
        }
        return false;
    }
}
