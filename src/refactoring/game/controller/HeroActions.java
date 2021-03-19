package refactoring.game.controller;

import refactoring.game.entities.Cave;
import refactoring.game.entities.Wumpus;

import static refactoring.game.entities.Cave.*;

public class HeroActions {

    public void walk(int linePosition, int columnPosition, Integer direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            //solicitar ao usu�rio virar para esquerda ou direita, e tentar novamente (parede true).
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    public void shoot(Wumpus wumpus, Integer heroDirection, int heroLinePosition, int heroColumnPosition) {
        if (wumpus.getLinePosition() == heroLinePosition) {


        } else if (wumpus.getColumnPosition() == heroColumnPosition) {

        }
        // pegar posi��o do her�i
        // pegar posi��o do wumpus

        // verificar dire��o
        // verificar se d� match da dire��o com a posi��o do wumpus
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
