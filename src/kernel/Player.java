package kernel;

import manager.Game;

public class Player {

    public static String getDirection() {
        switch (Game.kernel.getDir()) {
            case 0:
                return "NORTH";
            case 1:
                return "EAST";
            case 2:
                return "SOUTH";
            case 3:
                return "WEST";
            default:
                return "Position not found.";
        }
    }

    public static int[] getPosition() {
        int[] r = Game.kernel.getPlayerPosition();
        return r;
    }
}
