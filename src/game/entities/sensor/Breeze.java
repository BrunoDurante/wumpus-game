package game.entities.sensor;

import game.entities.Codename;

public class Breeze extends Sensor {

    public Breeze() {
        super(Codename.B);
    }

    public static void getResponse() {
        System.out.println("\n~ What's that breeze? There must be a pit nearby.");
    }

}
