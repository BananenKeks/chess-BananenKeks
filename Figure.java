import java.util.concurrent.TimeUnit;

//This class has the movement algorithms of all figures.
public class Figure {

	// Attributes for calculating figure movement.
	private int activePlayer = 1;
	private String activeFigure = "P";
	private int activeFigureX = 3;
	private int activeFigureY = 5;
	private boolean alreadyMoved = false;
	private int field[][] = new int[8][8];
	private int allowedMoving[][] = new int[8][8];
	// END of attributes

	// constructor for moving algorithm.
	public Figure() {
		// call moving algorithm.
		calculateAllowedMovement();
	}
	// END of constructor.

	// Moving algorithm. Fills calculation into arrays. Searches for figures on
	// board!
	public void calculateAllowedMovement() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found active figure on the board! Marking it with 4!
				if (getActiveFigureX() == x && getActiveFigureY() == y) {
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

		// What is the active figure?

		// Active Figure is Pawn! Executing Pawn moving logic!
		if (getActiveFigure() == "P") {
			logicP();
		}
		// Active Figure is Rook! Executing Rook moving logic!
		if (getActiveFigure() == "R") {
			logicR();
		}
		// Active Figure is Queen! Executing Queen moving logic!
		if (getActiveFigure() == "Q") {
			logicQ();
		}
		// Active Figure is Bishop! Executing Bishop moving logic!
		if (getActiveFigure() == "B") {
			logicB();
		}
		// Active Figure is Knight! Executing Knight moving logic!
		if (getActiveFigure() == "Kn") {
			logicKn();
		}
		// Active Figure is King! Executing King moving logic!
		if (getActiveFigure() == "K") {
			logicK();
		}
		// END of searching for active figure.

		// Moving algorithm. Prints allowed movement.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Can move to field on board! Marking it with 3(can override
				// figures)!
				if (allowedMoving[y][x] == 3) {
					System.err.print(allowedMoving[y][x] + " ");
				}
				// Can't move to field on board! Marking it with 0(none),
				// 1(activeFigure), 2(foreignFigure)!
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
				if (getActiveFigureX() == x && getActiveFigureY() == y) {
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
			if (getActivePlayer() == 1) {
				for (int i = getActiveFigureY(); i <= getActiveFigureY() + 2; i++) {
					if (getField()[i][getActiveFigureX()] == 4) {
						allowedMoving[i][getActiveFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getActiveFigureX()] == 1) {
						allowedMoving[i][getActiveFigureX()] = 1;
						i = i + 3;
					}
					// Found Black Figure!
					else if (getField()[i][getActiveFigureX()] == 2) {
						allowedMoving[i][getActiveFigureX()] = 2;
						i = i + 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getActiveFigureX()] = 3;
					}
				}
			}
			// Black Player is active player! This means Pawn moves towards
			// White!
			else {
				for (int i = getActiveFigureY(); i >= getActiveFigureY() - 2; i--) {
					if (getField()[i][getActiveFigureX()] == 4) {
						allowedMoving[i][getActiveFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getActiveFigureX()] == 1) {
						allowedMoving[i][getActiveFigureX()] = 1;
						i = i - 3;
					}
					// Found Black Figure!
					else if (getField()[i][getActiveFigureX()] == 2) {
						allowedMoving[i][getActiveFigureX()] = 2;
						i = i - 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getActiveFigureX()] = 3;
					}
				}
			}
		}
		// Pawn was moved!
		else {
			// White Player is active player! This means Pawn moves towards
			// Black!
			if (getActivePlayer() == 1) {
				for (int i = getActiveFigureY(); i <= getActiveFigureY() + 1; i++) {
					if (getField()[i][getActiveFigureX()] == 4) {
						allowedMoving[i][getActiveFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getActiveFigureX()] == 1) {
						allowedMoving[i][getActiveFigureX()] = 1;
						i = i + 3;
					}
					// Found Black Figure!
					else if (getField()[i][getActiveFigureX()] == 2) {
						allowedMoving[i][getActiveFigureX()] = 2;
						i = i + 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getActiveFigureX()] = 3;
					}
				}
			}
			// Black Player is active player! This means Pawn moves towards
			// White!
			else {
				for (int i = getActiveFigureY(); i >= getActiveFigureY() - 1; i--) {
					if (getField()[i][getActiveFigureX()] == 4) {
						allowedMoving[i][getActiveFigureX()] = 4;
					}
					// Found White Figure!
					else if (getField()[i][getActiveFigureX()] == 1) {
						allowedMoving[i][getActiveFigureX()] = 1;
						i = i - 3;
					}
					// Found Black Figure!
					else if (getField()[i][getActiveFigureX()] == 2) {
						allowedMoving[i][getActiveFigureX()] = 2;
						i = i - 3;
					}
					// Found no Figure!
					else {
						allowedMoving[i][getActiveFigureX()] = 3;
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
		if (getActivePlayer() == 1 && getField()[getActiveFigureY() + 1][getActiveFigureX() - 1] == 2) {
			allowedMoving[getActiveFigureY() + 1][getActiveFigureX() - 1] = 3;
		}
		// White player is active player! Foreign figure is Black and is under
		// and left of active figure!
		if (getActivePlayer() == 1 && getField()[getActiveFigureY() + 1][getActiveFigureX() + 1] == 2) {
			allowedMoving[getActiveFigureY() + 1][getActiveFigureX() + 1] = 3;
		}
		// Black player is active player! Foreign figure is White and is above
		// and right of active figure!
		if (getActivePlayer() == 2 && getField()[getActiveFigureY() - 1][getActiveFigureX() + 1] == 1) {
			allowedMoving[getActiveFigureY() - 1][getActiveFigureX() + 1] = 3;
		}
		// Black player is active player! Foreign figure is White and is above
		// and left of active figure!
		if (getActivePlayer() == 2 && getField()[getActiveFigureY() - 1][getActiveFigureX() - 1] == 1) {
			allowedMoving[getActiveFigureY() - 1][getActiveFigureX() - 1] = 3;
		}
		// Nothing to kick!
		else {
		}
	}

	// Calculation algorithm for movement of the Rook figure.
	private void logicR() {
		// Find the current Position of the active Figure on the Board.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found the active Figure! Marking this field with 1 in Array!
				if (getActiveFigureX() == x && getActiveFigureY() == y) {
					allowedMoving[y][x] = 1;
				}
				// Still not found active Figure! Marking this field with 0 in
				// Array!
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		// END of finding current figure

		// Algorithm for first movement of the Rook.
		// Was the figure moved?

		// Rook wasn't moved!
		if (isAlreadyMoved() == false) {
			// Execute calculation of horizontal and vertical movement.
			// TODO add movement for switching King and Rook when not moved!
			horizontalAndVerticalMoving();
		}
		// Rook was moved!
		else {
			// Execute calculation of horizontal and vertical movement.
			horizontalAndVerticalMoving();
		}
		// END of Rook.
	}

	// Calculation algorithm for movement of the Queen figure.
	private void logicQ() {
		// Find the current Position of the active Figure on the Board.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found the active Figure! Marking this field with 1 in Array!
				if (getActiveFigureX() == x && getActiveFigureY() == y) {
					allowedMoving[y][x] = 1;
				}
				// Still not found active Figure! Marking this field with 0 in
				// Array!
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		// END of finding current figure

		// Algorithm for first movement of the Queen.
		// Execute calculation of horizontal and vertical movement.
		horizontalAndVerticalMoving();
		diagonalMoving();
		// END of Queen.
	}

	// Calculation algorithm for movement of the Bishop figure.
	private void logicB() {
		// Find the current Position of the active Figure on the Board.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found the active Figure! Marking this field with 1 in Array!
				if (getActiveFigureX() == x && getActiveFigureY() == y) {
					allowedMoving[y][x] = 1;
				}
				// Still not found active Figure! Marking this field with 0 in
				// Array!
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		// END of finding current figure

		// Algorithm for first movement of the Queen.
		// Execute calculation of horizontal and vertical movement.
		diagonalMoving();
		// END of Queen.
	}

	// Calculation algorithm for movement of the Knight figure.
	private void logicKn() {
		// Find the current Position of the active Figure on the Board.
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// Found the active Figure! Marking this field with 4 in Array!
				if (getActiveFigureX() == x && getActiveFigureY() == y) {
					allowedMoving[y][x] = 4;
				}
				// Found Black figure! Marking it with 2 in Array!
				else if (getForeignFigurePos(x, y) == 2) {
					allowedMoving[y][x] = 2;
				}
				// Found White figure! Marking it with 1 in Array!
				else if (getForeignFigurePos(x, y) == 1) {
					allowedMoving[y][x] = 1;
				}
				// Still not found active Figure! Marking this field with 0 in
				// Array!
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		// END of finding current figure.
		// Calculate movement of Knight.
		int a = getActiveFigureY() - 3;
		int b = getActiveFigureX() - 1;

		// Going up!
		// Position of foreign Figure!
		if (a >= 0) {
			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {
				}
				// Nothing. Can move here!
			}
			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {
				}
			} else {
				allowedMoving[a][b] = 3;
			}

			b = getActiveFigureX() + 1;
			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
		} else {
		}
		// END going up!

		a = getActiveFigureY() + 3;
		b = getActiveFigureX() - 1;

		// Going down!
		// Position of foreign Figure!
		if (a <= 7) {
			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}

			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}

			b = getActiveFigureX() + 1;
			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
		} else {
		}
		// END going down!

		a = getActiveFigureY() + 1;
		b = getActiveFigureX() - 3;

		// Going left!
		// Position of foreign Figure!
		if (b >= 0) {
			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}

			a = getActiveFigureX() - 1;

			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {
				}
			}
			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
		} else {
		}
		// END going right!

		a = getActiveFigureY() + 1;
		b = getActiveFigureX() + 3;

		// Going left!
		// Position of foreign Figure!
		if (b <= 7) {
			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// White
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}

			a = getActiveFigureX() - 1;

			// Black
			if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// White
			if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
				}
				// Foreign figure is friend. It can't be kicked!
				else {

				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][b] = 3;
			}
		} else {
		}
		// END going right!

		// END Calculate movement of Knight.
	}

	// Calculation algorithm for movement of the King figure.
	private void logicK() {
	}
	// END of figure movement algorithms.

	// Horizontal and vertical moving
	private void horizontalAndVerticalMoving() {
		// Search for foreign figure in array field and mark movement in array
		// allowedMovement.
		// Search Y line!
		for (int a = getActiveFigureY(); a <= 7; a++) {
			// Position of active Figure!
			if (getField()[a][getActiveFigureX()] == 4) {
				allowedMoving[a][getActiveFigureX()] = 4;
			}
			// Position of Black Figure!
			else if (getField()[a][getActiveFigureX()] == 2) {
				allowedMoving[a][getActiveFigureX()] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][getActiveFigureX()] != getActivePlayer()) {
					allowedMoving[a][getActiveFigureX()] = 3;
					a = 8;
				} else {
					a = 8;
				}
			}
			// Position of White Figure
			else if (getField()[a][getActiveFigureX()] == 1) {
				allowedMoving[a][getActiveFigureX()] = 1;
				a = 8;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][getActiveFigureX()] != getActivePlayer()) {
					allowedMoving[a][getActiveFigureX()] = 3;
					a = 8;
				} else {
					a = 8;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][getActiveFigureX()] = 3;
			}
		}

		for (int a = getActiveFigureY(); a >= 0; a--) {
			// Position of active Figure!
			if (getField()[a][getActiveFigureX()] == 4) {
				allowedMoving[a][getActiveFigureX()] = 4;
			}
			// Position of Black Figure!
			else if (getField()[a][getActiveFigureX()] == 2) {
				allowedMoving[a][getActiveFigureX()] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][getActiveFigureX()] != getActivePlayer()) {
					allowedMoving[a][getActiveFigureX()] = 3;
					a = -1;
				} else {
					a = -1;
				}
			}
			// Position of White Figure!
			else if (getField()[a][getActiveFigureX()] == 1) {
				allowedMoving[a][getActiveFigureX()] = 1;
				if (getField()[a][getActiveFigureX()] != getActivePlayer()) {
					allowedMoving[a][getActiveFigureX()] = 3;
					a = -1;
				} else {
					a = -1;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[a][getActiveFigureX()] = 3;
			}
		}
		// END of Y search.
		// Search X line!
		for (int a = getActiveFigureX(); a <= 7; a++) {
			// Position of active Figure!
			if (getField()[getActiveFigureY()][a] == 4) {
				allowedMoving[getActiveFigureY()][a] = 4;
			}
			// Position of Black Figure!
			else if (getField()[getActiveFigureY()][a] == 2) {
				allowedMoving[getActiveFigureY()][a] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[getActiveFigureY()][a] != getActivePlayer()) {
					allowedMoving[getActiveFigureY()][a] = 3;
					a = 8;
				} else {
					a = 8;
				}
			}
			// Position of White Figure!
			else if (getField()[getActiveFigureY()][a] == 1) {
				allowedMoving[getActiveFigureY()][a] = 1;
				if (getField()[getActiveFigureY()][a] != getActivePlayer()) {
					allowedMoving[getActiveFigureY()][a] = 3;
					a = 8;
				} else {
					a = 8;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[getActiveFigureY()][a] = 3;
			}
		}
		for (int a = getActiveFigureX(); a >= 0; a--) {
			// Position of active Figure!
			if (getField()[getActiveFigureY()][a] == 4) {
				allowedMoving[getActiveFigureY()][a] = 4;
			}
			// Position of Black Figure!
			else if (getField()[getActiveFigureY()][a] == 2) {
				allowedMoving[getActiveFigureY()][a] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[getActiveFigureY()][a] != getActivePlayer()) {
					allowedMoving[getActiveFigureY()][a] = 3;
					a = -1;
				} else {
					a = -1;
				}
			}
			// Position of White Figure!
			else if (getField()[getActiveFigureY()][a] == 1) {
				allowedMoving[getActiveFigureY()][a] = 1;
				if (getField()[getActiveFigureY()][a] != getActivePlayer()) {
					allowedMoving[getActiveFigureY()][a] = 3;
					a = -1;
				} else {
					a = -1;
				}
			}
			// Nothing. Can move here!
			else {
				allowedMoving[getActiveFigureY()][a] = 3;
			}
		}
		// END of X search.
	}
	// END Horizontal and vertical moving

	// Diagonal moving
	private void diagonalMoving() {
		// Search for foreign figure in array field and mark movement in array
		// allowedMovement.
		int a = getActiveFigureY() + 0;// Y
		int b = getActiveFigureX() + 0;// X
		// Search for down the board from active figure.
		while (a <= 7 && b <= 7) {
			// Position of active Figure!
			if (getField()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
					a = 8;
					b = 8;
				} else {
					a = 8;
					b = 8;
				}
			}
			// Position of White Figure!
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
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
		// Search up the board from active Figure!
		a = getActiveFigureY() + 0;
		b = getActiveFigureX() + 0;
		// Search for down the board from active figure.
		while (a >= 0 && b >= 0) {
			// Position of active Figure!
			if (getField()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
					a = -8;
					b = -8;
				} else {
					a = -8;
					b = -8;
				}
			}
			// Position of White Figure!
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
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
		// Search up the board from active Figure!
		a = getActiveFigureY() + 0;
		b = getActiveFigureX() + 0;
		// Search.
		while (a <= 7 && b >= 0) {
			// Position of active Figure!
			if (getField()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
					a = 8;
					b = -8;
				} else {
					a = 8;
					b = -8;
				}
			}
			// Position of White Figure!
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
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
		// Search up the board from active Figure!
		a = getActiveFigureY() + 0;
		b = getActiveFigureX() + 0;
		// Search for down the board from active figure.
		while (a >= 0 && b <= 7) {
			// Position of active Figure!
			if (getField()[a][b] == 4) {
				allowedMoving[a][b] = 4;
			}
			// Position of Black Figure!
			else if (getField()[a][b] == 2) {
				allowedMoving[a][b] = 2;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
					allowedMoving[a][b] = 3;
					a = -8;
					b = 8;
				} else {
					a = -8;
					b = 8;
				}
			}

			// Position of White Figure!
			else if (getField()[a][b] == 1) {
				allowedMoving[a][b] = 1;
				// Foreign figure is enemy. It can be kicked!
				if (getField()[a][b] != getActivePlayer()) {
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
	// TODO alter or remove unused, old or changed attributes!
	public int getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(int activePlayer) {
		this.activePlayer = activePlayer;
	}

	public String getActiveFigure() {
		return activeFigure;
	}

	public void setActiveFigure(String activeFigure) {
		this.activeFigure = activeFigure;
	}

	public int getActiveFigureX() {
		return activeFigureX;
	}

	public void setActiveFigureX(int activeFigureX) {
		this.activeFigureX = activeFigureX;
	}

	public int getActiveFigureY() {
		return activeFigureY;
	}

	public void setActiveFigureY(int activeFigureY) {
		this.activeFigureY = activeFigureY;
	}

	public int getForeignFigurePos(int x, int y) {
		return Main.start.getBoard()[x][y];
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
