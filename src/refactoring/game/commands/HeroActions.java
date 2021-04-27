package refactoring.game.commands;

import refactoring.game.Directions;
import refactoring.game.entities.Cave;
import refactoring.game.entities.Entity;
import refactoring.game.entities.Hero;
import refactoring.game.entities.main.Wumpus;

import static refactoring.game.entities.Cave.*;

public class HeroActions {

    public boolean walk(Hero hero) {
        if (Cave.isWall(hero.getLinePosition(), hero.getColumnPosition(), hero.getDirection())) {
            System.out.println("~ You hit the wall.");
            return false;
        } else {
            return true;
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
        return (direction + 1) > 3 ? Directions.NORTH.getValue() : ++direction % 4;
    }

    public int turnLeft(int direction) {
        return (direction != 0) ? --direction % 4 : Directions.WEST.getValue();
    }
}
