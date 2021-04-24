package refactoring.game.commands;

import refactoring.game.Directions;
import refactoring.game.entities.Cave;
import refactoring.game.entities.Entity;
import refactoring.game.entities.main.Wumpus;

import static refactoring.game.entities.Cave.*;

public class HeroActions {

    public void walk(int linePosition, int columnPosition, int direction) {
        if (Cave.isWall(linePosition, columnPosition, direction)) {
            System.out.println("~ You hit the wall.");
        } else {
            Cave.setElementOnBoard(linePosition, columnPosition, "H");
        }
    }

    /*
    0 0 0 0
    0 0 0 0
    0 0 0 0
    0 H 0 W
     */
    public void shoot(Entity wumpus, Integer heroDirection, int heroLinePosition, int heroColumnPosition) {
        if (wumpus.getLinePosition() == heroLinePosition) {
            //pegar a dire��o do hero
            //

        } else if (wumpus.getColumnPosition() == heroColumnPosition) {

        }
        // pegar posi��o do her�i
        // pegar posi��o do wumpus

        // verificar dire��o
        // verificar se d� match da dire��o com a posi��o do wumpus
        // se sim, wumpus morre
        // se nao, segue o jogo
    }

    public int turnRight(int direction) {
        return (direction + 1) > 3 ? Directions.NORTH.valueOnBoard : direction;
    }

    public int turnLeft(int direction) {
        return (direction - 1) < 0 ? Directions.WEST.valueOnBoard : direction;
    }
}
