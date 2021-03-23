package refactoring.game.entities.sensor;

import refactoring.game.entities.Codename;

public class Light extends Sensor {

    public Light() {
        super(Codename.LIGHT);
    }

    @Override
    protected String getResponse() {
        return "Light";
    }
}
