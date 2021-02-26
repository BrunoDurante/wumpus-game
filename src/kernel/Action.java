package kernel;

import interfaces.WumpusInterface;
import manager.Game;

public class Action implements WumpusInterface {

    @Override
    public boolean shoot() {
        boolean onTarget = Game.kernel.shoot(Game.kernel.getDir());
        if (onTarget) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void turnL() {
        Game.kernel.turnL();
    }

    @Override
    public void turnR() {
        Game.kernel.turnR();
    }

    @Override
    public String walk() {
        return Game.kernel.walk();
    }
}
