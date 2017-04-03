import java.util.concurrent.TimeUnit;

//This class has the movement algorithms of all figures.
public class Pawn {

	// Attributes for calculating figure movement.
	// TODO safe all foreign figures in an array.
	private int player = 1;
	private String figure = "P";
	private int figureX = 0;
	private int figureY = 0;
	private boolean alreadyMoved = false;
	private int field[][] = new int[8][8];
	private int allowedMoving[][] = new int[8][8];

	/*
	 * // F i g u r e s // 0 = none none // 1 = Pawn(Bauer) P // 2 =
	 * Bishop(Läufer) B // 3 = Knight(Springer) Kn // 4 = Rook(Turm) R // 5 =
	 * King(König) K // 6 = Queen(Königin) Q
	 */ // END f i g u r e s
	// END of attributes

	// constructor for moving algorithm.
	public Pawn(int figureX, int figureY, int player) {
		setFigureX(figureX);
		setFigureY(figureY);
		setPlayer(player);
		// DONT// call moving algorithm.
		calculateAllowedMovement();
	}
	// END of constructor.

	// Moving algorithm. Fills calculation into arrays. Searches for figures on
	// board!
	public void calculateAllowedMovement() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found active figure on the board! Marking it with 4!
				if (getFigureX() == x && getFigureY() == y) {
					field[y][x] = 4;
				}
				// Found foreign figure(White) on the board! Marking it with 1!
				else if (getForeignFigurePos(x, y) == 1) {
					field[y][x] = 1;
				}
				// Found foreign figure(Black) on the board! Marking it with 2!
				else if (getForeignFigurePos(x, y) == 2) {
					field[y][x] = 2;
				}
				// Found empty field on the board! Marking it with 0!
				else {
					field[y][x] = 0;
				}
				// Do a break for printing into console!
				// TODO remove after implementation into the game!
				try {
					// Break is 5 millisecond.
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					// Break can't be executed!
					System.err.println("Breaktimer in class Figure at 52 doesn't work! Printing StackTrace!");
					e.printStackTrace();
				}
				// Printing current field of the board array.
				System.out.print(field[y][x] + " ");
			}
			// Print a line break for visualizing array as board in console!
			System.out.println(" Stop");
		}
		// Printing a spacer for separating arrays in console!
		System.out.println();
		System.out.println("Spacer");
		// END of printing board array.

		// Initialize Pawn movement calculation
		logicP();
		// END Pawn movement calculation

		// Moving algorithm. Prints allowed movement.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Can move to field on board! Marking it with 3(can override
				// figures)!
				if (allowedMoving[y][x] == 3) {
					System.err.print(allowedMoving[y][x] + " ");
				}
				// Can't move to field on board! Marking it with 0(none),
				// 1(figure), 2(foreignFigure)!
				else {
					System.out.print(allowedMoving[y][x] + " ");
				}
				// Do a break for printing into console!
				// TODO remove after implementation into the game!
				try {
					// Wait for 5 milliseconds!
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					// Can't execute waiting timer!
					System.err.println("Breaktimer in class Figure at 92 doesn't work! Printing StackTrace!");
					e.printStackTrace();
				}
			}
			// Print a line break for visualizing array as board in console!
			System.out.println(" Stop");
		}
		// END of allowed movement printing.
	}// END of moving algorithm.

	// Algorithms for figure movements.
	// Calculation algorithm for movement of the Pawn figure.
	private void logicP() {
		// TODO Still need some logic for reaching the enemies end

		// Find the current Position of the active Figure on the Board.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found the active Figure! Marking this field with 4 in Array!
				if (getFigureX() == x && getFigureY() == y) {
					allowedMoving[y][x] = 4;
				}
				// Still not found active Figure! Marking this field with 0 in
				// Array!
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		// END of finding current figure

		// Algorithm for first movement of the Pawn.
		// Was the figure moved?
		// Who is the active Player?
		// Is something in front of the Pawn?

		// Pawn wasn't moved!
		if (isAlreadyMoved() == false) {
			// White Player is active player! This means Pawn moves towards
			// Black!
			if (getPlayer() == 1) {
				for (int i = getFigureY(); i <= getFigureY() + 2; i++) {
					if (getField()[i][getFigureX()] == 4) {
						allowedMoving[i][getFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getFigureX()] == 1) {
						allowedMoving[i][getFigureX()] = 1;
						i = i + 3;
					}
					// Found Black Figure!
					else if (getField()[i][getFigureX()] == 2) {
						allowedMoving[i][getFigureX()] = 2;
						i = i + 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getFigureX()] = 3;
					}
				}
			}
			// Black Player is active player! This means Pawn moves towards
			// White!
			else {
				for (int i = getFigureY(); i >= getFigureY() - 2; i--) {
					if (getField()[i][getFigureX()] == 4) {
						allowedMoving[i][getFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getFigureX()] == 1) {
						allowedMoving[i][getFigureX()] = 1;
						i = i - 3;
					}
					// Found Black Figure!
					else if (getField()[i][getFigureX()] == 2) {
						allowedMoving[i][getFigureX()] = 2;
						i = i - 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getFigureX()] = 3;
					}
				}
			}
		}
		// Pawn was moved!
		else {
			// White Player is active player! This means Pawn moves towards
			// Black!
			if (getPlayer() == 1) {
				for (int i = getFigureY(); i <= getFigureY() + 1; i++) {
					if (getField()[i][getFigureX()] == 4) {
						allowedMoving[i][getFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getFigureX()] == 1) {
						allowedMoving[i][getFigureX()] = 1;
						i = i + 3;
					}
					// Found Black Figure!
					else if (getField()[i][getFigureX()] == 2) {
						allowedMoving[i][getFigureX()] = 2;
						i = i + 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getFigureX()] = 3;
					}
				}
			}
			// Black Player is active player! This means Pawn moves towards
			// White!
			else {
				for (int i = getFigureY(); i >= getFigureY() - 1; i--) {
					if (getField()[i][getFigureX()] == 4) {
						allowedMoving[i][getFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getFigureX()] == 1) {
						allowedMoving[i][getFigureX()] = 1;
						i = i - 3;
					}
					// Found Black Figure!
					else if (getField()[i][getFigureX()] == 2) {
						allowedMoving[i][getFigureX()] = 2;
						i = i - 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getFigureX()] = 3;
					}
				}
			}
		}

		// Algorithm to kick another figure.
		// Who is the active player?
		// What color has the foreign figure?
		// Where is the foreign figure?

		// White player is active player! Foreign figure is Black and is under
		// and right of active figure!
		if (getPlayer() == 1 && getField()[getFigureY() + 1][getFigureX() - 1] == 2) {
			allowedMoving[getFigureY() + 1][getFigureX() - 1] = 3;
		}
		// White player is active player! Foreign figure is Black and is under
		// and left of active figure!
		if (getPlayer() == 1 && getField()[getFigureY() + 1][getFigureX() + 1] == 2) {
			allowedMoving[getFigureY() + 1][getFigureX() + 1] = 3;
		}
		// Black player is active player! Foreign figure is White and is above
		// and right of active figure!
		if (getPlayer() == 2 && getField()[getFigureY() - 1][getFigureX() + 1] == 1) {
			allowedMoving[getFigureY() - 1][getFigureX() + 1] = 3;
		}
		// Black player is active player! Foreign figure is White and is above
		// and left of active figure!
		if (getPlayer() == 2 && getField()[getFigureY() - 1][getFigureX() - 1] == 1) {
			allowedMoving[getFigureY() - 1][getFigureX() - 1] = 3;
		}
		// Nothing to kick!
		else {
		}
	}
	// END of figure movement algorithm.

	// Getter and Setter methods.
	// TODO alter or remove unused, old or changed attributes!
	public int getForeignFigurePos(int x, int y) {
		return Main.start.getBoard()[x][y];
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getFigureX() {
		return figureX;
	}

	public String getFigure() {
		return figure;
	}

	public void setFigure(String figure) {
		this.figure = figure;
	}

	public void setFigureX(int figureX) {
		this.figureX = figureX;
	}

	public int getFigureY() {
		return figureY;
	}

	public void setFigureY(int figureY) {
		this.figureY = figureY;
	}

	public boolean isAlreadyMoved() {
		return alreadyMoved;
	}

	public void setAlreadyMoved(boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}

	public int[][] getAllowedMoving() {
		return field;
	}

	public void setAllowedMoving(int allowedMoving[][]) {
		this.field = allowedMoving;
	}

	public int[][] getField() {
		return field;
	}

	public void setField(int[][] field) {
		this.field = field;
	}
	// END of Getter and Setter methods
}
// END of class
