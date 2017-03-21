import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Class for building the game window with the chess board.
//This class also has the MouseListener.
//TODO separate MouseListener into own Listener Class/Interface!
@SuppressWarnings("serial")
public class Board extends JFrame {

	// Attributes for the board.
	private boolean ListenerInterrupted = false;
	private int currentActivePlayer = 1;
	// White = 1
	// Black = 2
	// LayoutManager for the Board
	private GridLayout gridLayoutManager = new GridLayout(8, 8);
	private boolean pickedUp = false;
	private String chosenFigure = "none";
	/*
	 * // F i g u r e s // 0 = none none // 1 = Pawn(Bauer) P // 2 =
	 * Bishop(Läufer) B // 3 = Knight(Springer) Kn // 4 = Rook(Turm) R // 5 =
	 * King(König) K // 6 = Queen(Königin) Q
	 */ // END f i g u r e s
	private boolean tileCurrentlyOccupied = false;
	private int tileCurrentPlayer = 0;
	private int posX = 0;
	private int posY = 0;
	// END of attributes.

	// Creating tile objects form class Tile. Also adding attributes to tiles.
	// Row 1(Top).
	private Tile t11 = new Tile(1, 1, Color.decode("#CDAA7D"), 1, "T", true);
	private Tile t12 = new Tile(1, 2, Color.decode("#8B7355"), 1, "S", true);
	private Tile t13 = new Tile(1, 3, Color.decode("#CDAA7D"), 1, "L", true);
	private Tile t14 = new Tile(1, 4, Color.decode("#8B7355"), 1, "Q", true);
	private Tile t15 = new Tile(1, 5, Color.decode("#CDAA7D"), 1, "K", true);
	private Tile t16 = new Tile(1, 6, Color.decode("#8B7355"), 1, "L", true);
	private Tile t17 = new Tile(1, 7, Color.decode("#CDAA7D"), 1, "S", true);
	private Tile t18 = new Tile(1, 8, Color.decode("#8B7355"), 1, "T", true);
	// Row 2.
	private Tile t21 = new Tile(2, 1, Color.decode("#8B7355"), 1, "B", true);
	private Tile t22 = new Tile(2, 2, Color.decode("#CDAA7D"), 1, "B", true);
	private Tile t23 = new Tile(2, 3, Color.decode("#8B7355"), 1, "B", true);
	private Tile t24 = new Tile(2, 4, Color.decode("#CDAA7D"), 1, "B", true);
	private Tile t25 = new Tile(2, 5, Color.decode("#8B7355"), 1, "B", true);
	private Tile t26 = new Tile(2, 6, Color.decode("#CDAA7D"), 1, "B", true);
	private Tile t27 = new Tile(2, 7, Color.decode("#8B7355"), 1, "B", true);
	private Tile t28 = new Tile(2, 8, Color.decode("#CDAA7D"), 1, "B", true);
	// Row 3.
	private Tile t31 = new Tile(3, 1, Color.decode("#CDAA7D"));
	private Tile t32 = new Tile(3, 2, Color.decode("#8B7355"));
	private Tile t33 = new Tile(3, 3, Color.decode("#CDAA7D"));
	private Tile t34 = new Tile(3, 4, Color.decode("#8B7355"));
	private Tile t35 = new Tile(3, 5, Color.decode("#CDAA7D"));
	private Tile t36 = new Tile(3, 6, Color.decode("#8B7355"));
	private Tile t37 = new Tile(3, 7, Color.decode("#CDAA7D"));
	private Tile t38 = new Tile(3, 8, Color.decode("#8B7355"));
	// Row 4.
	private Tile t41 = new Tile(4, 1, Color.decode("#8B7355"));
	private Tile t42 = new Tile(4, 2, Color.decode("#CDAA7D"));
	private Tile t43 = new Tile(4, 3, Color.decode("#8B7355"));
	private Tile t44 = new Tile(4, 4, Color.decode("#CDAA7D"));
	private Tile t45 = new Tile(4, 5, Color.decode("#8B7355"));
	private Tile t46 = new Tile(4, 6, Color.decode("#CDAA7D"));
	private Tile t47 = new Tile(4, 7, Color.decode("#8B7355"));
	private Tile t48 = new Tile(4, 8, Color.decode("#CDAA7D"));
	// Row 5.
	private Tile t51 = new Tile(5, 1, Color.decode("#CDAA7D"));
	private Tile t52 = new Tile(5, 2, Color.decode("#8B7355"));
	private Tile t53 = new Tile(5, 3, Color.decode("#CDAA7D"));
	private Tile t54 = new Tile(5, 4, Color.decode("#8B7355"));
	private Tile t55 = new Tile(5, 5, Color.decode("#CDAA7D"));
	private Tile t56 = new Tile(5, 6, Color.decode("#8B7355"));
	private Tile t57 = new Tile(5, 7, Color.decode("#CDAA7D"));
	private Tile t58 = new Tile(5, 8, Color.decode("#8B7355"));
	// Row 6.
	private Tile t61 = new Tile(6, 1, Color.decode("#8B7355"));
	private Tile t62 = new Tile(6, 2, Color.decode("#CDAA7D"));
	private Tile t63 = new Tile(6, 3, Color.decode("#8B7355"));
	private Tile t64 = new Tile(6, 4, Color.decode("#CDAA7D"));
	private Tile t65 = new Tile(6, 5, Color.decode("#8B7355"));
	private Tile t66 = new Tile(6, 6, Color.decode("#CDAA7D"));
	private Tile t67 = new Tile(6, 7, Color.decode("#8B7355"));
	private Tile t68 = new Tile(6, 8, Color.decode("#CDAA7D"));
	// Row 7.
	private Tile t71 = new Tile(7, 1, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t72 = new Tile(7, 2, Color.decode("#8B7355"), 2, "B", true);
	private Tile t73 = new Tile(7, 3, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t74 = new Tile(7, 4, Color.decode("#8B7355"), 2, "B", true);
	private Tile t75 = new Tile(7, 5, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t76 = new Tile(7, 6, Color.decode("#8B7355"), 2, "B", true);
	private Tile t77 = new Tile(7, 7, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t78 = new Tile(7, 8, Color.decode("#8B7355"), 2, "B", true);
	// Row 8(bottom).
	private Tile t81 = new Tile(8, 1, Color.decode("#8B7355"), 2, "T", true);
	private Tile t82 = new Tile(8, 2, Color.decode("#CDAA7D"), 2, "S", true);
	private Tile t83 = new Tile(8, 3, Color.decode("#8B7355"), 2, "L", true);
	private Tile t84 = new Tile(8, 4, Color.decode("#CDAA7D"), 2, "Q", true);
	private Tile t85 = new Tile(8, 5, Color.decode("#8B7355"), 2, "K", true);
	private Tile t86 = new Tile(8, 6, Color.decode("#CDAA7D"), 2, "L", true);
	private Tile t87 = new Tile(8, 7, Color.decode("#8B7355"), 2, "S", true);
	private Tile t88 = new Tile(8, 8, Color.decode("#CDAA7D"), 2, "T", true);
	// END of tile object creation.

	// Constructor for game window
	public Board() {
		// Give window attributes.
		this.setVisible(true);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLayout(gridLayoutManager);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// add Rows to Board. Add MouseListener to tiles.
		this.add(t11).addMouseListener(ma);
		this.add(t12).addMouseListener(ma);
		this.add(t13).addMouseListener(ma);
		this.add(t14).addMouseListener(ma);
		this.add(t15).addMouseListener(ma);
		this.add(t16).addMouseListener(ma);
		this.add(t17).addMouseListener(ma);
		this.add(t18).addMouseListener(ma);
		this.t11.addMouseMotionListener(ma);
		this.t12.addMouseMotionListener(ma);
		this.t13.addMouseMotionListener(ma);
		this.t14.addMouseMotionListener(ma);
		this.t15.addMouseMotionListener(ma);
		this.t16.addMouseMotionListener(ma);
		this.t17.addMouseMotionListener(ma);
		this.t18.addMouseMotionListener(ma);

		this.add(t21).addMouseListener(ma);
		this.add(t22).addMouseListener(ma);
		this.add(t23).addMouseListener(ma);
		this.add(t24).addMouseListener(ma);
		this.add(t25).addMouseListener(ma);
		this.add(t26).addMouseListener(ma);
		this.add(t27).addMouseListener(ma);
		this.add(t28).addMouseListener(ma);
		this.t21.addMouseMotionListener(ma);
		this.t22.addMouseMotionListener(ma);
		this.t23.addMouseMotionListener(ma);
		this.t24.addMouseMotionListener(ma);
		this.t25.addMouseMotionListener(ma);
		this.t26.addMouseMotionListener(ma);
		this.t27.addMouseMotionListener(ma);
		this.t28.addMouseMotionListener(ma);

		this.add(t31).addMouseListener(ma);
		this.add(t32).addMouseListener(ma);
		this.add(t33).addMouseListener(ma);
		this.add(t34).addMouseListener(ma);
		this.add(t35).addMouseListener(ma);
		this.add(t36).addMouseListener(ma);
		this.add(t37).addMouseListener(ma);
		this.add(t38).addMouseListener(ma);
		this.t31.addMouseMotionListener(ma);
		this.t32.addMouseMotionListener(ma);
		this.t33.addMouseMotionListener(ma);
		this.t34.addMouseMotionListener(ma);
		this.t35.addMouseMotionListener(ma);
		this.t36.addMouseMotionListener(ma);
		this.t37.addMouseMotionListener(ma);
		this.t38.addMouseMotionListener(ma);

		this.add(t41).addMouseListener(ma);
		this.add(t42).addMouseListener(ma);
		this.add(t43).addMouseListener(ma);
		this.add(t44).addMouseListener(ma);
		this.add(t45).addMouseListener(ma);
		this.add(t46).addMouseListener(ma);
		this.add(t47).addMouseListener(ma);
		this.add(t48).addMouseListener(ma);
		this.t41.addMouseMotionListener(ma);
		this.t42.addMouseMotionListener(ma);
		this.t43.addMouseMotionListener(ma);
		this.t44.addMouseMotionListener(ma);
		this.t45.addMouseMotionListener(ma);
		this.t46.addMouseMotionListener(ma);
		this.t47.addMouseMotionListener(ma);
		this.t48.addMouseMotionListener(ma);

		this.add(t51).addMouseListener(ma);
		this.add(t52).addMouseListener(ma);
		this.add(t53).addMouseListener(ma);
		this.add(t54).addMouseListener(ma);
		this.add(t55).addMouseListener(ma);
		this.add(t56).addMouseListener(ma);
		this.add(t57).addMouseListener(ma);
		this.add(t58).addMouseListener(ma);
		this.t51.addMouseMotionListener(ma);
		this.t52.addMouseMotionListener(ma);
		this.t53.addMouseMotionListener(ma);
		this.t54.addMouseMotionListener(ma);
		this.t55.addMouseMotionListener(ma);
		this.t56.addMouseMotionListener(ma);
		this.t57.addMouseMotionListener(ma);
		this.t58.addMouseMotionListener(ma);

		this.add(t61).addMouseListener(ma);
		this.add(t62).addMouseListener(ma);
		this.add(t63).addMouseListener(ma);
		this.add(t64).addMouseListener(ma);
		this.add(t65).addMouseListener(ma);
		this.add(t66).addMouseListener(ma);
		this.add(t67).addMouseListener(ma);
		this.add(t68).addMouseListener(ma);
		this.t61.addMouseMotionListener(ma);
		this.t62.addMouseMotionListener(ma);
		this.t63.addMouseMotionListener(ma);
		this.t64.addMouseMotionListener(ma);
		this.t65.addMouseMotionListener(ma);
		this.t66.addMouseMotionListener(ma);
		this.t67.addMouseMotionListener(ma);
		this.t68.addMouseMotionListener(ma);

		this.add(t71).addMouseListener(ma);
		this.add(t72).addMouseListener(ma);
		this.add(t73).addMouseListener(ma);
		this.add(t74).addMouseListener(ma);
		this.add(t75).addMouseListener(ma);
		this.add(t76).addMouseListener(ma);
		this.add(t77).addMouseListener(ma);
		this.add(t78).addMouseListener(ma);
		this.t71.addMouseMotionListener(ma);
		this.t72.addMouseMotionListener(ma);
		this.t73.addMouseMotionListener(ma);
		this.t74.addMouseMotionListener(ma);
		this.t75.addMouseMotionListener(ma);
		this.t76.addMouseMotionListener(ma);
		this.t77.addMouseMotionListener(ma);
		this.t78.addMouseMotionListener(ma);

		this.add(t81).addMouseListener(ma);
		this.add(t82).addMouseListener(ma);
		this.add(t83).addMouseListener(ma);
		this.add(t84).addMouseListener(ma);
		this.add(t85).addMouseListener(ma);
		this.add(t86).addMouseListener(ma);
		this.add(t87).addMouseListener(ma);
		this.add(t88).addMouseListener(ma);
		this.t81.addMouseMotionListener(ma);
		this.t82.addMouseMotionListener(ma);
		this.t83.addMouseMotionListener(ma);
		this.t84.addMouseMotionListener(ma);
		this.t85.addMouseMotionListener(ma);
		this.t86.addMouseMotionListener(ma);
		this.t87.addMouseMotionListener(ma);
		this.t88.addMouseMotionListener(ma);
		// END of adding tiles.
	}
	// END of constructor.

	// Creating MouseAdapter.
	MouseAdapter ma = new MouseAdapter() {

		// Mouse is clicked and moved.
		// TODO need a proper algorithm. Still a glitch in here.
		@Override
		public void mouseDragged(MouseEvent mouseEvent) {
			// ListenerInterrupted should stop this event afterwards. It doesn't
			// work though.
			// TODO fix this!
			if (isListenerInterrupted() == false) {
				// Left mouse button is clicked!
				if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
					// Execute mouseClicked for the mouseEvent!
					mouseClicked(mouseEvent);
					// ListenerInterrupted is set to true, so this method should
					// not be executed.
					// TODO this leads to the event that you can call this
					// method only once.
					// This needs to be fixed. Maybe with a timer?
					setListenerInterrupted(true);
				}
				// Do nothing when the right mouse button is clicked!
				else {
				}
			}
			// Do nothing when the listener is interrupted!
			else {
			}
		}
		// END of mouseDraggedMethod.

		// This method is executed when the mouse is moved.
		// This method is currently not in use.
		@Override
		public void mouseMoved(MouseEvent mouseEvent) {
			// unused!
		}
		// END of mouseMovedMethod.

		// Method for a mouse click.
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			// Left mouse button is clicked!
			if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
				// There is currently no figure selected. This attribute is used
				// to separate a click for picking up a figure and a click for
				// moving a figure.
				// No figure is picked up!
				if (isPickedUp() == false) {
					// Asking for the occupation state of the clicked tile and
					// saving that state into class own attribute!
					setTileCurrentlyOccupied(((Tile) mouseEvent.getSource())
							.isTileCurrentlyOccupied());
					// There is no figure on the field!
					if (isTileCurrentlyOccupied() == false) {
						// Print response into console!
						// TODO add proper response or none. This can be done
						// when no console output is needed.
						System.err.println("No Figure!");
					}
					// There is a figure on the field!
					else {
						// Asking for the player state of the clicked tile and
						// saving that state into class own attribute!
						setTileCurrentPlayer(((Tile) mouseEvent.getSource())
								.getTileCurrentPlayer());
						// Checks if figure on clicked tile belongs to current
						// active player!
						if (getTileCurrentPlayer() != getCurrentActivePlayer()) {
							// Print response into console!
							// TODO add proper response or none. This can be
							// done when no console output is needed.
							System.err.println("Not your Figure!");
						}
						// Clicked figure belongs to active player!
						else {
							// Asking for the figure type of the clicked tile
							// and saving that type into class own attribute!
							setChosenFigure(((Tile) mouseEvent.getSource())
									.getTileCurrentFigure());
							// Getting X from clicked figure.
							setPosX(((Tile) mouseEvent.getSource()).getPosX());
							// Getting Y from clicked figure.
							setPosY(((Tile) mouseEvent.getSource()).getPosY());
							// Changing state of pickedUp attribute to be able
							// to move the figure on the next click!
							setPickedUp(true);
							// Changing the occupation state of the clicked tile
							// to false. There is not figure anymore!
							((Tile) mouseEvent.getSource())
									.setTileCurrentlyOccupied(false);
							// Changing the figure type to none. There is no
							// figure anymore!
							// TODO when game is functional then remove the
							// "none" theme!
							((Tile) mouseEvent.getSource())
									.setTileCurrentFigure("none");
							// Changing state of active player. There is no
							// figure of a player anymore!
							((Tile) mouseEvent.getSource())
									.setTileCurrentPlayer(0);
							// Executing mouseEntered method!
							mouseEntered(mouseEvent);
							// Printing clicked tile!
							// TODO remove this when not needed anymore.
							System.out.println(((Tile) mouseEvent.getSource()));
						}
						// END of checking for figure player equality.
					}
					// END of checking for figure on tile.
				}
				// END of algorithm for picking a figure up.
				// Algorithm for moving a figure.
				else {
					// Set clicked tile occupation state to true. Now there is a
					// figure!
					((Tile) mouseEvent.getSource())
							.setTileCurrentlyOccupied(true);
					// Set figure type of tile picked up figure. Now there is
					// that figure!
					((Tile) mouseEvent.getSource())
							.setTileCurrentFigure(getChosenFigure());
					// Set the player state of tile to active player. Now there
					// is a figure from the active player on the tile!
					((Tile) mouseEvent.getSource())
							.setTileCurrentPlayer(getCurrentActivePlayer());
					// Change state pickedUp to false. Now another figure can be
					// picked up!
					setPickedUp(false);
					// Change class own attribute to false!
					setTileCurrentlyOccupied(false);
					// Change class own attribute to 0!
					setTileCurrentPlayer(0);
					// Change class own attribute to "none"!
					setChosenFigure("none");
					// Printing clicked tile!
					// TODO remove this when not needed anymore.
					System.out.println(((Tile) mouseEvent.getSource()));
					// Switch to change the active player after movement.
					// White to Black!
					if (getCurrentActivePlayer() == 1) {
						setCurrentActivePlayer(2);
					}
					// Black to White!
					else {
						setCurrentActivePlayer(1);
					}
					// END of switch.
					// Execute mouseEntered.
					mouseEntered(mouseEvent);
				}
				// END of algorithm for movement.
			}
			// END of left mouse click function.
			// Intercept middle and right click!
			// TODO on right click put figure down on tile where it was picked
			// up.
			else {
				// Printing clicked tile!
				// TODO remove this when not needed anymore.
				System.err.println("STOP IT");
			}
			// END of intercept.
		}
		// END of mouseClicked method.

		// Method for mouseEntered event. It colors the tile when the mouse
		// enters.
		@Override
		public void mouseEntered(MouseEvent mouseEvent) {
			// A figure is picked up!
			if (isPickedUp() == true) {
				// Make tile background Green! Make text Black!
				((Tile) mouseEvent.getSource()).setBackground(Color.GREEN);
				((Tile) mouseEvent.getSource()).getTileFigureDisplay()
						.setForeground(Color.BLACK);
			}
			// Player is White!
			else if (getCurrentActivePlayer() == 1) {
				// Make tile background White! Make text Black!
				((Tile) mouseEvent.getSource()).setBackground(Color.WHITE);
				((Tile) mouseEvent.getSource()).getTileFigureDisplay()
						.setForeground(Color.BLACK);
			}
			// Player is Black!
			else {
				// Make tile background Black! Make text White!
				((Tile) mouseEvent.getSource()).setBackground(Color.BLACK);
				((Tile) mouseEvent.getSource()).getTileFigureDisplay()
						.setForeground(Color.WHITE);
			}
			// END of color selection algorithm.
		}
		// END of mouseEntered method.

		// Method for mouseExited. It colors the tile back to the original
		// color.
		@Override
		public void mouseExited(MouseEvent mouseEvent) {
			// Set the background of the tile to the original tile color!
			// TODO maybe shorten this.
			((Tile) mouseEvent.getSource()).setBackground(
					((Tile) mouseEvent.getSource()).getTileColor());
			// This tile belongs to White!
			if (((Tile) mouseEvent.getSource()).getTileCurrentPlayer() == 1) {
				// Set the text color to White, because there is a White figure!
				((Tile) mouseEvent.getSource()).getTileFigureDisplay()
						.setForeground(Color.WHITE);
			}
			// This tile belongs to Black!
			if (((Tile) mouseEvent.getSource()).getTileCurrentPlayer() == 2) {
				// Set the text color to Black, because there is a Black figure!
				((Tile) mouseEvent.getSource()).getTileFigureDisplay()
						.setForeground(Color.BLACK);
			}
			// This tile doesn't belong to a player!
			if (((Tile) mouseEvent.getSource()).getTileCurrentPlayer() == 0) {
				// Set the text color to Red, because there is no figure!
				// TODO this needs to be taken out when not needed anymore.
				((Tile) mouseEvent.getSource()).getTileFigureDisplay()
						.setForeground(Color.RED);
			}
			// END of color selection algorithm.
		}
		// END of method for mouseExited.

		// Method for mousePressed event.
		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			// unused!
		}
		// END of mousePressed method.

		// Method for mouseReleased event.
		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			// unused!
		}
		// END of mouseReleased event.
	};
	// END of mouseAdapter.

	// Getter and Setter methods.
	public int getCurrentActivePlayer() {
		return currentActivePlayer;
	}
	public void setCurrentActivePlayer(int currentActivePlayer) {
		this.currentActivePlayer = currentActivePlayer;
	}
	public boolean isListenerInterrupted() {
		return ListenerInterrupted;
	}
	public void setListenerInterrupted(boolean listenerInterrupted) {
		ListenerInterrupted = listenerInterrupted;
	}
	public boolean isPickedUp() {
		return pickedUp;
	}
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
	public String getChosenFigure() {
		return chosenFigure;
	}
	public void setChosenFigure(String chosenFigure) {
		this.chosenFigure = chosenFigure;
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
	public int getTileCurrentPlayer() {
		return tileCurrentPlayer;
	}
	public void setTileCurrentPlayer(int tileCurrentPlayer) {
		this.tileCurrentPlayer = tileCurrentPlayer;
	}
	// END of Getter and Setter methods.
}
// END of class.