package refactoring.game.entities.main;

import refactoring.game.entities.Codename;
import refactoring.game.entities.Entity;
import refactoring.game.entities.sensor.Light;
import refactoring.game.entities.sensor.Sensor;

import java.util.Random;

import static refactoring.game.entities.Cave.checkLimits;

public class Gold extends Entity {

    public Gold() {
        super(Codename.GOLD);
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
        Sensor light = new Light(linePositionEntity, columnPositionEntity);
        light.setSensorAroundElement();
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
     * que fazem o jogador perder o game, caso acess�-las.
     */

    public boolean canBeBlocked(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        return !(checkCellsAround(destinationLine, destinationColumn, wumpus, pit));
    }

    private boolean checkCellsAround(int destinationLine, int destinationColumn, Wumpus wumpus, Pit pit) {
        //Above gold
        if (checkLimits(line - 1)) {
            if (isEmpty(line - 1, destinationColumn, wumpus, pit)) {
                return true;
            }
        }

        //Below gold
        if (checkLimits(line + 1)) {
            if (isEmpty(line + 1, destinationColumn, wumpus, pit)) {
                return true;
            }
        }

        //Gold right
        if (checkLimits(column + 1)) {
            if (isEmpty(destinationLine, column + 1, wumpus, pit)) {
                return true;
            }
        }

        //Gold left
        if (checkLimits(column - 1)) {
            if (isEmpty(destinationLine, column - 1, wumpus, pit)) {
                return true;
            }
        }
        return false;
    }


    private boolean isEmpty(int line, int column, Wumpus wumpus, Pit pit) {
        return !(wumpus.exists(line, column) || pit.exists(line, column));
    }


}
