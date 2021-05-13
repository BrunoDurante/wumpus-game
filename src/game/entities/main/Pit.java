package game.entities.main;

import game.entities.Codename;
import game.entities.sensor.Breeze;
import game.entities.Entity;
import game.entities.sensor.Sensor;

import java.util.Random;

public class Pit extends Entity {

    private int[][] positions;

    public Pit() {
        super(Codename.P);
        positions = new int[3][2];
    }

    public int[][] getPositions(){
        return positions;
    }

    @Override
    public void putEntityBoard(Random random, Entity... entities) {
        int count = 0;
        int x;
        int y;

        Gold gold = (Gold) entities[0];
        Wumpus wumpus = (Wumpus) entities[1];

        while (count < 3) {
            do {
                x = random.nextInt(4);
                y = random.nextInt(4);
            } while (x >= 2 && y < 2 || (x < 2 && y >= 2) || gold.exists(x, y) || wumpus.exists(x, y) || this.exists(x, y)
                    || gold.canBeBlocked(x, y, wumpus, this));
            setPosition(x, y);
            putSensor(x, y);
            positions[count][0] = x;
            positions[count][1] = y;
            count++;

        }
    }

    @Override
    public void putSensor(int linePositionEntity, int columnPositionEntity) {
        Sensor breeze = new Breeze(linePositionEntity, columnPositionEntity);
        breeze.setSensorAroundElement();
    }
}
