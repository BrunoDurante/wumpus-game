package game.entities.entity;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.sensor.Light;
import game.entities.sensor.Sensor;

import java.util.Random;

public class Gold extends Entity {

    private Sensor light;

    public Gold() {
        super(Codename.G);
        light = new Light();
    }

    @Override
    public void putEntityBoard(Random random, Entity... entities) {
        int x;
        int y;
        do {
            x = random.nextInt(4);
            y = random.nextInt(4);
        } while (x >= 2 && y < 2 || (x < 2 && y >= 2));
        setPosition(x, y);
        putSensor(x, y);

    }

    @Override
    public void putSensor(int linePositionEntity, int columnPositionEntity) {
        light.setSensorAroundElement(linePositionEntity, columnPositionEntity);
    }

    /**
     * L�gica de funcionamento do m�todo abaixo.
     * Deve retornar 'true' caso o 'gold' seja bloqueado ao inserir um 'pit'.
     * Caso 'true', o Do While vai gerar novamente novos valores para linha e coluna do 'pit', e testar� novamente se
     * bloquear� o 'gold'.
     * <p>
     * Se uma, das 4 posi��es de acesso ao 'gold' estiver dispon�vel, o m�todo devolve 'false', n�o interferindo no fluxo
     * de cria��o do 'pit' no tabuleiro.
     * <p>
     * Sem o m�todo canBeBlocked(), poder�amos ter o seguinte problema:
     * <pre>
     * | |P| | |
     * |P|G|P| |
     * | |W| | |
     * | | | | |
     * </pre>
     * No caso acima, o acesso ao 'gold'(G) � imposs�vel, visto que as c�lulas ao redor est�o preenchidas com elementos
     * que fazem o jogador perder o jogo caso acess�-las.
     *
     * @param destinationLine   linha destino na matriz do tabuleiro.
     * @param destinationColumn coluna destino na matriz do tabuleiro.
     * @param wumpus            inst�ncia do wumpus gerado no jogo.
     * @param pit               inst�ncia dos buracos gerados no jogo.
     * @return true ou false
     */
    public boolean canBeBlocked(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        return !(checkCellsAround(destinationLine, destinationColumn, wumpus, pit));
    }

    /**
     * Checa se as c�lulas ao redor de Gold est�o dispon�veis.
     *
     * @param destinationLine   linha destino.
     * @param destinationColumn coluna destino.
     * @param wumpus            inst�ncia de Wumpus.
     * @param pit               inst�ncia de Pit.
     * @return true se a alguma c�lula ao redor de Gold estiver dispon�vel, false se n�o.
     */
    private boolean checkCellsAround(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        //Above gold
        if (Cave.checkLimits(line - 1)) {
            if (isEmpty(line - 1, destinationColumn, wumpus, pit)) {
                return true;
            }
        }

        //Below gold
        if (Cave.checkLimits(line + 1)) {
            if (isEmpty(line + 1, destinationColumn, wumpus, pit)) {
                return true;
            }
        }

        //Gold right
        if (Cave.checkLimits(column + 1)) {
            if (isEmpty(destinationLine, column + 1, wumpus, pit)) {
                return true;
            }
        }

        //Gold left
        if (Cave.checkLimits(column - 1)) {
            if (isEmpty(destinationLine, column - 1, wumpus, pit)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checa se a posi��o possui Wumpus ou Pit.
     *
     * @param line   linha a ser checada.
     * @param column coluna a ser checada.
     * @param wumpus inst�ncia do Wumpus.
     * @param pit    inst�ncia do Pit.
     * @return true se a posi��o estiver dispon�vel, false se n�o.
     */
    private boolean isEmpty(int line, int column, Wumpus wumpus, Pit pit) {
        return !(wumpus.exists(line, column) || pit.exists(line, column));
    }

    public Sensor getLight() {
        return light;
    }
}
