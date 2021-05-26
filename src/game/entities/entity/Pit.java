package game.entities.entity;

import game.entities.Codename;
import game.entities.Position;
import game.entities.sensor.Breeze;
import game.entities.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pit extends Entity {

    private Sensor breeze;
    private List<Position> positionList;

    public Pit() {
        super(Codename.P);
        breeze = new Breeze();
        positionList = new ArrayList<>();
    }

    @Override
    public Sensor getSensor() {
        return breeze;
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
                    || gold.canBeBlocked(x, y, wumpus, this) || pitAround(x, y));
            setPosition(x, y);
            putSensor(x, y);
            addPositionList();
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

    private boolean pitAround(int line, int column) {
        if (positionList.stream().anyMatch(position -> position.getLine() == (line + 1) && position.getColumn() == column))
            return true;
        if (positionList.stream().anyMatch(position -> position.getLine() == (line - 1) && position.getColumn() == column))
            return true;
        if (positionList.stream().anyMatch(position -> position.getLine() == line && position.getColumn() == (column + 1)))
            return true;
        if (positionList.stream().anyMatch(position -> position.getLine() == line && position.getColumn() == (column - 1)))
            return true;
        return false;
    }

    @Override
    public void putSensor(int entityLine, int entityColumn) {
            breeze.setSensorAroundElement(entityLine, entityColumn);
    }

    public void addPositionList() {
        positionList.add(new Position(getLinePosition(), getColumnPosition()));
    }

    public List<Position> getPositionList() {
        return this.positionList;
    }

}
