package game.entities.sensor;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    protected List<Position> positionList;
    protected int line;
    protected int column;

    public Codename codename;

    public Sensor(Codename codename) {
        this.codename = codename;
        positionList = new ArrayList<>();
    }

    public void setSensorAroundElement(int line, int column) {
        this.line = line;
        this.column = column;

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
        if (Cave.checkLimits(column)) {
            setPosition(line, column);
        }
    }

    private void setVertical(int line) {
        if (Cave.checkLimits(line)) {
            setPosition(line, column);
        }
    }

    protected abstract void setPosition(int line, int column);


    public List<Position> getPositionList() {
        return this.positionList;
    }

}
