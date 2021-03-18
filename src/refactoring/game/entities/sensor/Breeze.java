package refactoring.game.entities.sensor;

public class Breeze extends Sensor {

    public Breeze(int line, int column, String sensor) {
        super(line, column, sensor);
    }

    @Override
    protected String getResponse() {
        return "Breeze";
    }
}
