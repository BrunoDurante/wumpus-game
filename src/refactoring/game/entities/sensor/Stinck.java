package refactoring.game.entities.sensor;

import refactoring.game.entities.Codename;

public class Stinck extends Sensor {

    public Stinck(int linePositionEntity, int columnPositionEntity) {
        super(linePositionEntity, columnPositionEntity, Codename.STINCK);
    }

    @Override
    public String getResponse() {
        return "Stinck";
    }
}
