package game.entities.sensor;

import game.entities.Codename;

public class Light extends Sensor {

    public Light(int linePositionEntity, int columnPositionEntity) {
        super(linePositionEntity, columnPositionEntity, Codename.L);
    }

    @Override
    protected String getResponse() {
        return "Light";
    }


}
