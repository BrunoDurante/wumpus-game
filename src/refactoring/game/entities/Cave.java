package refactoring.game.entities;

public class Cave {

    public static String[][] cave;
    public static int NORTH = 0;
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;

    public Cave() {
        cave = new String[4][4];
    }

    public static String[][] getCave() {
        return cave;
    }

    public static void setElementOnBoard(int line, int column, String element) {
        cave[line][column] += element;
    }

    /*somando 1 pois com walk se anda 1 casa.
     * obs: Se destino < 0 ou > 3, foge das limita��es do mapa [4,4].
     */
    public static boolean isWall(int linePosition, int columnPosition, int direction) {
        int destination = 0;
        switch (direction) {
            case 0: {
                destination = linePosition - 1;
                break;
            }
            case 1: {
                destination = columnPosition + 1;
                break;
            }
            case 2: {
                destination = linePosition + 1;
                break;
            }
            case 3: {
                destination = columnPosition - 1;
                break;
            }

        }
        return destination < 0 || destination > 3;
    }

}
