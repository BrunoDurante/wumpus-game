package refactoring.game.entities.sensor;

public class BadSmell extends Sensor {

    public BadSmell(int line, int column, String sensor) {
        super(line, column, sensor);
    }

    @Override
    public String getResponse() {
        return "BadSmell";
    }
}
