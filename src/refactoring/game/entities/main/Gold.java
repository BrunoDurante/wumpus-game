package refactoring.game.entities.main;

import refactoring.game.entities.Codename;
import refactoring.game.entities.Entity;
import refactoring.game.entities.sensor.Light;
import refactoring.game.entities.sensor.Sensor;

import java.util.Random;

import static refactoring.game.entities.Cave.checkLimits;

public class Gold extends Entity {

    public Gold() {
        super(Codename.GOLD);
    }

    @Override
    public void putEntityBoard(Random random, Entity... entities) {
        int x;
        int y;
        do {
            x = random.nextInt(4);
            y = random.nextInt(4);
        } while (x >= 2 && y < 2 || (x < 2 && y >= 2));
        setPosition(x, y);
        putSensor(x, y);

    }

    @Override
    public void putSensor(int linePositionEntity, int columnPositionEntity) {
        Sensor light = new Light(linePositionEntity, columnPositionEntity);
        light.setSensorAroundElement();
    }

    public boolean hasCellAvailableAround(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        return checkCellsAround(destinationLine, destinationColumn, wumpus, pit);
    }

    private boolean checkCellsAround(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        //Above gold
        if (checkLimits(line - 1)) {
            if (isEmpty(line - 1, destinationColumn, wumpus, pit)) {
                return true;
            }
        }

        //Below gold
        if (checkLimits(line + 1)) {
            if (isEmpty(line + 1, destinationColumn, wumpus, pit)) {
                return true;
            }
        }

        //Gold right
        if (checkLimits(column + 1)) {
            if (isEmpty(destinationLine, column + 1, wumpus, pit)) {
                return true;
            }
        }

        //Gold left
        if (checkLimits(column - 1)) {
            if (isEmpty(destinationLine, column - 1, wumpus, pit)) {
                return true;
            }
        }
        return false;
    }


    private boolean isEmpty(int line, int column, Wumpus wumpus, Pit pit) {
        return !(wumpus.exists(line, column) || pit.exists(line, column));
    }


}
