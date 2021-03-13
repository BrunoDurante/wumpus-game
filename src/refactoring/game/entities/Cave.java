package refactoring.game.entities;

public class Cave {
    public static String[][] cave;

    public Cave() {
        cave = new String[4][4];
    }

    public static String[][] getCave() {
        return cave;
    }

    public static void setElementOnBoard(int line, int column,String element) {
        cave[line][column] += element;
    }

    /*somando 1 pois com walk se anda 1 casa.
     * obs: Se destino < 0 ou > 3, foge das limitações do mapa [4,4].
     */
    public static boolean isWall(int linePosition, int columnPosition, Directions direction) {
        int destino = 0;
        switch (direction) {
            case NORTH: {
                destino = linePosition - 1;
                break;
            }
            case EAST: {
                destino = columnPosition + 1;
                break;
            }
            case SOUTH: {
                destino = linePosition + 1;
                break;
            }
            case WEST: {
                destino = columnPosition - 1;
                break;
            }
        }
        if (destino < 0 || destino > 3) {
            return true;
        } else {
            return false;
        }

    }
}
