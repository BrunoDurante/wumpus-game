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
     * Lógica de funcionamento do método abaixo.
     * Deve retornar 'true' caso o 'gold' seja bloqueado ao inserir um 'pit'.
     * Caso 'true', o Do While vai gerar novamente novos valores para linha e coluna do 'pit', e testará novamente se
     * bloqueará o 'gold'.
     * <p>
     * Se uma, das 4 posições de acesso ao 'gold' estiver disponível, o método devolve 'false', não interferindo no fluxo
     * de criação do 'pit' no tabuleiro.
     * <p>
     * Sem o método canBeBlocked(), poderíamos ter o seguinte problema:
     * <pre>
     * | |P| | |
     * |P|G|P| |
     * | |W| | |
     * | | | | |
     * </pre>
     * No caso acima, o acesso ao 'gold'(G) é impossível, visto que as células ao redor estão preenchidas com elementos
     * que fazem o jogador perder o jogo caso acessá-las.
     *
     * @param destinationLine   linha destino na matriz do tabuleiro.
     * @param destinationColumn coluna destino na matriz do tabuleiro.
     * @param wumpus            instância do wumpus gerado no jogo.
     * @param pit               instância dos buracos gerados no jogo.
     * @return true ou false
     */
    public boolean canBeBlocked(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        return !(checkCellsAround(destinationLine, destinationColumn, wumpus, pit));
    }

    /**
     * Checa se as células ao redor de Gold estão disponíveis.
     *
     * @param destinationLine   linha destino.
     * @param destinationColumn coluna destino.
     * @param wumpus            instância de Wumpus.
     * @param pit               instância de Pit.
     * @return true se a alguma célula ao redor de Gold estiver disponível, false se não.
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
     * Checa se a posição possui Wumpus ou Pit.
     *
     * @param line   linha a ser checada.
     * @param column coluna a ser checada.
     * @param wumpus instância do Wumpus.
     * @param pit    instância do Pit.
     * @return true se a posição estiver disponível, false se não.
     */
    private boolean isEmpty(int line, int column, Wumpus wumpus, Pit pit) {
        return !(wumpus.exists(line, column) || pit.exists(line, column));
    }

    public Sensor getLight() {
        return light;
    }
}
