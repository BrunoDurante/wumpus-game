package refactoring.game.entities.main;

import refactoring.game.entities.Codename;
import refactoring.game.entities.Entity;
import refactoring.game.entities.sensor.Breeze;
import refactoring.game.entities.sensor.Light;
import refactoring.game.entities.sensor.Sensor;

import java.util.Random;

public class Pit extends Entity {

    public Pit() {
        super(Codename.PIT);
    }

    @Override
    public void putEntityBoard(Random random, Entity... entities) {
        int count = 1;
        int x;
        int y;

        Gold gold = (Gold) entities[0];
        Wumpus wumpus = (Wumpus) entities[1];

        while (count <= 3) {
            do {
                x = random.nextInt(4);
                y = random.nextInt(4);
            } while (x >= 2 && y < 2 || (x < 2 && y >= 2) || gold.exists(x, y) || wumpus.exists(x, y) || this.exists(x, y)
                    || gold.hasCellAvailableAround(x, y, wumpus, this));
            setPosition(x, y);
            putSensor(x, y);
            count++;
        }
    }

    @Override
    public void putSensor(int linePositionEntity, int columnPositionEntity) {
        Sensor breeze = new Breeze(linePositionEntity, columnPositionEntity);
        breeze.setSensorAroundElement();
    }
}
