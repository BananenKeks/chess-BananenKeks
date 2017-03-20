import java.awt.Color;
//import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Class for tiles
@SuppressWarnings("serial")
public class Tile extends JPanel {
	//Attributes for tile class.
	private JLabel tileFigureDisplay = new JLabel("none");
	private Color tileColor = Color.decode("#CDAA7D");
		//white = CDAA7D
		//black = 8B7355
	private String tileCurrentFigure = "none";
	/*	0 = none 		none
		1 = Pawn(Bauer)		P
		2 = Bishop(Läufer)	B
		3 = Knight(Springer)	Kn
		4 = Rook(Turm)		R
		5 = King(König)		K
		6 = Queen(Königin)	Q
	 */
	private int tileCurrentPlayer = 0;
	/*	0 = none
	 	1 = white
	 	2 = black
	*/
	private boolean tileCurrentlyOccupied = false;
	private int posX = 0;
	private int posY = 0;
	private boolean selected = false;
	//END of attributes.
	
	//Constructors for tile class.
	public Tile(int posY, int posX){
		this.setSize(50, 50);
		this.setBackground(this.getTileColor());
		this.add(this.getTileFigureDisplay());
		this.getTileFigureDisplay().setBackground(this.getTileColor());
		this.getTileFigureDisplay().setForeground(Color.RED);
		this.setPosX(posX);
		this.setPosY(posY);
	}
	
	public Tile(int posY, int posX, Color tileColor){
		this.setSize(50, 50);
		this.setBackground(tileColor);
		this.setTileColor(tileColor);
		this.add(this.getTileFigureDisplay());
		this.getTileFigureDisplay().setBackground(tileColor);
		this.getTileFigureDisplay().setForeground(Color.RED);
		this.setPosX(posX);
		this.setPosY(posY);
	}
	
	public Tile(int posY, int posX, Color tileColor, int tileCurrentPlayer, String tileCurrentFigure, boolean tileCurrentlyOccupied){
		this.setSize(50, 50);
		this.setBackground(tileColor);
		this.setTileColor(tileColor);
		this.getTileFigureDisplay().setText(tileCurrentFigure);
		this.setTileCurrentFigure(tileCurrentFigure);
		this.setTileCurrentlyOccupied(tileCurrentlyOccupied);
		this.setTileCurrentPlayer(tileCurrentPlayer);
		this.add(this.getTileFigureDisplay());
		if(tileCurrentPlayer == 1){
			this.getTileFigureDisplay().setForeground(Color.WHITE);
		}
		if(tileCurrentPlayer == 2){
			this.getTileFigureDisplay().setForeground(Color.BLACK);
		}
		if(tileCurrentPlayer == 0){
			this.getTileFigureDisplay().setForeground(Color.RED);
		}
		this.getTileFigureDisplay().setBackground(tileColor);
		this.setPosX(posX);
		this.setPosY(posY);
	}
	//END of constructors.
	
	//Getter and Setter methods.
	public Color getTileColor() {
		return tileColor;
	}

	public void setTileColor(Color tileColor) {
		this.tileColor = tileColor;
	}

	public String getTileCurrentFigure() {
		return tileCurrentFigure;
	}

	public void setTileCurrentFigure(String tileCurrentFigure) {
		this.tileCurrentFigure = tileCurrentFigure;
		this.getTileFigureDisplay().setText(tileCurrentFigure);
	}

	public int getTileCurrentPlayer() {
		return tileCurrentPlayer;
	}

	public void setTileCurrentPlayer(int tileCurrentPlayer) {
		this.tileCurrentPlayer = tileCurrentPlayer;
		if(tileCurrentPlayer == 0){
			this.tileFigureDisplay.setForeground(Color.RED);
		}
		else if(tileCurrentPlayer == 1){
			this.tileFigureDisplay.setForeground(Color.WHITE);
		}
		else{
			this.tileFigureDisplay.setForeground(Color.BLACK);
		}
	}

	public boolean isTileCurrentlyOccupied() {
		return tileCurrentlyOccupied;
	}

	public void setTileCurrentlyOccupied(boolean tileCurrentlyOccupied) {
		this.tileCurrentlyOccupied = tileCurrentlyOccupied;
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public JLabel getTileFigureDisplay() {
		return tileFigureDisplay;
	}

	public void setTileFigureDisplay(JLabel tileFigureDisplay) {
		this.tileFigureDisplay = tileFigureDisplay;
	}
	//END of Getter and Setter methods.
}
//END of class.
