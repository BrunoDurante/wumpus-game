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

    public static void removeElementBoard(int line, int column, String element) {
        cave[line][column] = cave[line][column].replace(element, " ");
    }

    public static boolean checkLimits(int value) {
        return value >= 0 && value < 4;
    }

    public static boolean isWall(int linePosition, int columnPosition, Integer direction) {
        if (direction.equals(Directions.NORTH.getValue())) {
            return !checkLimits(linePosition - 1);
        }
        if (direction.equals(Directions.EAST.getValue())) {
            return !checkLimits(columnPosition + 1);
        }
        if (direction.equals(Directions.SOUTH.getValue())) {
            return !checkLimits(linePosition + 1);
        }
        if (direction.equals(Directions.WEST.getValue())) {
            return !checkLimits(columnPosition - 1);
        }
        return false;
    }

    public static String getCaveBoard(Hero hero) {
        int length = 0;
        StringBuilder caveBoard = new StringBuilder();

        caveBoard.append("         (A) (B) (C) (D)\n");
        for (int i = 0; i < 4; i++) {
            caveBoard.append("   (").append(i).append(")  |");
            for (int j = 0; j < 4; j++) {

                if (hero.wasVisited(i, j)) {
                    length = String.valueOf(cave[i][j]).length();
                    if (length == 1) {
                        caveBoard.append("  ").append(cave[i][j]).append("|");
                    } else if (length == 2) {
                        caveBoard.append(" ").append(cave[i][j]).append("|");
                    } else if (length == 0) {
                        caveBoard.append("   " + "|");
                    } else {
                        caveBoard.append(cave[i][j]).append("|");
                    }
                } else {
                    caveBoard.append("   ").append("|");
                }

            }
            caveBoard.append("\n");
        }
        return caveBoard.toString();
    }

}
