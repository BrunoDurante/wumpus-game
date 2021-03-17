package refactoring.game.entities.sensor;

public class BadSmell extends Sensor {
    @Override
    protected String getResponse() {
        return "BadSmell";
    }
}
