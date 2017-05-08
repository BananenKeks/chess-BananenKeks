package figure;

public class King extends Figure{
	public King() {
	}

	public King(int figurePlayer, int figureX, int figureY) {
		setFigurePlayer(figurePlayer);
		setFigureX(figureX);
		setFigureY(figureY);
	}
	
	public void logic(){
		clearMovement();
		//TODO add logic for switching K with R!
		//TODO add logic for check-mate!
		goUp(1, true);
		goUpLeft(1, true);
		goUpRight(1, 1, true);
		goLeft(1, true);
		goRight(1, true);
		goDown(1, true);
		goDownLeft(1, 1, true);
		goDownRight(1, true);
	}
}
