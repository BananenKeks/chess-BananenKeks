package figs;

//This class has the movement algorithms of all figures.
public class Pawn extends Figure {

	// Attributes for calculating figure movement.
	// END of attributes

	// constructor for moving algorithm.
	public Pawn() {
	}
	public Pawn(int figurePlayer, int figureX, int figureY) {
		setFigurePlayer(figurePlayer);
		setFigureX(figureX);
		setFigureY(figureY);
	}
	// END of constructor.

	// Calculation algorithm for movement of the Pawn figure.
	public void logicP() {
		// TODO Still need some logic for reaching the enemies end
		
		clearMovement();
		
		// Algorithm for first movement of the Pawn.
		// Was the figure moved?
		// Who is the active Player?

		// Pawn wasn't moved!
		if (isFigureMoved() == false) {
			// White Player is active player! This means Pawn moves towards
			// Black!
			if (getFigurePlayer() == 1) {
				goDown(2);
			}
			// Black Player is active player! This means Pawn moves towards
			// White!
			else {
				goUp(2);
			}
		}
		// Pawn was moved!
		else {
			// White Player is active player! This means Pawn moves towards
			// Black!
			if (getFigurePlayer() == 1) {
				goDown(1);
			}
			// Black Player is active player! This means Pawn moves towards
			// White!
			else {
				goUp(1);
			}
		}

		// Algorithm to kick another figure.
		// Who is the active player?
		// What color has the foreign figure?
		// Where is the foreign figure?

		// White player is active player! Foreign figure is Black and is under
		// and right of active figure!
		if (getFigurePlayer() == 1 && getFigureView()[getFigureY() + 1][getFigureX() - 1] == 2) {
			goDownRight(1);
		}
		// White player is active player! Foreign figure is Black and is under
		// and left of active figure!
		if (getFigurePlayer() == 1 && getFigureView()[getFigureY() + 1][getFigureX() + 1] == 2) {
			goDownLeft(1,1);
		}
		// Black player is active player! Foreign figure is White and is above
		// and right of active figure!
		if (getFigurePlayer() == 2 && getFigureView()[getFigureY() - 1][getFigureX() + 1] == 1) {
			goUpRight(1,1);
		}
		// Black player is active player! Foreign figure is White and is above
		// and left of active figure!
		if (getFigurePlayer() == 2 && getFigureView()[getFigureY() - 1][getFigureX() - 1] == 1) {
			goUpLeft(1);
		}
		// Nothing to kick!
		else {
		}
	}
}
// END of class
