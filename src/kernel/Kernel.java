package kernel;

import java.util.*;

public class Kernel {

	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;
	public final int NORTH = 0;
	public final int J = 1 << 0; // Jogador
	public final int G = 1 << 1; // Gold
	public final int W = 1 << 2; // Wumpus
	public final int P = 1 << 3; // Pit
	public final int B = 1 << 4; // Brisa
	public final int F = 1 << 5; // Fedor
	public final int C = 1 << 6; // Cintilância

	public Random random;
	private int[][] cave;
	private boolean arrow;
	private int dir;
	private boolean wumpus;

	public static int[] localWumpus = { 0, 0 };
	public static int[] localGold = { 0, 0 };

	public Kernel() {
		cave = new int[4][4];
		arrow = true;
		wumpus = true;
		dir = EAST;
		random = new Random();
		newGame();
	}

	private void newGame() {
		cave[3][0] |= J;
		startBoard();
	}

	private void startBoard() {
		putGold();
		putWumpus();
		putPit();
	}

	private void putGold() {
		int x = 0;
		int y = 0;
		do {
			x = random.nextInt(4);
			y = random.nextInt(4);
		} while (x >= 2 && y < 2 || (x < 2 && y >= 2));
		cave[x][y] |= G;
		localGold[0] = x;
		localGold[1] = y;
		System.out.println("G=" + G + "; cave[" + x + "][" + y + "] |= G");
		putSensors(x, y, C);
	}

	private void putWumpus() {
		int x = 0;
		int y = 0;
		do {
			x = random.nextInt(4);
			y = random.nextInt(4);
		} while (x >= 2 && y < 2 || (x < 2 && y >= 2) || hasGold(x, y));
		cave[x][y] |= W;
		localWumpus[0] = x;
		localWumpus[1] = y;
		System.out.println("W=" + W + "; cave[" + x + "][" + y + "] |= W");
		putSensors(x, y, F);
	}

	private void putPit() {
		int count = 1;
		int x = 0;
		int y = 0;
		while (count <= 3) {
			do {
				x = random.nextInt(4);
				y = random.nextInt(4);
			} while (x >= 2 && y < 2 || (x < 2 && y >= 2) || hasGold(x, y) || hasWumpus(x, y) || hasPit(x, y)
					|| checkAroundGold(x, y));

			cave[x][y] |= P;
			System.out.println("P=" + P + "; cave[" + x + "][" + y + "] |= P");
			putSensors(x, y, B);
			count++;
		}
	}

	// Método para não bloquear Gold
	private boolean checkAroundGold(int x, int y) {
		int xG = localGold[0];
		int yG = localGold[1];
		int countElement = 0;
		int countCelDisp = 0;

		// left
		yG--;
		if (yG >= 0 && yG < 4) {
			countCelDisp++;
			if (hasPit(x, yG)) {
				countElement++;
			}
			if (hasWumpus(x, yG)) {
				countElement++;
			}
		}
		yG++;

		// right
		yG++;
		if (yG >= 0 && yG < 4) {
			countCelDisp++;
			if (hasPit(x, yG)) {
				countElement++;
			}
			if (hasWumpus(x, yG)) {
				countElement++;
			}
		}
		yG--;

		// bottom
		xG++;
		if (xG >= 0 && xG < 4) {
			countCelDisp++;
			if (hasPit(xG, y)) {
				countElement++;
			}
			if (hasWumpus(xG, y)) {
				countElement++;
			}
		}
		xG--;

		// top
		xG--;
		if (xG >= 0 && xG < 4) {
			countCelDisp++;
			if (hasPit(xG, y)) {
				countElement++;
			}
			if (hasWumpus(xG, y)) {
				countElement++;
			}
		}
		xG++;

		if ((countElement + 1) >= countCelDisp) {
			return true;
		} else {
			return false;
		}

	}

	private void putJogador(int x, int y) {
		cave[x][y] |= J;
	}

	private void putSensors(int x, int y, int CONST) {
		// w
		y--;
		if (y >= 0 && y < 4) {
			cave[x][y] |= CONST;
		}
		y++;

		// e
		y++;
		if (y >= 0 && y < 4) {
			cave[x][y] |= CONST;
		}
		y--;

		// s
		x++;
		if (x >= 0 && x < 4) {
			cave[x][y] |= CONST;
		}
		x--;

		// n
		x--;
		if (x >= 0 && x < 4) {
			cave[x][y] |= CONST;
		}

	}

	public boolean shoot(int dir) {
		if (arrow) {
			arrow = false;
			if (onTarget(dir)) {
				return true;
			}
		}
		return false;
	}

	private boolean onTarget(int dir) {
		int[] pos = getPlayerPosition();
		int x = pos[0];
		int y = pos[1];
		boolean onTarget = false;

		switch (dir) {
		case NORTH: {
			while (x >= 0) {
				onTarget = hasWumpus(x, y);
				if (onTarget) {
					break;
				}
				x--;
			}
			break;
		}
		case EAST: {
			while (y <= 3) {
				onTarget = hasWumpus(x, y);
				if (onTarget) {
					break;
				}
				y++;
			}
			break;
		}
		case SOUTH: {
			while (x <= 3) {
				onTarget = hasWumpus(x, y);
				if (onTarget) {
					break;
				}
				x++;
			}
			break;
		}

		case WEST: {
			while (y >= 0) {
				onTarget = hasWumpus(x, y);
				if (onTarget) {
					break;
				}
				y--;
			}
			break;
		}

		default:
			onTarget = false;
			break;
		}

		return onTarget;
	}

	public int[] getPlayerPosition() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if ((cave[i][j] & J) == J) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public int[][] getCave() {
		return cave;
	}

	public int getDir() {
		return dir;
	}


	public void turnL() {
		dir--;
		if (dir < 0) {
			dir = 3;
		}
	}


	public void turnR() {
		dir = ++dir % 4;
	}

	public String walk() {
		int[] pos = getPlayerPosition();
		int x = pos[0];
		int y = pos[1];
		int xDestino = 0;
		int yDestino = 0;
		String resultWalk = "";
		if (pos[0] != -1 && pos[1] != -1) {
			int DIR = getDir();
			switch (DIR) {
			case NORTH:
				xDestino = x - 1;
				if (xDestino <= -1) {
					resultWalk = "Here is Wall!! Change Direction!!";
					break;
				} else {
					putJogador(xDestino, y);
					cave[x][y] ^= J;
					break;
				}

			case EAST:
				yDestino = y + 1;
				if (yDestino >= 4) {
					resultWalk = "Here is Wall!! Change Direction!!";
					break;
				} else {
					putJogador(x, yDestino);
					cave[x][y] ^= J;
					break;
				}

			case SOUTH:
				xDestino = x + 1;
				if (xDestino >= 4) {
					resultWalk = "Here is Wall!! Change Direction!!";
					break;
				} else {
					putJogador(xDestino, y);
					break;
				}

			case WEST:
				yDestino = y - 1;
				if (yDestino <= -1) {
					resultWalk = "Here is Wall!! Change Direction!!";
					break;
				} else {
					putJogador(x, yDestino);
					break;
				}

			default:
				break;
			}
		}
		return resultWalk;
	}

	public boolean hasGold(int x, int y) {
		return (cave[x][y] & G) == G;
	}

	public boolean hasWumpus(int x, int y) {
		return (cave[x][y] & W) == W;
	}

	public boolean hasArrow() {
		return arrow;
	}

	public String[] hasSensor(int x, int y) {
		String[] vect = { "", "", "" };
		if ((cave[x][y] & B) == B) {
			vect[0] = "B";
		}
		if ((cave[x][y] & F) == F) {
			vect[1] = "F";
		}
		if ((cave[x][y] & C) == C) {
			vect[2] = "C";
		}

		return vect;
	}

	public boolean hasPit(int x, int y) {
		return (cave[x][y] & P) == P;
	}

}
