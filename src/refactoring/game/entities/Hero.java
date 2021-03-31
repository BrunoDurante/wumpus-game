package refactoring.game.entities;

import refactoring.game.commands.HeroActions;

import java.util.Random;


public class Hero extends Entity {
    private String name;
    private boolean arrow;
    private boolean alive;
    private Integer direction;
    private HeroActions command;

    public Hero(String name) {
        super(Codename.HERO);
        setPosition(3,0);
        arrow = true;
        alive = true;
        direction = Cave.EAST;
        this.name = name;
        command = new HeroActions();
    }

    public void walk() {
        command.walk(line, column, direction);
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


    @Override
    public void putEntityBoard(Random random, Entity... entities) {

    }

    @Override
    protected void putSensor(int linePositionEntity, int columnPositionEntity) {

    }
}
