package refactoring.game;

import java.util.Scanner;

public class Config {

    public String inputNameHero(Scanner sc) {
        System.out.print("~ Hero name\n:");
        return sc.next();
    }

    public void showIntro(){
        System.out.println("Intro do game.");
    }

    public void showBoardElements(){
        System.out.println("");
    }
}
