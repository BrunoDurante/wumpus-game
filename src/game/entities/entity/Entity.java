package game.entities.entity;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;
import game.entities.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Entity {
    protected Position position;
    protected Codename codename;

    public Entity(Codename codename) {
        this.codename = codename;
        position = new Position();
    }

    public int getLinePosition() {
        return position.getLine();
    }

    public int getColumnPosition() {
        return position.getColumn();
    }

    /**
     * @return o {@link Codename} da entidade.
     */
    public Codename getCodename() {
        return codename;
    }

    /**
     * Atualiza a linha e coluna da entidade, e insere na matriz.
     *
     * @param line   linha no qual será inserido
     * @param column coluna no qual será inserido
     */
    public void setPosition(int line, int column) {
        position.setLine(line);
        position.setColumn(column);
        Cave.setElementOnBoard(line, column, codename.toString());
    }

    /**
     * Verifica se existe a entidade na posição recebida.
     *
     * @param line   linha a ser verificada.
     * @param column coluna a ser verificada.
     * @return true ou false
     */
    public boolean exists(int line, int column) {
        return position.getLine() == line && position.getColumn() == column;
    }

    protected abstract Sensor getSensor();

    /**
     * Insere a entidade no tabuleiro.
     *
     * @param random   instância de Random para gerar valores aleatórios.
     * @param entities uma ou n entidades.
     */
    protected abstract void putEntityBoard(Random random, Entity... entities);

    /**
     * Insere o sensor no tabuleiro.
     *
     * @param linePositionEntity   linha no qual a entidade está.
     * @param columnPositionEntity coluna no qual a entidade está.
     */
    protected abstract void putSensor(int linePositionEntity, int columnPositionEntity);


}
