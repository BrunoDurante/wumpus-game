package game.entities.sensor;

import game.entities.Cave;
import game.entities.Codename;

public abstract class Sensor{
    public int line;
    public int column;
    public Codename codename;

    public Sensor(int linePositionEntity, int columnPositionEntity, Codename codename) {
        this.line = linePositionEntity;
        this.column = columnPositionEntity;
        this.codename = codename;
    }

    protected abstract String getResponse();

    public void setSensorAroundElement() {
        //Above the element
        setVertical(line - 1);

        //Below the element
        setVertical(line + 1);

        //To the right of the element
        setHorizontal(column + 1);

        //To the left of the element
        setHorizontal(column - 1);
    }

    private void setHorizontal(int column) {
        if (Cave.checkLimits(column)) Cave.setElementOnBoard(line, column, codename.name());
    }

    private void setVertical(int line) {
        if (Cave.checkLimits(line)) Cave.setElementOnBoard(line, column, codename.toString());
    }
}
