package refactoring.game.controller;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Wumpus;

import static refactoring.game.entities.Cave.*;

public class HeroActions {

    public void walk(int linePosition, int columnPosition, Integer direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            //solicitar ao usuário virar para esquerda ou direita, e tentar novamente (parede true).
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    public void shoot(Wumpus wumpus, Integer heroDirection, int heroLinePosition, int heroColumnPosition) {
        if (wumpus.getLinePosition() == heroLinePosition) {


        } else if (wumpus.getColumnPosition() == heroColumnPosition) {

        }
        // pegar posição do herói
        // pegar posição do wumpus

        // verificar direção
        // verificar se dá match da direção com a posição do wumpus
        // se sim, wumpus morre
        // se nao, segue o jogo
    }

    public Integer turnRight(Integer direction) {
        return (direction + 1) > 3 ? NORTH : direction;
    }

    public int turnLeft(int direction) {
        return (direction - 1) < 0 ? WEST : direction;
    }
}
