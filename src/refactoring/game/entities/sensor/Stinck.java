package refactoring.game.entities.sensor;

import refactoring.game.entities.Codename;

public class Stinck extends Sensor {

    public Stinck() {
        super(Codename.STINCK);
    }

    @Override
    public String getResponse() {
        return "Stinck";
    }
}
