package refactoring.game.entities;

public class Cave {

    public static String[][] cave;
    public static Integer NORTH = 0;
    public static Integer EAST = 1;
    public static Integer SOUTH = 2;
    public static Integer WEST = 3;

    public Cave() {
        cave = new String[4][4];
    }

    public static String[][] getCave() {
        return cave;
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

}
