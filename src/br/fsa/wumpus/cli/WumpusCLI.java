package br.fsa.wumpus.cli;

import br.fsa.wumpus.Program;
import br.fsa.wumpus.interfaces.WumpusGame;
import br.fsa.wumpus.kernel.Kernel;

public class WumpusCLI implements WumpusGame {

	Kernel game;
	public static final boolean Debug = true;

	public void winGame() {
		Program.gamingOn = false;
		Program.winGame = true;
	}
	
	public void loseGame() {
		Program.gamingOn = false;
		Program.winGame = false;
	}
	
	@Override
	public void newGame() {
		game = new Kernel();
		refreshBoard("");
	}

	
	// BEGIN BLOCK 'PLAYER ACTIONS'
	@Override
	public void turnL() {
		game.turnL();
		refreshBoard("");
	}

	@Override
	public void turnR() {
		game.turnR();
		refreshBoard("");
	}

	public void walk() {
		String status = game.walk();
		refreshBoard(status);
	}
	
	@Override
	public boolean shoot() {
		boolean onTarget = game.shoot(game.getDir());
		if (onTarget) {
			System.out.println("\n~~~ Arrow Shot.... YEAH!!! I hit Wumpus !!!!");
			winGame();
			return true;
		} else {
			System.out.println("\n~~~ Arrow Shot.... I Missed !!! ");
			return false;
		}
	}
	// END BLOCK 'PLAYER ACTIONS'

	
	// BEGIN BLOCK 'HAS---'
	public String hasGold(int x, int y) {
		boolean hasGold = game.hasGold(x, y);
		if (hasGold) {
			winGame();
			return "  *******  GOLD FOUND  *******";
		} else {
			return "Not Found";
		}
	}
	
	public String wumpusAlive() {
		if(game.hasWumpus(Kernel.localWumpus[0], Kernel.localWumpus[1])) {
			return "Alive";
		} else {
			return "Died";
		}
	}

	public String hasWumpus(int x, int y) {
		boolean hasWumpus = game.hasWumpus(x, y);
		if (hasWumpus) {
			loseGame();
			return "~~~~ AAAAAAHHHHHHH!!!! \n"
					+ "  \nYour Hero is Dead!!\n";
		} else {
			return "";
		}
	}

	public int hasArrow() {
		boolean hasArrow = game.hasArrow();
		if (hasArrow) {
			return 1;
		} else {
			return 0;
		}
	}

	public String hasSensors(int x, int y) {
		String[] vectSensor = game.hasSensor(x, y);
		int i = 0;
		String status = "\n";
		while (i <= 2) {
			switch (vectSensor[i]) {
			case "B": {
				status += "  ~~~~~~  RUUUUIIIUUUU!! There's a pit nearby.  ~~~~~~ \n";
				break;
			}
			case "F": {
				status += "  ~~~~~~  YUUUCK! I smell Wumpus.  ~~~~~~ \n";
				break;
			}
			case "C":{
				status += "  ****  OHHH! I can already see the gold shine!  ****  \n";
				break;
			}
			default:
				break;
			}
			i++;
		}

		if (status.equals("")) {
			status = "Nothing around here...";
		}

		return status;
	}

	public String hasPit(int x, int y) {
		boolean hasPit = game.hasPit(x, y);
		if (hasPit) {
			loseGame();
			return "UUUOOOOOW..... PLOFT!!!! \n"
					+ "\n~~~~~ You fell in the pit. Your hero is died.";
		} else {
			return "";
		}
	}
	// END BLOCK 'HAS---'	
	
	
	public String getDir() {
		switch (game.getDir()) {
		case 0:
			return "NORTH";
		case 1:
			return "EAST";
		case 2:
			return "SOUTH";
		case 3:
			return "WEST";
		default:
			return "Position not found.";
		}
	}
	
	public int[] getPlayerPos() {
		int[] r = game.getPlayerPos();
		return r;
	}

	
	private void refreshBoard(String status) {
		System.out.println("\n+----WUMPUSWORLD----+");
		System.out.println("+----+----+----+----+\n");

		int length = 0;
		int[][] cave = game.getCave();
		for (int i = 0; i < 4; i++) {
			System.out.print(" |");
			for (int j = 0; j < 4; j++) {
				length = String.valueOf(cave[i][j]).length();
				if (length == 2) {
					System.out.print(cave[i][j] + "|");
				} else {
					System.out.print(cave[i][j] + " |");
				}
			}
			System.out.println();
		}

		int[] pos = getPlayerPos();
		int x = pos[0];
		int y = pos[1];		

		String hasG = hasGold(x,y);
		
		System.out.println("\n      Arrow: " + hasArrow() 
				+ "\n     Wumpus: " + wumpusAlive() 
				+ "\n       Gold: "	+ hasG
				+ "\n   Position: " + "[" + x + "," + y + "]"
				+ "\n  Direction: " + getDir() 
				+ "\n    Sensors: \n" + hasSensors(x, y)
				);
		
		String hasP = hasPit(x, y);
		if(!hasP.isEmpty()) {
			System.out.println("~~~~~ " + hasP + "\n");
		}
		
		if(!status.isEmpty()) {
			System.out.println("~~> Warning: " + status + "\n");
		}
		
		String hasW = hasWumpus(x, y);
		if(!hasW.isEmpty()) {
			System.out.println(hasW);
		}
		
		if(!hasG.equals("Not Found")) {
			System.out.println(hasG + "\n");
		}
		
		
	}

}
