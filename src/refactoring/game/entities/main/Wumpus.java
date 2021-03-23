package refactoring.game.entities.main;

import refactoring.game.entities.Codename;
import refactoring.game.entities.Entity;

public class Wumpus extends Entity {

    private final boolean alive;

    public Wumpus() {
        super(0, 0, Codename.WUMPUS);
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

}
