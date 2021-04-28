package refactoring.game.entities;

import refactoring.game.Directions;
import refactoring.game.commands.HeroActions;

import java.util.Random;


public class Hero extends Entity {
    private final String name;
    private boolean arrow;
    private boolean alive;
    private int direction;
    private HeroActions command;
    public Boolean[][] visitedPlace;


    public Hero(String name) {
        super(Codename.H);
        visitedPlace = new Boolean[4][4];
        setPosition(3, 0);
        initializeVisitedPlace();
        visitedPlace[3][0] = true;
        arrow = true;
        alive = true;
        direction = Directions.EAST.getValue();
        this.name = name;
        command = new HeroActions();
    }

    public void walk() {
        if (command.walk(this)) {
            updatePosition();
            setVisitedPlace();
        }
    }

    private void updatePosition() {
        removeElement();
        switch (direction) {
            case 0: {
                setPosition(getLinePosition() - 1, getColumnPosition());
                break;
            }
            case 1: {
                setPosition(getLinePosition(), getColumnPosition() + 1);
                break;
            }
            case 2: {
                setPosition(getLinePosition() + 1, getColumnPosition());
                break;
            }
            case 3: {
                setPosition(getLinePosition(), getColumnPosition() - 1);
                break;
            }
        }
    }

    public void turnRight() {
        direction = command.turnRight(direction);
    }

    public void turnLeft() {
        direction = command.turnLeft(direction);
    }

    public void shoot(Entity wumpus) {
        if (arrow) {
            command.shoot(wumpus, direction, line, column);
            arrow = false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean hasArrow() {
        return arrow;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getDirection() {
        return direction;
    }

    public String getDirectionFormatted() {
        return Directions.getDirectionName(direction);
    }

    public String getPositionFormatted() {
        String columnStr = "";
        switch (column) {
            case 0: {
                columnStr = "A";
                break;
            }
            case 1: {
                columnStr = "B";
                break;
            }
            case 2: {
                columnStr = "C";
                break;
            }
            case 3: {
                columnStr = "D";
                break;
            }
        }
        return line + "," + columnStr;
    }

    private void initializeVisitedPlace() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                visitedPlace[i][j] = false;
            }
        }
    }

    public void setVisitedPlace() {
        visitedPlace[getLinePosition()][getColumnPosition()] = true;
    }

    public Boolean wasVisited(int lineX, int columnY) {
        return visitedPlace[lineX][columnY];
    }

    @Override
    public void putEntityBoard(Random random, Entity... entities) {

    }

    @Override
    protected void putSensor(int linePositionEntity, int columnPositionEntity) {

    }
}
