//***************************************************************
//---------------------------------------------------------------
//					BANANENKEKS CHESS GAME
//---------------------------------------------------------------
//| This class is used to show the chess game. The board will be|
//| shown in a terminal like window. The player has to use      |
//| commands to play the game.									| 
//***************************************************************
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;


public class ChessTerminal extends JFrame{
	//TODO Possible Commands are:
	// -help 			(Prints possible commands in the terminal)
	// -new  			(Starts a new game. Should ask if restart is really wanted)
	// -save 			(Saves the game. Should ask where to save)
	// -take [field]	(takes figure from field)
	// -set  [field]	(sets taken figure to field)
	// -cancel 			(puts taken figure down again)
	private JTextPane chessTextTerminalPanel = new JTextPane();
	private JTextField chessTextTerminalField = new JTextField();
	private BorderLayout chessTextTerminalLayout = new BorderLayout();
	
	public ChessTerminal(){
		this.setVisible(true);
		this.setSize(300,600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(chessTextTerminalLayout);
		this.add(chessTextTerminalPanel, chessTextTerminalLayout.CENTER);
		this.add(chessTextTerminalField, chessTextTerminalLayout.SOUTH);
		chessTextTerminalPanel.setBackground(Color.BLACK);
		chessTextTerminalField.setBackground(Color.BLACK);
		chessTextTerminalPanel.setForeground(Color.WHITE);
		chessTextTerminalField.setForeground(Color.WHITE);
	}
}
