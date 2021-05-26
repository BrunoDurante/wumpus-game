package game;

import game.entities.entity.Entity;
import game.entities.entity.hero.Hero;
import game.entities.entity.Gold;
import game.entities.entity.Pit;
import game.entities.entity.Wumpus;
import game.entities.sensor.Breeze;
import game.entities.sensor.Light;
import game.entities.sensor.Stinck;

import java.util.Map;

public class Checking {

    public static boolean win(Map<String, Entity> mapEntities) {
        Wumpus wumpus = (Wumpus) mapEntities.get("wumpus");
        Hero hero = (Hero) mapEntities.get("hero");
        Gold gold = (Gold) mapEntities.get("gold");

        if (!wumpus.isAlive()) {
            System.out.println("\nYOU WIN !!! You killed Wumpus!!");
            return true;
        }
        if (foundGold(hero, gold)) {
            System.out.println("\nYOU WIN !!! You found the gold!!");
            return true;
        }
        return false;
    }

    private static boolean foundGold(Hero hero, Gold gold) {
        return hero.getLinePosition() == gold.getLinePosition() && hero.getColumnPosition() == gold.getColumnPosition();
    }

    public static boolean lose(Map<String, Entity> mapEntities) {
        Hero hero = (Hero) mapEntities.get("hero");
        Pit pit = (Pit) mapEntities.get("pit");
        Wumpus wumpus = (Wumpus) mapEntities.get("wumpus");

        if (fallPit(hero, pit)) {
            System.out.println("\nSo bad, you lost! You fell in the pit...");
            return true;
        }
        if (foundWumpus(hero, wumpus)) {
            System.out.println("\nSo bad, you lost! Wumpus killed you...");
            return true;
        }
        return false;
    }

    private static boolean foundWumpus(Hero hero, Wumpus wumpus) {
        return hero.getLinePosition() == wumpus.getLinePosition() && hero.getColumnPosition() == wumpus.getColumnPosition();
    }

    private static boolean fallPit(Hero hero, Pit pit) {
        return pit.getPositionList().stream().anyMatch(position -> position.getLine() == hero.getLinePosition() && position.getColumn() == hero.getColumnPosition());
    }

    /**
     * Responsável por trazer a mensagem dos sensores quando estiverem na mesma posição do herói.
     * Lógica 'count#' feita para caso tiver dois sensores iguais na mesma posição, não trazer duas vezes a
     * mesma mensagem.
     * <p>
     * Como cada posição da matriz é uma concatenação, utilizo toCharArray() para separar os elementos,
     * e assim verificar se são os sensores, trazendo suas respectivas mensagens para o console.
     * </p>
     *
     * @param mapEntities Map com as entidades geradas no início do jogo.
     */
    public static void hasSensor(Map<String, Entity> mapEntities) {
        Pit pit = (Pit) mapEntities.get("pit");
        Gold gold = (Gold) mapEntities.get("gold");
        Wumpus wumpus = (Wumpus) mapEntities.get("wumpus");
        Hero hero = (Hero) mapEntities.get("hero");

        int line = hero.getLinePosition();
        int column = hero.getColumnPosition();

        if (pit.getSensor().getPositionList().stream().anyMatch(position -> position.getLine() == line && position.getColumn() == column))
            Breeze.getResponse();
        if (gold.getSensor().getPositionList().stream().anyMatch(position -> position.getLine() == line && position.getColumn() == column))
            Light.getResponse();
        if (wumpus.getSensor().getPositionList().stream().anyMatch(position -> position.getLine() == line && position.getColumn() == column))
            Stinck.getResponse();
    }

}
