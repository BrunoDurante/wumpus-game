package refactoring.game.controller;

import refactoring.game.entities.Cave;

public class HeroActions implements PlayerCommand {

    @Override
    public void walk(int linePosition, int columnPosition, int direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            //solicitar ao usuário virar para esquerda ou direita, e tentar novamente (parede true).
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    @Override
    public void shoot() {
        //utilizar direction para saber a direção da flechada
    }

    @Override
    public int turnRight(int direction) {
        direction++;
        return direction > 3 ? Cave.NORTH : direction;
    }

    @Override
    public int turnLeft(int direction) {
        direction--;
        return direction < 0 ? Cave.WEST : direction;
    }
}
