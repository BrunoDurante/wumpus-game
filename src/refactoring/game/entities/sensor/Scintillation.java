package refactoring.game.entities.sensor;

public class Scintillation extends Sensor {

    public Scintillation(int line, int column, String sensor) {
        super(line, column, sensor);
    }

    @Override
    protected String getResponse() {
        return "Scintillation";
    }
}
