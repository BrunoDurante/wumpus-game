package refactoring.game.entities;

public enum Directions {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int value;

    Directions(int value) {
        this.value = value;
    }
}
