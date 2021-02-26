package kernel;

import manager.Game;

public class Check {

    public static Boolean hasGold(int x, int y) {
        boolean hasGold = Game.kernel.hasGold(x, y);
        if (hasGold) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean wumpusAlive() {
        if (Game.kernel.hasWumpus(Game.kernel.localWumpus[0], Game.kernel.localWumpus[1])) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean hasWumpus(int x, int y) {
        boolean hasWumpus = Game.kernel.hasWumpus(x, y);
        if (hasWumpus) {
            return true;
        }
        return false;
    }

    public static int arrowAmount() {
        boolean hasArrow = Game.kernel.hasArrow();
        if (hasArrow) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String hasSensors(int x, int y) {
        String[] vectSensor = Game.kernel.hasSensor(x, y);
        int i = 0;
        String status = "\n";
        while (i <= 2) {
            switch (vectSensor[i]) {
                case "B": {
                    status += "  ~~~~~~  RUUUUIIIUUUU!! There's a pit nearby.  ~~~~~~ \n";
                    break;
                }
                case "F": {
                    status += "  ~~~~~~  YUUUCK! I smell Wumpus.  ~~~~~~ \n";
                    break;
                }
                case "C": {
                    status += "  ****  OHHH! I can already see the gold shine!  ****  \n";
                    break;
                }
                default:
                    break;
            }
            i++;
        }

        if (status.equals("")) {
            status = "Nothing around here...";
        }

        return status;
    }

    public static Boolean hasPit(int x, int y) {
        boolean hasPit = Game.kernel.hasPit(x, y);
        if (hasPit) {
            Game.setEndGame(false);
            return true;
        }
        return false;
    }

    public static int[][] getCave() {
        return Game.kernel.getCave();
    }


    // MONTAR UMA CHECAGEM DE FIM DE JOGO
    public static Boolean[] checkEndGame() {
        int[] pos = Player.getPosition();
        int x = pos[0];
        int y = pos[1];
        if (hasGold(x,y) || !wumpusAlive) {
            return ;
        } else if (hasWumpus || hasPit) {
            return true;
        } else {
            return false;
        }
    }

}
