package game.entities.entity;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;
import game.entities.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Entity {
    protected int line;
    protected int column;
    protected Codename codename;
    protected List<Position> positionList;

    public Entity(Codename codename) {
        this.codename = codename;
        positionList = new ArrayList<>();
    }

    /**
     * @return coluna no qual a entidade está.
     */
    public int getColumnPosition() {
        return column;
    }

    /**
     * @return linha no qual a entidade está.
     */
    public int getLinePosition() {
        return line;
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
        this.line = line;
        this.column = column;
        addPosition();
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
        return this.line == line && this.column == column;
    }

    public void addPosition() {
        this.positionList.add(new Position(line, column));
    }

    public List<Position> getPositionList() {
        return this.positionList;
    }

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
