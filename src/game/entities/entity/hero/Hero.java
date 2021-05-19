package game.entities.entity.hero;

import game.entities.Directions;

import static game.entities.Directions.EAST;

import game.entities.Codename;
import game.entities.entity.Entity;
import game.entities.entity.Wumpus;

import java.util.Random;

public class Hero extends Entity {
    private final String name;
    private boolean arrow;
    private Directions direction;
    private final HeroActions command;
    public Boolean[][] visitedPlace;

    public Hero(String name) {
        super(Codename.H);
        this.name = name;
        setPosition(3, 0);
        initializeVisitedPlace();
        arrow = true;
        direction = EAST;
        command = new HeroActions();
    }

    /**
     * Método responsável por fazer o personagem caminhar pelo tabuleiro. Se o personagem caminhou,
     * o método setVisitedPlace é invocado para atualizar o que é visível no board.
     */
    public void walk() {
        if (command.walk(this))
            setVisitedPlace();
    }

    /**
     * Método responsável por fazer o personagem virar-se à direita no tabuleiro.
     * Se o personagem está para EAST, ao chamar o método turnRight(), sua direção se torna SOUTH.
     * A troca de direção para a direita é baseada em sentido horário.
     *
     * <pre>
     *      NORTH
     * WEST   .   EAST
     *      SOUTH
     * </pre>
     */
    public void turnRight() {
        direction = command.turnRight(direction.getValue());
    }

    /**
     * Método responsável por fazer o personagem virar-se à esquerda no tabuleiro.
     * Se o personagem está para EAST, ao chamar o método turnLeft(), sua direção se torna NORTH.
     * A troca de direção para a direita é baseada em sentido anti-horário.
     *
     * <pre>
     *      NORTH
     * WEST   .   EAST
     *      SOUTH
     * </pre>
     */
    public void turnLeft() {
        direction = command.turnLeft(direction.getValue());
    }

    /**
     * Responsável por flechar. Recebe a instância de Wumpus para utilizar sua posição.
     * Se arrow for true, ele realiza a flechada.
     *
     * @param wumpus objeto referente ao Wumpus.
     */
    public void shoot(Wumpus wumpus) {
        if (arrow) {
            command.shoot(wumpus, direction, line, column);
            arrow = false;
        }
    }

    /**
     * Responsável por retornar o nome do herói.
     *
     * @return nome.
     */
    public String getName() {
        return name;
    }

    /**
     * @return true se o herói possuir a flecha, false se não.
     */
    public boolean hasArrow() {
        return arrow;
    }

    /**
     * @return Direção do herói, tipada no Enum {@link Directions}.
     */
    public Directions getDirection() {
        return direction;
    }


    /**
     * Responsável por retornar a posição do herói formatada para a visão do tabuleiro.
     * O retorno é inserido no método <strong>showStatus()</strong> na classe {@link game.Config}.
     * <br>
     * Exemplo:
     * <pre>
     * posição na matriz - 3,0
     * posição formatada - 3,A
     * </pre>
     */
    public String getPositionFormatted() {
        String columnStr = "";
        switch (column) {
            case 0: {
                columnStr = "A";
                break;
            }
            case 1: {
                columnStr = "B";
                break;
            }
            case 2: {
                columnStr = "C";
                break;
            }
            case 3: {
                columnStr = "D";
                break;
            }
        }
        return line + "," + columnStr;
    }

    private void initializeVisitedPlace() {
        visitedPlace = new Boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                visitedPlace[i][j] = false;
            }
        }
        visitedPlace[3][0] = true;
    }

    private void setVisitedPlace() {
        visitedPlace[getLinePosition()][getColumnPosition()] = true;
    }

    /**
     * Responsável por retornar se a posição recebida já foi visitada pelo herói.
     * Através desse método, toda a informação do tabuleiro é ocultada no console.
     *
     * @param line   linha a ser checada
     * @param column coluna a ser checada
     * @return true ou false
     */
    public Boolean wasVisited(int line, int column) {
        return visitedPlace[line][column];
    }

    @Override
    protected void putEntityBoard(Random random, Entity... entities) {

    }

    @Override
    protected void putSensor(int linePositionEntity, int columnPositionEntity) {

    }
}
