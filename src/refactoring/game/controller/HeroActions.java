package refactoring.game.controller;

import refactoring.game.entities.Cave;

public class HeroActions {

    public void walk(int linePosition, int columnPosition, int direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            //solicitar ao usu�rio virar para esquerda ou direita, e tentar novamente (parede true).
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    public void shoot() {
        //utilizar directionOnBoard para saber a dire��o da flechada
    }

    public int turnRight(int direction) {
        direction = direction + 1;
        if (direction > 3) {
            return Cave.NORTH;
        } else {
            return direction;
        }
    }

    public int turnLeft(int direction) {
        direction = direction - 1;
        if (direction < 0) {
            return Cave.WEST;
        } else {
            return direction;
        }
    }
}
