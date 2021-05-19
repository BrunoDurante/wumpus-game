package game.entities.sensor;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    protected int lineEntity;
    protected int columnEntity;
    protected List<Position> positionList;

    public Codename codename;

    public Sensor(Codename codename) {
        this.codename = codename;
        positionList = new ArrayList<>();
    }

    public void setSensorAroundElement(int lineEntity, int columnEntity) {
        this.lineEntity = lineEntity;
        this.columnEntity = columnEntity;

        //Above the element
        setVertical(lineEntity - 1);

        //Below the element
        setVertical(lineEntity + 1);

        //To the right of the element
        setHorizontal(columnEntity + 1);

        //To the left of the element
        setHorizontal(columnEntity - 1);
    }

    private void setHorizontal(int column) {
        if (Cave.checkLimits(column)) {
            Cave.setElementOnBoard(lineEntity, column, codename.name());
            addSensor(lineEntity, column);
        }
    }

    private void setVertical(int line) {
        if (Cave.checkLimits(line)) {
            Cave.setElementOnBoard(line, columnEntity, codename.name());
            addSensor(line, columnEntity);
        }
    }

    public void addSensor(int line, int column) {
        this.positionList.add(new Position(line, column));
    }

    public List<Position> getPositionList() {
        return this.positionList;
    }

}
