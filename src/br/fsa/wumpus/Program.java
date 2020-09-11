package br.fsa.wumpus;
import java.util.Scanner;

import br.fsa.wumpus.cli.WumpusCLI;

/* Desenvolvedor: Bruno Durante Cavalcante
 * R.A: 730214
 * Projeto: Wumpus Game
 * Professor: Luis Emilio
 * 09/2020
 * */

public class Program {
	
	public static boolean gamingOn  = true;
	public static boolean winGame = false;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WumpusCLI gameCLI = new WumpusCLI();
		gameCLI.newGame();
		String action = null;
		
		while(gamingOn) {
			System.out.print("Action: ");
			action = sc.next();
			switch(action) {
				case "walk": {
					gameCLI.walk();
					break;
				} 
				case "turnL":{
					gameCLI.turnL();
					break;
				}
				case "turnR":{
					gameCLI.turnR();
					break;
				}
				case "shoot":{
					gameCLI.shoot();
					break;
				}
				default:
					break;
			}
		}
		
		if(winGame) {
			System.out.println("\n\n ******************** VITÓRIA ******************** ");
		} else {
			System.out.println("\n\n ******************** DERROTA ******************** ");
		}
		
		sc.close();
	}

}

