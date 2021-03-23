package refactoring.game.entities;

public abstract class Entity {
    public int line;
    public int column;
    public Codename codename;

    public Entity(int line, int column, Codename codename){
        this.line = line;
        this.column = column;
        this.codename = codename;
    }

    public int getColumnPosition() {
        return column;
    }

    public int getLinePosition() {
        return line;
    }

    public void setPosition(int linePosition, int columnPosition) {
        this.line = linePosition;
        this.column = columnPosition;
        Cave.setElementOnBoard(line, column, codename.name());
    }
}
