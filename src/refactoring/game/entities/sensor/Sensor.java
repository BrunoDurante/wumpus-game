package refactoring.game.entities.sensor;

import refactoring.game.entities.Cave;

public abstract class Sensor {

    private final int line;
    private final int column;
    private final String name;

    public Sensor(int line, int column, String name) {
        this.line = line;
        this.column = column;
        this.name = name;
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

    private void setHorizontal(int column){
        if (checkLimits(column)) Cave.setElementOnBoard(line, column, name);
    }

    private void setVertical(int line){
        if (checkLimits(line)) Cave.setElementOnBoard(line, column, name);
    }

    private boolean checkLimits(int value) {
        return value >= 0 && value < 4;
    }

}
