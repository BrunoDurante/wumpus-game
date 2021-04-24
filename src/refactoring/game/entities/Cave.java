package refactoring.game.entities;

import refactoring.game.Directions;

public class Cave {

    public static String[][] cave = new String[4][4];

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
        if (direction.equals(Directions.NORTH.valueOnBoard)) {
            return checkLimits(linePosition - 1);
        }
        if (direction.equals(Directions.EAST.valueOnBoard)) {
            return checkLimits(columnPosition + 1);
        }
        if (direction.equals(Directions.SOUTH.valueOnBoard)) {
            return checkLimits(linePosition + 1);
        }
        if (direction.equals(Directions.WEST.valueOnBoard)) {
            return checkLimits(columnPosition - 1);
        }
        return false;
    }

    public static String getCaveBoard() {
        int length = 0;
        String caveBoard = "";

        caveBoard += "         (A) (B) (C) (D)\n";
        for (int i = 0; i < 4; i++) {
            caveBoard += "   (" + i + ")  |";
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

    public String getDirectionToString(int direction){
        switch (direction){
            case 0:{
                return Directions.NORTH.name();
            }
            case 1:{
                return Directions.EAST.name();
            }
            case 2:{
                return Directions.SOUTH.name();
            }
            case 3:{
                return Directions.WEST.name();
            }
            default:
                return "Not found";
        }
    }


}
