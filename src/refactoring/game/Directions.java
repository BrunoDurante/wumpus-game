package refactoring.game;

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

    public String getName(){
        return name();
    }

    public static String getDirectionName(int value){
        switch (value){
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
