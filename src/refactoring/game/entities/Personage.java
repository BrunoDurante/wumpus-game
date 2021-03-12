package refactoring.game.entities;

public abstract class Personage {

    private int linePosition;
    private int columnPosition;
    private String identifier;

    public int getColumnPosition() {
        return columnPosition;
    }

    public int getLinePosition() {
        return linePosition;
    }

    public void setPosition(int linePosition, int columnPosition) {
        this.linePosition = linePosition;
        this.columnPosition = columnPosition;
    }
}
