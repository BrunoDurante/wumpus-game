package cli;

import kernel.Check;
import kernel.Player;

public class Output {

    public void setText(String output) {
        System.out.println(output);
    }

    public void refreshBoard(String status) {
        setText("\n+----+----+----+----+");
        setText("+----WUMPUSWORLD----+");
        setText("+----+----+----+----+\n");
        setBoard();
        setGameStatus(status);
    }

    private void setBoard() {
        int length = 0;
        int[][] cave = Check.getCave();
        System.out.println("      (0) (1) (2) (3)");
        for (int i = 0; i < 4; i++) {
            System.out.print("(" + i + ")  |");
            for (int j = 0; j < 4; j++) {
                length = String.valueOf(cave[i][j]).length();
                if (length == 1) {
                    System.out.print("  " + cave[i][j] + "|");
                } else if (length == 2) {
                    System.out.print(" " + cave[i][j] + "|");
                } else {
                    System.out.print(cave[i][j] + "|");
                }
            }
            setText("");
        }
    }

    private void setGameStatus(String status) {
        int[] pos = Player.getPosition();
        int x = pos[0];
        int y = pos[1];

        Boolean wumpusAlive = Check.wumpusAlive();
        Boolean hasWumpus = Check.hasWumpus(x, y);
        Boolean hasGold = Check.hasGold(x, y);
        Boolean hasPit = Check.hasPit(x, y);


        setText("\n----------------------------->>> Status"
                + "\n> Remaining arrows: " + Check.arrowAmount()
                + "\n> Is Wumpus alive? " + wumpusAlive.toString()
                + "\n> Did i find the gold? " + hasGold.toString()
                + "\n> My position on the board: " + "[" + x + "," + y + "]"
                + "\n> My current direction: " + Player.getDirection());

        setText("----------------------------->>> Sensors"
                + "\n" + Check.hasSensors(x, y)
                + "\n----------------------------->>>"
        );

        if (hasPit) {
            setText("UUUOOOOOW..... PLOFT!!!! \n"
                    + "\n~~~ You fell in the pit. Your hero is died." + "\n");
        }

        if (!status.isEmpty()) {
            setText("\n~~> Game message: " + status + "\n");
        }

        if (hasWumpus) {
            setText("AAAAAAHHHHHHH!!!! \n"
                    + "\n~~~~ Your Hero is Dead!!\n");
        }
    }

    //TODO método para setar apenas mensagens do game (ex: status, warnings, opções de ação do jogador, etc).

}
