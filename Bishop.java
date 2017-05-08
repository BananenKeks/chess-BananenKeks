package figure;

public class Bishop extends Figure{

	public Bishop(){}
	
	public Bishop(int figurePlayer, int figureX, int figureY){
		setFigurePlayer(figurePlayer);
		setFigureX(figureX);
		setFigureY(figureY);
	}
	
	public void logic(){
		clearMovement();
		goDownLeft(7, 7, true);
		goDownRight(7, true);
		goUpLeft(7, true);
		goUpRight(7, 7, true);
	}
}
