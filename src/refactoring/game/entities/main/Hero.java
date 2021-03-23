package refactoring.game.entities.main;

import refactoring.game.commands.HeroActions;
import refactoring.game.entities.Cave;
import refactoring.game.entities.Codename;
import refactoring.game.entities.Entity;


public class Hero extends Entity {
    private String name;
    private boolean arrow;
    private boolean alive;
    private Integer direction;
    private HeroActions command;

    public Hero(String name) {
        super(3, 0, Codename.HERO);

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

    //TODO continuar
    public void shoot(Wumpus wumpus) {
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
}
