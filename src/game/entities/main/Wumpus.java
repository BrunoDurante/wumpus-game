package game.entities.main;

import game.entities.Codename;
import game.entities.sensor.Stinck;
import game.entities.Entity;
import game.entities.sensor.Sensor;

import java.util.Random;

public class Wumpus extends Entity {

    private boolean alive;

    public Wumpus() {
        super(Codename.W);
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void killWumpus() {
        alive = false;
    }

    @Override
    public void putEntityBoard(Random random, Entity... entities) {
        int x;
        int y;
        Gold gold = (Gold) entities[0];
        do {
            x = random.nextInt(4);
            y = random.nextInt(4);
        } while (x >= 2 && y < 2 || (x < 2 && y >= 2) || gold.exists(x, y));
        setPosition(x, y);
        putSensor(x, y);
    }

    @Override
    public void putSensor(int linePositionEntity, int columnPositionEntity) {
        Sensor stinck = new Stinck(linePositionEntity, columnPositionEntity);
        stinck.setSensorAroundElement();
    }

}
