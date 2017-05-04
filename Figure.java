package figs;

//This class keeps general attributes and methods for figures
public class Figure {

	// Attributes for calculating figure movement.
	private int figurePlayer = 0;
	private int figureX = 0;
	private int figureY = 0;
	private boolean figureMoved = false;

	private int allFigures[][] = new int[8][8];
	private int figureView[][] = new int[8][8];
	private int allowedMoving[][] = new int[8][8];
	// END of attributes

	// constructor for moving algorithm.
	public Figure() {
	}
	// END of constructor.

	// Searching algorithm. Fills calculation into arrays. Searches for figures
	// in
	// allFigures!
	public void findFiguresOnBoard() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found this figure in allFigures! Marking it with 4!
				if (getFigureX() == x && getFigureY() == y) {
					setFigureView(x, y, 4);
				}
				// Found foreign figure(White) in allFigures! Marking it with 1!
				else if (getAllFigures()[x][y] == 1) {
					setFigureView(x, y, 1);
				}
				// Found foreign figure(Black) in allFigures! Marking it with 2!
				else if (getAllFigures()[x][y] == 2) {
					setFigureView(x, y, 2);
				}
				// Found empty field in allFigures! Marking it with 0!
				else {
					setFigureView(x, y, 0);
				}
			}
		}
	}
	// END of searching algorithm.

	// Horizontal and vertical moving
	// Search for foreign figures in array figureView and mark movement in
	// array allowedMovement.
	public void goRight(int b) {
		for (int a = getFigureY(); a <= b; a++) {
			// Position of this Figure!
			if (getFigureView()[a][getFigureX()] == 4) {
				setAllowedMoving(getFigureX(), a, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][getFigureX()] == 2) {
				setAllowedMoving(getFigureX(), a, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][getFigureX()] != getFigurePlayer()) {
					setAllowedMoving(getFigureX(), a, 3);
				} else {
				}
				a = 8;
			}
			// Position of White Figure
			else if (getFigureView()[a][getFigureX()] == 1) {
				setAllowedMoving(getFigureX(), a, 1);
				a = 8;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][getFigureX()] != getFigurePlayer()) {
					setAllowedMoving(getFigureX(), a, 3);
				} else {
				}
				a = 8;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(getFigureX(), a, 3);
			}
		}
	}
	// END of left.

	public void goLeft(int b) {
		for (int a = getFigureY(); a >= b; a--) {
			// Position of active Figure!
			if (getFigureView()[a][getFigureX()] == 4) {
				setAllowedMoving(getFigureX(), a, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][getFigureX()] == 2) {
				setAllowedMoving(getFigureX(), a, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][getFigureX()] != getFigurePlayer()) {
					setAllowedMoving(getFigureX(), a, 3);
				} else {
				}
				a = -1;
			}
			// Position of White Figure!
			else if (getFigureView()[a][getFigureX()] == 1) {
				setAllowedMoving(getFigureX(), a, 1);
				if (getFigureView()[a][getFigureX()] != getFigurePlayer()) {
					setAllowedMoving(getFigureX(), a, 3);
				} else {
				}
				a = -1;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(getFigureX(), a, 3);
			}
		}
	}
	// END of right.

	public void goDown(int b) {
		for (int a = getFigureX(); a <= b; a++) {
			// Position of active Figure!
			if (getFigureView()[getFigureY()][a] == 4) {
				setAllowedMoving(a, getFigureY(), 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[getFigureY()][a] == 2) {
				setAllowedMoving(a, getFigureY(), 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[getFigureY()][a] != getFigurePlayer()) {
					setAllowedMoving(a, getFigureY(), 3);
				} else {
				}
				a = 8;
			}
			// Position of White Figure!
			else if (getFigureView()[getFigureY()][a] == 1) {
				setAllowedMoving(a, getFigureY(), 1);
				if (getFigureView()[getFigureY()][a] != getFigurePlayer()) {
					setAllowedMoving(a, getFigureY(), 3);
				} else {
				}
				a = 8;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(a, getFigureY(), 3);
			}
		}
	}
	// END of down.

	public void goUp(int b) {
		for (int a = getFigureX(); a >= b; a--) {
			// Position of active Figure!
			if (getFigureView()[getFigureY()][a] == 4) {
				setAllowedMoving(a, getFigureY(), 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[getFigureY()][a] == 2) {
				setAllowedMoving(a, getFigureY(), 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[getFigureY()][a] != getFigurePlayer()) {
					setAllowedMoving(a, getFigureY(), 3);
				} else {
				}
				a = -1;
			}
			// Position of White Figure!
			else if (getFigureView()[getFigureY()][a] == 1) {
				setAllowedMoving(a, getFigureY(), 1);
				if (getFigureView()[getFigureY()][a] != getFigurePlayer()) {
					setAllowedMoving(a, getFigureY(), 3);
				} else {
				}
				a = -1;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(a, getFigureY(), 3);
			}
		}
	}
	// END of up.
	// END Horizontal and vertical moving

	// Diagonal moving
	@SuppressWarnings("unused")
	private void diagonalMoving() {
		// Search for foreign figure in array figureView and mark movement in
		// array
		// allowedMovement.
		int a = getFigureY() + 0;// Y
		int b = getFigureX() + 0;// X
		// Search for down the allFigures from active figure.
		while (a <= 7 && b <= 7) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = 8;
					b = 8;
				} else {
					a = 8;
					b = 8;
				}
			}
			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = 8;
					b = 8;
				} else {
					a = 8;
					b = 8;
				}
				// Nothing. Can move here!
			} else {
				allowedMoving[a][b] = 3;
			}
			a++;
			b++;
		}
		// END of positive search.
		// Search up the allFigures from active Figure!
		a = getFigureY() + 0;
		b = getFigureX() + 0;
		// Search for down the allFigures from active figure.
		while (a >= 0 && b >= 0) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = -8;
					b = -8;
				} else {
					a = -8;
					b = -8;
				}
			}
			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = -8;
					b = -8;
				} else {
					a = -8;
					b = -8;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
			a--;
			b--;
		}
		// END of negative search.
		// Search up the allFigures from active Figure!
		a = getFigureY() + 0;
		b = getFigureX() + 0;
		// Search.
		while (a <= 7 && b >= 0) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = 8;
					b = -8;
				} else {
					a = 8;
					b = -8;
				}
			}
			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = 8;
					b = -8;
				} else {
					a = 8;
					b = -8;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
			a++;
			b--;
		}
		// Search up the allFigures from active Figure!
		a = getFigureY() + 0;
		b = getFigureX() + 0;
		// Search for down the allFigures from active figure.
		while (a >= 0 && b <= 7) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = -8;
					b = 8;
				} else {
					a = -8;
					b = 8;
				}
			}

			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer()) {
					allowedMoving[a][b] = 3;
					a = -8;
					b = 8;
				} else {
					a = -8;
					b = 8;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
			a--;
			b++;
		}
		// END of mixed search.
	}
	// END Diagonal moving

	// Getter and Setter methods.
	public int getFigurePlayer() {
		return figurePlayer;
	}

	public void setFigurePlayer(int figurePlayer) {
		this.figurePlayer = figurePlayer;
	}

	public int getFigureX() {
		return figureX;
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

	public boolean isFigureMoved() {
		return figureMoved;
	}

	public void setFigureMoved(boolean figureMoved) {
		this.figureMoved = figureMoved;
	}

	public int[][] getAllowedMoving() {
		return allowedMoving;
	}

	public void setAllowedMoving(int x, int y, int v) {
		this.allowedMoving[y][x] = v;
	}

	public int[][] getFigureView() {
		return figureView;
	}

	public void setFigureView(int x, int y, int v) {
		this.figureView[y][x] = v;
	}

	public int[][] getAllFigures() {
		return allFigures;
	}

	public void setAllFigures(int board[][]) {
		this.allFigures = board;
	}
	// END of Getter and Setter methods
}
// END of class
