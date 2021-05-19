package game.entities;

public enum Directions {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int valueOnBoard;

    Directions(int valueOnBoard) {
        this.valueOnBoard = valueOnBoard;
    }

    public int getValue() {
        return valueOnBoard;
    }

    public static Directions getDirection(int value) {
        switch (value) {
            case 0: {
                return Directions.NORTH;
            }
            case 1: {
                return Directions.EAST;
            }
            case 2: {
                return Directions.SOUTH;
            }
            case 3: {
                return Directions.WEST;
            }
        }
        return null;
    }
}
