package refactoring.game.entities;

public class Wumpus {

    private boolean alive;
    private int linePosition;
    private int columnPosition;

    public Wumpus() {
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

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
