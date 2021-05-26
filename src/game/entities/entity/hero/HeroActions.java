package game.entities.entity.hero;

import game.entities.Directions;
import game.entities.Cave;
import game.entities.entity.Wumpus;


public class HeroActions {

    /**
     * Verifica se a posi��o futura do personagem � acess�vel. Se for, realiza a altera��o de posi��o.
     *
     * @param hero inst�ncia da classe Hero.
     * @return true se andou, false se n�o.
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

    public void shoot(Wumpus wumpus, Directions heroDirection, int heroLinePosition, int heroColumnPosition) {
        if (wumpus.getLinePosition() == heroLinePosition || wumpus.getColumnPosition() == heroColumnPosition) {
            if (checkingHeroHitsWumpus(heroDirection, wumpus.getLinePosition(), wumpus.getColumnPosition(), heroLinePosition, heroColumnPosition)) {
                wumpus.killWumpus();
            }
        }
    }

    /**
     * Se a dire��o for EAST(para a Direita do tabuleiro) e a coluna que o Wumpus estiver for maior que a do Her�i, quer dizer que a flecha alcan�ar� o Wumpus.
     * Essa mesma l�gica foi utilizada para todas as posi��es.
     * <pre>
     * Norte - verifico as linhas olhando para cima no tabuleiro.
     * Sul - verifico as linhas olhando para baixo no tabuleiro.
     * Leste - verifico as colunas olhando para a direita no tabuleiro.
     * Oeste - verifico as colunas olhando para a esquerda no tabuleiro.
     *
     * Exemplo:
     * Posi��o do wumpus - [2,3]
     * Posi��o do her�i - [2,0]
     * Dire��o do her�i - EAST
     * </pre>
     * Ambos est�o na mesma linha, e vemos que o Wumpus est� a direita do her�i, pois o valor da coluna � maior.
     * Com isso, se o her�i atirar, acertar� o wumpus, pois est�o na mesma linha, e a dire��o do her�i aponta para onde o wumpus se encontra.
     *
     *
     * @param heroDirection dire��o do her�i.
     * @param wumpusLine    linha no qual Wumpus se encontra.
     * @param wumpusColumn  coluna no qual Wumpus se encontra.
     * @param heroLine      linha no qual her�i se encontra.
     * @param heroColumn    coluna no qual her�i se encontra.
     * @return true se a partir da dire��o do her�i, � poss�vel acertar a flecha no wumpus.
     */
    private boolean checkingHeroHitsWumpus(Directions heroDirection, int wumpusLine, int wumpusColumn, int heroLine, int heroColumn) {
        return ((heroDirection == Directions.EAST && wumpusColumn >= heroColumn) || (heroDirection == Directions.WEST && wumpusColumn <= heroColumn))
                ||
                ((heroDirection == Directions.SOUTH && wumpusLine >= heroLine) || (heroDirection == Directions.NORTH && wumpusLine <= heroLine));
    }

    public Directions turnRight(int direction) {
        return (direction + 1) > 3 ? Directions.NORTH : Directions.getDirection(++direction % 4);
    }

    public Directions turnLeft(int direction) {
        return (direction != 0) ? Directions.getDirection(--direction % 4) : Directions.WEST;
    }
}
