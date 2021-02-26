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
        System.out.print("Action: ");
        return sc.next();
    }

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
            case "SH":{
                if(action.shoot()){
                    output.setText("\n~~~ Arrow Shot.... YEAH!!! You hit Wumpus !!!!");
                }else {
                    output.setText("\n~~~ Arrow Shot.... You Missed !!! ");
                }
                break;
            }
            default:
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

