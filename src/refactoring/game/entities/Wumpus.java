package refactoring.game.entities;

public class Wumpus extends Personage {

    private boolean alive;

    public Wumpus() {
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
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
