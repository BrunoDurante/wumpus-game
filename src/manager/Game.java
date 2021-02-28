package manager;

import cli.CommandLine;

import static kernel.Check.checkEndGame;

import kernel.Kernel;


public class Game {

    public static Kernel kernel;
    public CommandLine cli;

    public static boolean endGame;
    public static boolean wonGame;


    public void newGame() {
        cli = new CommandLine();
        kernel = new Kernel();
        endGame = false;
        wonGame = false;
        startGame();
    }

    private void startGame() {
        controller();
    }

    private void controller() {
        while (!endGame) {
            cli.setAction(cli.getCommand());
            checkEndGame();
        }
        cli.closeScanner();
        finishGame();
    }

    private void finishGame() {
        if (wonGame) {
            cli.setText("\n\n ******************** VITÓRIA ******************** ");
        } else {
            cli.setText("\n\n ******************** DERROTA ******************** ");
        }
    }


    //TODO método para visualizar ou não a prova real do jogo (localização dos elementos).
    //TODO método responsável por setar no output regras do jogo, apresentação, título, etc.
}
