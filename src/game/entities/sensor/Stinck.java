package game.entities.sensor;

import game.entities.Codename;

public class Stinck extends Sensor {

    public Stinck() {
        super(Codename.S);
    }

    public static void getResponse() {
        System.out.println("\n~ Yuck!! What a stench! Wumpus must be around here.");
    }

}
