package refactoring.game.entities;

import refactoring.game.controller.HeroActions;

public class Hero {
    private String name;
    private boolean arrow;
    private boolean alive;
    private int directionOnBoard;
    private HeroActions command;

    private int linePosition;
    private int columnPosition;

    public Hero(String name) {
        this.name = name;
        arrow = true;
        alive = true;
        directionOnBoard = Cave.EAST;
        command = new HeroActions();
    }

    public void walk() {
        command.walk(linePosition, columnPosition, directionOnBoard);
    }

    public void turnR() {
        directionOnBoard = command.turnRight(directionOnBoard);
    }

    public void turnL() {
        directionOnBoard = command.turnLeft(directionOnBoard);
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

    public int getDirectionOnBoard() {
        return directionOnBoard;
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
