package figure;

public class Queen extends Figure {

	public Queen() {
	}

	public Queen(int figureX, int figureY, int figurePlayer) {
		setFigureX(figureX);
		setFigureY(figureY);
		setFigurePlayer(figurePlayer);
	}

	public void logic() {
		clearMovement();
		goDown(7, true);
		goUp(7, true);
		goLeft(7, true);
		goRight(7, true);
		goDownLeft(7, 7, true);
		goDownRight(7, true);
		goUpLeft(7, true);
		goUpRight(7, 7, true);
	}
}
