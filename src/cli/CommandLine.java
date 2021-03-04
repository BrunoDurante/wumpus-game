package cli;

import kernel.Action;

import java.util.Scanner;

public class CommandLine {

    public Scanner sc;
    public Action action;
    public Output output;

    public CommandLine() {
        sc = new Scanner(System.in);
        action = new Action();
        output = new Output();
    }

    public String getCommand() {
        System.out.print("\n: ");
        return sc.next();
    }

    //TODO ajustar comandos e tratá-los com regex.
    public void setAction(String command) {
        switch(command.toUpperCase()) {
            case "WK": {
                setBoard(action.walk());
                break;
            }
            case "TL":{
                action.turnL();
                setBoard("Turned left.");
                break;
            }
            case "TR":{
                action.turnR();
                setBoard("Turned right.");
                break;
            }
            case "SHOOT":{
                if(action.shoot()){
                    setText("\n~~~ Arrow Shot.... YEAH!!! You hit Wumpus !!!!");
                }else {
                    setText("\n~~~ Arrow Shot.... You Missed !!! ");
                }
                break;
            }
            default:
                setText("\nUnknown command, please type again.");
                break;
        }
    }

    public void setBoard(String status){
        output.refreshBoard(status);
    }

    public void setText(String text){
        output.setText(text);
    }

    public void closeScanner(){
        sc.close();
    }

}

