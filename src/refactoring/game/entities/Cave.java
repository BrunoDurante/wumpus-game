package refactoring.game.entities;

public class Cave {
    private String[][] board;
    private int line;
    private int column;

    public Cave() {
        board = new String[4][4];
    }

    public String[][] getBoard() {
        return board;
    }

    public void setElementOnBoard(String element) {
        board[line][column] += element;
    }


}
