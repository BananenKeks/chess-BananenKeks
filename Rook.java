package figure;

public class Rook extends Figure {

	public Rook() {
	}

	public Rook(int figureX, int figureY, int figurePlayer) {
		setFigureX(figureX);
		setFigureY(figureY);
		setFigurePlayer(figurePlayer);
	}

	public void logic() {
		clearMovement();
		if (isFigureMoved() == false) {
			goDown(7, true);
			goUp(7, true);
			goLeft(7, true);
			goRight(7, true);
			//TODO insert logic for switch R with K!
		} else {
			goDown(7, true);
			goUp(7, true);
			goLeft(7, true);
			goRight(7, true);
		}
	}
}
