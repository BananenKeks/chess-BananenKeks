//	***************************************************************
//	---------------------------------------------------------------
//						BANANENKEKS CHESS GAME
//	---------------------------------------------------------------
//	| This class is used to start the game. The game should       |
//	| support a terminal input and output, as well as a graphical |
//	| user interface. The user should be asked at start of the    |
//  | game what version he wants to play.						  | 
//	***************************************************************

public class ChessStarter {

	public static void main(String[] args) {
		// Terminal game has higher priority over graphical game.
		// Logic should be implemented first.
		ChessBoard board1 = new ChessBoard(false);
		ChessTerminal terminal1 = new ChessTerminal();
	}

}
