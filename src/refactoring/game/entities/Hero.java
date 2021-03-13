package refactoring.game.entities;

import refactoring.game.controller.HeroActions;

import static refactoring.game.entities.Directions.*;

public class Hero {
    private String name;
    private boolean arrow;
    private boolean alive;
    private Directions directionOnBoard;
    private HeroActions command;

    private int linePosition;
    private int columnPosition;

    public Hero(String name) {
        this.name = name;
        arrow = true;
        alive = true;
        directionOnBoard = EAST;
        command = new HeroActions();
    }

    public void walk() {
        command.walk(linePosition, columnPosition, directionOnBoard);
    }

    public void turnR() {

    }

    public void turnL() {

    }

    public void shoot() {
        //utilizar directionOnBoard para saber a direção da flechada
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

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Directions getDirectionOnBoard() {
        return directionOnBoard;
    }

    public void setDirectionOnBoard(Directions directionOnBoard) {
        this.directionOnBoard = directionOnBoard;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public int getLinePosition() {
        return linePosition;
    }

    public void setPosition(int linePosition, int columnPosition) {
        this.linePosition = linePosition;
        this.columnPosition = columnPosition;
    }

}
