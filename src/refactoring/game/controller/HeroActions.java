package refactoring.game.controller;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Directions;

public class HeroActions {

    public void walk(int linePosition, int columnPosition, Directions direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            //solicitar ao usuário virar para esquerda ou direita, e tentar novamente (parede true).
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    public void shoot() {
        //utilizar directionOnBoard para saber a direção da flechada
    }
}
