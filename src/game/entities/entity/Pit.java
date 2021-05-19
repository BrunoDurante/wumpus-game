package game.entities.entity;

import game.entities.Codename;
import game.entities.Position;
import game.entities.sensor.Breeze;
import game.entities.sensor.Sensor;

import java.util.Random;

public class Pit extends Entity {

    private Sensor breeze;

    public Pit() {
        super(Codename.P);
        breeze = new Breeze();
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
            } while (x >= 2 && y < 2 || gold.exists(x, y) || wumpus.exists(x, y) || hasPit(x, y)
                    || gold.canBeBlocked(x, y, wumpus, this));
            setPosition(x, y);
            putSensor(x, y);
            count++;

        }
    }

    /**
     * Responsável por analisar se a linha e a coluna gerada já possui um Pit.
     *
     * @param line   linha a ser checada.
     * @param column coluna a ser checada.
     * @return true se tiver um Pit na posição, false se não.
     */
    private boolean hasPit(int line, int column) {
        return positionList.stream().anyMatch(position -> position.getLine() == line && position.getColumn() == column);
    }

    @Override
    public void putSensor(int linePositionEntity, int columnPositionEntity) {
        breeze.setSensorAroundElement(linePositionEntity, columnPositionEntity);
    }

    public Sensor getBreeze(){
        return breeze;
    }
}
