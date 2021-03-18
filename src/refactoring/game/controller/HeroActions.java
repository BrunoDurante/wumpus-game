package refactoring.game.controller;

import refactoring.game.entities.Cave;

public class HeroActions {

    public void walk(int linePosition, int columnPosition, Integer direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            //solicitar ao usuário virar para esquerda ou direita, e tentar novamente (parede true).
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    public void shoot() {
        //utilizar direction para saber a direção da flechada
    }

    public Integer turnRight(Integer direction) {
        return (direction + 1) > 3 ? Cave.NORTH : direction;
    }

    public int turnLeft(int direction) {
       return (direction - 1) < 0 ? Cave.WEST : direction;
    }
}
