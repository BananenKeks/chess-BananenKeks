//	***************************************************************
//	---------------------------------------------------------------
//						BANANENKEKS CHESS GAME
//	---------------------------------------------------------------
//	| This class is used to build the chess game. The board will  |
//	| be saved in an array. The array holds the chess figures. It |
//	| should be possible to export the array into a text file to  |
//  | save the game for later sessions.							  | 
//	***************************************************************

public class ChessBoard {
	// The array is 8 times 8 large to mimic a chess board.
	// Datatype String was chosen to represent the figures
	// with letters and empty fields with 0.
	private static String board[][] = new String[8][8];

	// Constructor to initialize the game.
	public ChessBoard(boolean savegame) {
		// Validating if a savegame is loaded or not. The
		// savegame should be selected in a extra window
		// if the graphical interface is started. If the
		// game is started as terminal, the savegame should
		// be loaded in a command prompt. The user should
		// type the path to the savegame.
		if (savegame == true) {
			// TODO A function to write and read savegames
			// needs to be implemented first.
		} else {
			// If no savegame is chosen, a new game should
			// be initialized.
			newBoard();
			
		}

	}

	private static void newBoard(){
		// The board array will be filled with 0 for a new
		// game. Another algorithm should set the Strings
		// for the figures in this array.
		String tmpBoard[][] = new String[8][8];
		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				tmpBoard[y][x] = "0";
			}
		}
		setBoard(tmpBoard);
	}
	public static String[][] getBoard() {
		return board;
	}

	public static void setBoard(String board[][]) {
		ChessBoard.board = board;
	}
}
