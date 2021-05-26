package game.entities.sensor;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    protected Position position;
    protected List<Position> positionList;

    public Codename codename;

    public Sensor(Codename codename) {
        this.codename = codename;
        positionList = new ArrayList<>();
    }

    public void setSensorAroundElement(Position position) {
        this.position = position;

        //Above the element
        setVertical(position.getLine() - 1);

        //Below the element
        setVertical(position.getLine() + 1);

        //To the right of the element
        setHorizontal(position.getColumn() + 1);

        //To the left of the element
        setHorizontal(position.getColumn() - 1);
    }

    private void setHorizontal(int column) {
        if (Cave.checkLimits(column)) {
            Cave.setElementOnBoard(position.getLine(), column, codename.name());
            addSensor(position.getLine(), column);
        }
    }

    private void setVertical(int line) {
        if (Cave.checkLimits(line)) {
            Cave.setElementOnBoard(line, position.getColumn(), codename.name());
            addSensor(line, position.getColumn());
        }
    }

    public void addSensor(int line, int column) {
        this.positionList.add(new Position(line, column));
    }

    public List<Position> getPositionList() {
        return this.positionList;
    }

}
