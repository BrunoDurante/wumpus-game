package refactoring.game.entities.sensor;

import refactoring.game.entities.Cave;

public abstract class Sensor {

    // TODO extrair if + condição true, pois repete em todos os casos. O que muda é o valor line e column.
    public void setSensorBoard(int line, int column, String sensor) {
        //west
        column--;
        if (column >= 0 && column < 4) {
            Cave.setElementOnBoard(line, column, sensor);
        }
        column++;

        //east
        column++;
        if (column >= 0 && column < 4) {
            Cave.setElementOnBoard(line, column, sensor);
        }
        column--;

        //south
        line++;
        if (line >= 0 && line < 4) {
            Cave.setElementOnBoard(line, column, sensor);
        }
        line--;

        //north
        line--;
        if (line >= 0 && line < 4) {
            Cave.setElementOnBoard(line, column, sensor);
        }
    }

    protected abstract String getResponse();
}
