package game.entities.sensor;

import game.entities.Cave;
import game.entities.Codename;
import game.entities.Position;

public class Breeze extends Sensor {

    public Breeze() {
        super(Codename.B);
    }

    public static void getResponse() {
        System.out.println("\n~ What's that breeze? There must be a pit nearby.");
    }

    @Override
    public void setPosition(int line, int column) {
        if (this.getPositionList().stream().noneMatch(position -> position.getLine() == line && position.getColumn() == column)) {
            this.positionList.add(new Position(line, column));
            Cave.setElementOnBoard(line, column, codename.name());
        }
    }
}
