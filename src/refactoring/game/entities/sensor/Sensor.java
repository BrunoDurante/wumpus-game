package refactoring.game.entities.sensor;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Codename;
import refactoring.game.entities.Entity;

public abstract class Sensor extends Entity {

    public Sensor(Codename codename) {
        super(0, 0, codename);
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
