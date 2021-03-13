package refactoring.game.entities;

public class Hero {
    public String name;
    public boolean arrow;
    public boolean alive;
    public Direction directionOnBoard;
    public int linePosition;
    public int columnPosition;

    public Hero(String name) {
        this.name = name;
        arrow = true;
        alive = true;
        directionOnBoard = Direction.EAST;
    }

    public boolean shoot(int dir) {
        return true;
    }

    public boolean walk() {
        return true;
    }

    public boolean turn() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasArrow() {
        return arrow;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Direction getDirectionOnBoard() {
        return directionOnBoard;
    }

    public void setDirectionOnBoard(Direction directionOnBoard) {
        this.directionOnBoard = directionOnBoard;
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
