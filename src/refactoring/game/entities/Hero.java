package refactoring.game.entities;

public class Hero extends Personage {
    public String name;
    public boolean arrow;
    public boolean alive;
    public Direction directionOnBoard;

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

    @Override
    public int getColumnPosition() {
        return super.getColumnPosition();
    }

    @Override
    public int getLinePosition() {
        return super.getLinePosition();
    }

    @Override
    public void setPosition(int linePosition, int columnPosition) {
        super.setPosition(linePosition, columnPosition);
    }
}
