package figure;

//This class keeps general attributes and methods for figures
class Figure {

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
	// in allFigures!
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

	// Resetting Array to remove old Data
	public void clearMovement() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found the active Figure! Marking this field with 4 in
				// Array!
				if (getFigureX() == x && getFigureY() == y) {
					setAllowedMoving(x, y, 4);
				}
				// Still not found active Figure! Marking this field with 0
				// in Array!
				else {
					setAllowedMoving(x, y, 0);
				}
			}
		}
	}
	// END

	// Search for foreign figures in array figureView and mark movement in
	// array allowedMovement.
	// Horizontal and vertical moving
	public void goDown(int b, boolean kick) {
		b = getFigureY() + b;
		for (int a = getFigureY(); a <= b; a++) {
			// Position of this Figure!
			if (getFigureView()[a][getFigureX()] == 4) {
				setAllowedMoving(getFigureX(), a, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][getFigureX()] == 2) {
				setAllowedMoving(getFigureX(), a, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][getFigureX()] != getFigurePlayer() && kick == true) {
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
				if (getFigureView()[a][getFigureX()] != getFigurePlayer() && kick == true) {
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
	// END of down.

	public void goUp(int b, boolean kick) {
		b = getFigureY() - b;
		for (int a = getFigureY(); a >= b; a--) {
			// Position of active Figure!
			if (getFigureView()[a][getFigureX()] == 4) {
				setAllowedMoving(getFigureX(), a, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][getFigureX()] == 2) {
				setAllowedMoving(getFigureX(), a, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][getFigureX()] != getFigurePlayer() && kick == true) {
					setAllowedMoving(getFigureX(), a, 3);
				} else {
				}
				a = -1;
			}
			// Position of White Figure!
			else if (getFigureView()[a][getFigureX()] == 1) {
				setAllowedMoving(getFigureX(), a, 1);
				if (getFigureView()[a][getFigureX()] != getFigurePlayer() && kick == true) {
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
	// END of up.

	public void goRight(int b, boolean kick) {
		b = getFigureX() + b;
		for (int a = getFigureX(); a <= b; a++) {
			// Position of active Figure!
			if (getFigureView()[getFigureY()][a] == 4) {
				setAllowedMoving(a, getFigureY(), 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[getFigureY()][a] == 2) {
				setAllowedMoving(a, getFigureY(), 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[getFigureY()][a] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, getFigureY(), 3);
				} else {
				}
				a = 8;
			}
			// Position of White Figure!
			else if (getFigureView()[getFigureY()][a] == 1) {
				setAllowedMoving(a, getFigureY(), 1);
				if (getFigureView()[getFigureY()][a] != getFigurePlayer() && kick == true) {
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
	// END of right.

	public void goLeft(int b, boolean kick) {
		b = getFigureX() - b;
		for (int a = getFigureX(); a >= b; a--) {
			// Position of active Figure!
			if (getFigureView()[getFigureY()][a] == 4) {
				setAllowedMoving(a, getFigureY(), 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[getFigureY()][a] == 2) {
				setAllowedMoving(a, getFigureY(), 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[getFigureY()][a] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, getFigureY(), 3);
				} else {
				}
				a = -1;
			}
			// Position of White Figure!
			else if (getFigureView()[getFigureY()][a] == 1) {
				setAllowedMoving(a, getFigureY(), 1);
				if (getFigureView()[getFigureY()][a] != getFigurePlayer() && kick == true) {
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
	// END of left.

	// Diagonal moving
	public void goDownRight(int c, boolean kick) {
		c = getFigureY() + c;
		int a = getFigureY() + 0;// Y
		int b = getFigureX() + 0;// X
		// Search for down the allFigures from active figure.
		while (a <= c && b <= c) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				setAllowedMoving(a, b, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				setAllowedMoving(a, b, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c + 1;
				b = c + 1;

			}
			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				setAllowedMoving(a, b, 1);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);

				} else {
				}

				// Nothing. Can move here!
			} else {
				setAllowedMoving(a, b, 3);
			}
			a++;
			b++;
		}
	}
	// END of down right

	public void goUpLeft(int c, boolean kick) {
		c = getFigureY() - c;
		int a = getFigureY() + 0;
		int b = getFigureX() + 0;
		// Search for down the allFigures from active figure.
		while (a >= c && b >= c) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				setAllowedMoving(a, b, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				setAllowedMoving(a, b, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c - 1;
				b = c - 1;
			}
			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				setAllowedMoving(a, b, 1);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c - 1;
				b = c - 1;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(a, b, 3);
			}
			a--;
			b--;
		}
	}
	// END of up left

	public void goDownLeft(int c, int d, boolean kick) {
		c = getFigureY() + c;
		d = getFigureX() - d;
		int a = getFigureY() + 0;
		int b = getFigureX() + 0;
		// Search.
		while (a <= c && b >= d) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				setAllowedMoving(a, b, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				setAllowedMoving(a, b, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c + 1;
				b = d - 1;
			}
			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				setAllowedMoving(a, b, 1);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c + 1;
				b = d - 1;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(a, b, 3);
			}
			a++;
			b--;
		}
	}
	// END of down left

	public void goUpRight(int c, int d, boolean kick) {
		c = getFigureY() - c;
		d = getFigureX() + d;
		int a = getFigureY() + 0;
		int b = getFigureX() + 0;
		// Search for down the allFigures from active figure.
		while (a >= c && b <= d) {
			// Position of active Figure!
			if (getFigureView()[a][b] == 4) {
				setAllowedMoving(a, b, 4);
			}
			// Position of Black Figure!
			else if (getFigureView()[a][b] == 2) {
				setAllowedMoving(a, b, 2);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c - 1;
				b = d + 1;
			}

			// Position of White Figure!
			else if (getFigureView()[a][b] == 1) {
				setAllowedMoving(a, b, 1);
				// Foreign figure is enemy. It can be kicked!
				if (getFigureView()[a][b] != getFigurePlayer() && kick == true) {
					setAllowedMoving(a, b, 3);
				} else {
				}
				a = c - 1;
				b = d + 1;
			}
			// Nothing. Can move here!
			else {
				setAllowedMoving(a, b, 3);
			}
			a--;
			b++;
		}
	}
	// END of up right

	// Getter and Setter
	// END of mixed search.

	// END Diagonal moving

	// Getter and Setter methods.
	protected int getFigurePlayer() {
		return figurePlayer;
	}

	protected void setFigurePlayer(int figurePlayer) {
		this.figurePlayer = figurePlayer;
	}

	protected int getFigureX() {
		return figureX;
	}

	protected void setFigureX(int figureX) {
		this.figureX = figureX;
	}

	protected int getFigureY() {
		return figureY;
	}

	protected void setFigureY(int figureY) {
		this.figureY = figureY;
	}

	protected boolean isFigureMoved() {
		return figureMoved;
	}

	protected void setFigureMoved(boolean figureMoved) {
		this.figureMoved = figureMoved;
	}

	protected int[][] getAllowedMoving() {
		return allowedMoving;
	}

	protected void setAllowedMoving(int x, int y, int v) {
		this.allowedMoving[y][x] = v;
	}

	protected int[][] getFigureView() {
		return figureView;
	}

	protected void setFigureView(int x, int y, int v) {
		this.figureView[y][x] = v;
	}

	protected int[][] getAllFigures() {
		return allFigures;
	}

	protected void setAllFigures(int board[][]) {
		this.allFigures = board;
	}
	// END Getter and Setter
	// END of Getter and Setter methods
}
// END of class
