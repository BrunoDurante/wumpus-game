package refactoring.game.entities;

import java.util.Random;

public abstract class Entity {
    public int line;
    public int column;
    public Codename codename;

    public Entity(Codename codename) {
        this.codename = codename;
    }

    public int getColumnPosition() {
        return column;
    }

    public int getLinePosition() {
        return line;
    }

    public void setPosition(int linePosition, int columnPosition) {
        this.line = linePosition;
        this.column = columnPosition;
        Cave.setElementOnBoard(line, column, this.codename.name());
    }

    public boolean exists(int lineCheck, int columnCheck) {
        if (line == lineCheck && column == columnCheck) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void putEntityBoard(Random random, Entity... entities);

    protected abstract void putSensor(int linePositionEntity, int columnPositionEntity);


}
