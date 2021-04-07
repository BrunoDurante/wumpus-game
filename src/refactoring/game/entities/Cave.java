package refactoring.game.entities;

public class Cave {

    public static String[][] cave = new String[4][4];
    public static Integer NORTH = 0;
    public static Integer EAST = 1;
    public static Integer SOUTH = 2;
    public static Integer WEST = 3;

    public static void createCave() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cave[i][j] = "";
            }
        }
    }

    public static void setElementOnBoard(int line, int column, String element) {
        cave[line][column] += element;
    }

    public static boolean checkLimits(int value) {
        return value >= 0 && value < 4;
    }

    /* somando 1 pois com walk se anda 1 casa.
     * obs: Se destino < 0 ou > 3, foge das limitacoes do mapa [4,4].
     */
    public static boolean isWall(int linePosition, int columnPosition, Integer direction) {
        if (NORTH.equals(direction)) {
            return checkLimits(linePosition - 1);
        }
        if (EAST.equals(direction)) {
            return checkLimits(columnPosition + 1);
        }
        if (SOUTH.equals(direction)) {
            return checkLimits(linePosition + 1);
        }
        if (WEST.equals(direction)) {
            return checkLimits(columnPosition - 1);
        }
        return false;
    }

    public static String getCaveBoard() {
        int length = 0;
        String caveBoard = "";

        caveBoard += "      (A) (B) (C) (D)\n";
        for (int i = 0; i < 4; i++) {
            caveBoard += "(" + i + ")  |";
            for (int j = 0; j < 4; j++) {
                length = String.valueOf(cave[i][j]).length();
                if (length == 1) {
                    caveBoard += "  " + cave[i][j] + "|";
                } else if (length == 2) {
                    caveBoard += " " + cave[i][j] + "|";
                } else if (length == 0) {
                    caveBoard += "   " + "|";
                } else {
                    caveBoard += cave[i][j] + "|";
                }
            }
            caveBoard += "\n";
        }

        return caveBoard;

    }


}
