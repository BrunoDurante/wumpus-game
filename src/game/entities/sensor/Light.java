package game.entities.sensor;

import game.entities.Codename;

public class Light extends Sensor {

    public Light() {
        super(Codename.L);
    }

    public static void getResponse() {
        System.out.println("\n~ Light? The gold must be around here.");
    }

}
