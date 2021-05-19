package game.entities.entity.hero;

import game.entities.Directions;
import game.entities.Cave;
import game.entities.entity.Wumpus;


public class HeroActions {

    /**
     * Verifica se a posição futura do personagem é acessível.
     *
     * @param hero
     * @return
     */
    public boolean walk(Hero hero) {
        if (Cave.isWall(hero.getLinePosition(), hero.getColumnPosition(), hero.getDirection().getValue())) {
            System.out.println("~ You hit the wall.");
            return false;
        } else {
            updatePosition(hero);
            return true;
        }
    }

    private void updatePosition(Hero hero) {
        removeElementCurrentPosition(hero);
        walkToNewPosition(hero);
    }

    private void removeElementCurrentPosition(Hero hero) {
        Cave.removeElementBoard(hero.getLinePosition(), hero.getColumnPosition(), hero.getCodename());
    }

    private void walkToNewPosition(Hero hero) {
        switch (hero.getDirection()) {
            case NORTH: {
                hero.setPosition(hero.getLinePosition() - 1, hero.getColumnPosition());
                break;
            }
            case EAST: {
                hero.setPosition(hero.getLinePosition(), hero.getColumnPosition() + 1);
                break;
            }
            case SOUTH: {
                hero.setPosition(hero.getLinePosition() + 1, hero.getColumnPosition());
                break;
            }
            case WEST: {
                hero.setPosition(hero.getLinePosition(), hero.getColumnPosition() - 1);
                break;
            }
        }
    }

    /*
    0 0 0 0
    0 0 0 0
    0 0 0 0
    0 H 0 W
     */
    public void shoot(Wumpus wumpus, Directions heroDirection, int heroLinePosition, int heroColumnPosition) {
        if (wumpus.getLinePosition() == heroLinePosition || wumpus.getColumnPosition() == heroColumnPosition) {
            if (checkingHeroHitsWumpus(heroDirection, wumpus.getLinePosition(), wumpus.getColumnPosition(), heroLinePosition, heroColumnPosition)) {
                wumpus.killWumpus();
            }
        }
    }

    /**
     * Se a direção for EAST(para a Direita do tabuleiro) e a coluna que o Wumpus estiver for maior que a do Herói, quer dizer que a flecha alcançará o Wumpus.
     * Essa mesma lógica foi utilizada para todas as posições.
     * Norte - verifico as linhas olhando para cima no tabuleiro.
     * Sul - verifico as linhas olhando para baixo no tabuleiro.
     * Leste - verifico as colunas olhando para a direita no tabuleiro.
     * Oeste - verifico as colunas olhando para a esquerda no tabuleiro.
     * Exemplo:
     * Posição do wumpus - [2,3]
     * Posição do herói - [2,0]
     * Direção do herói - EAST
     * <p>
     * Ambos estão na mesma linha, e vemos que o Wumpus está a direita do herói, pois o valor da coluna é maior.
     * Com isso, se o herói atirar, acertará o wumpus, pois estão na mesma linha, e a direção do herói aponta para onde o wumpus se encontra.
     *
     * @param heroDirection
     * @param wumpusLine
     * @param wumpusColumn
     * @param heroLine
     * @param heroColumn
     * @return
     */
    private boolean checkingHeroHitsWumpus(Directions heroDirection, int wumpusLine, int wumpusColumn, int heroLine, int heroColumn) {
        if ((heroDirection == Directions.EAST && wumpusColumn >= heroColumn) ||
                (heroDirection == Directions.WEST && wumpusColumn <= heroColumn)) {
            return true;

        } else if ((heroDirection == Directions.SOUTH && wumpusLine >= heroLine) ||
                (heroDirection == Directions.NORTH && wumpusLine <= heroLine)) {
            return true;
        }
        return false;
    }

    public Directions turnRight(int direction) {
        return (direction + 1) > 3 ? Directions.NORTH : Directions.getDirection(++direction % 4);
    }

    public Directions turnLeft(int direction) {
        return (direction != 0) ? Directions.getDirection(--direction % 4) : Directions.WEST;
    }
}
