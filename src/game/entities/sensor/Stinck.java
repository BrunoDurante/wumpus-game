package game.entities.sensor;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;

public class Stinck extends Sensor {

    public Stinck() {
        super(Codename.S);
    }

    public static void getResponse() {
        System.out.println("\n~ Yuck!! What a stench! Wumpus must be around here.");
    }

    @Override
    public void setPosition(int line, int column) {
        this.positionList.add(new Position(line, column));
        Cave.setElementOnBoard(line, column, codename.name());
    }

}
