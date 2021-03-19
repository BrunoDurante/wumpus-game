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

    /* somando 1 pois com walk se anda 1 casa.
     * obs: Se destino < 0 ou > 3, foge das limitacoes do mapa [4,4].
     */
    public static boolean isWall(int linePosition, int columnPosition, Integer direction) {
        if (NORTH.equals(direction)) {
            return (linePosition - 1) < 0;
        }
        if (EAST.equals(direction)) {
            return (columnPosition + 1) > 3;
        }
        if (SOUTH.equals(direction)) {
            return (linePosition + 1) > 3;
        }
        if (WEST.equals(direction)) {
            return (columnPosition - 1) < 0;
        }
        return false;
    }

}
