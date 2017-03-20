import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Board extends JFrame// implements MouseListener
{
	private boolean ListenerInterrupted = false;
	//final Container parent=this;
	private int currentActivePlayer = 1;
		//White = 1
		//Black = 2
	private GridLayout gridLayoutManager = new GridLayout(8,8);
		//Layout for the Board
	
	private boolean pickedUp = false;
	private String chosenFigure = "none";
	/*	0 = none 			none
		1 = Pawn(Bauer)		P
		2 = Bishop(L�ufer)	B
		3 = Knight(Springer)Kn
		4 = Rook(Turm)		R
		5 = King(K�nig)		K
		6 = Queen(K�nigin)	Q
	 */
	private boolean tileCurrentlyOccupied = false;
	private int tileCurrentPlayer = 0;
	private int posX = 0;
	private int posY = 0;
	
	//Top Row
	private Tile t11 = new Tile(1, 1, Color.decode("#CDAA7D"), 1, "T", true);
	private Tile t12 = new Tile(1, 2, Color.decode("#8B7355"), 1, "S", true);
	private Tile t13 = new Tile(1, 3, Color.decode("#CDAA7D"), 1, "L", true);
	private Tile t14 = new Tile(1, 4, Color.decode("#8B7355"), 1, "Q", true);
	private Tile t15 = new Tile(1, 5, Color.decode("#CDAA7D"), 1, "K", true);
	private Tile t16 = new Tile(1, 6, Color.decode("#8B7355"), 1, "L", true);
	private Tile t17 = new Tile(1, 7, Color.decode("#CDAA7D"), 1, "S", true);
	private Tile t18 = new Tile(1, 8, Color.decode("#8B7355"), 1, "T", true);
	
	private Tile t21 = new Tile(2, 1, Color.decode("#8B7355"), 1, "B", true);
	private Tile t22 = new Tile(2, 2, Color.decode("#CDAA7D"), 1, "B", true);
	private Tile t23 = new Tile(2, 3, Color.decode("#8B7355"), 1, "B", true);
	private Tile t24 = new Tile(2, 4, Color.decode("#CDAA7D"), 1, "B", true);
	private Tile t25 = new Tile(2, 5, Color.decode("#8B7355"), 1, "B", true);
	private Tile t26 = new Tile(2, 6, Color.decode("#CDAA7D"), 1, "B", true);
	private Tile t27 = new Tile(2, 7, Color.decode("#8B7355"), 1, "B", true);
	private Tile t28 = new Tile(2, 8, Color.decode("#CDAA7D"), 1, "B", true);

	private Tile t31 = new Tile(3, 1, Color.decode("#CDAA7D"));
	private Tile t32 = new Tile(3, 2, Color.decode("#8B7355"));
	private Tile t33 = new Tile(3, 3, Color.decode("#CDAA7D"));
	private Tile t34 = new Tile(3, 4, Color.decode("#8B7355"));
	private Tile t35 = new Tile(3, 5, Color.decode("#CDAA7D"));
	private Tile t36 = new Tile(3, 6, Color.decode("#8B7355"));
	private Tile t37 = new Tile(3, 7, Color.decode("#CDAA7D"));
	private Tile t38 = new Tile(3, 8, Color.decode("#8B7355"));

	private Tile t41 = new Tile(4, 1, Color.decode("#8B7355"));
	private Tile t42 = new Tile(4, 2, Color.decode("#CDAA7D"));
	private Tile t43 = new Tile(4, 3, Color.decode("#8B7355"));
	private Tile t44 = new Tile(4, 4, Color.decode("#CDAA7D"));
	private Tile t45 = new Tile(4, 5, Color.decode("#8B7355"));
	private Tile t46 = new Tile(4, 6, Color.decode("#CDAA7D"));
	private Tile t47 = new Tile(4, 7, Color.decode("#8B7355"));
	private Tile t48 = new Tile(4, 8, Color.decode("#CDAA7D"));
	
	private Tile t51 = new Tile(5, 1, Color.decode("#CDAA7D"));
	private Tile t52 = new Tile(5, 2, Color.decode("#8B7355"));
	private Tile t53 = new Tile(5, 3, Color.decode("#CDAA7D"));
	private Tile t54 = new Tile(5, 4, Color.decode("#8B7355"));
	private Tile t55 = new Tile(5, 5, Color.decode("#CDAA7D"));
	private Tile t56 = new Tile(5, 6, Color.decode("#8B7355"));
	private Tile t57 = new Tile(5, 7, Color.decode("#CDAA7D"));
	private Tile t58 = new Tile(5, 8, Color.decode("#8B7355"));

	private Tile t61 = new Tile(6, 1, Color.decode("#8B7355"));
	private Tile t62 = new Tile(6, 2, Color.decode("#CDAA7D"));
	private Tile t63 = new Tile(6, 3, Color.decode("#8B7355"));
	private Tile t64 = new Tile(6, 4, Color.decode("#CDAA7D"));
	private Tile t65 = new Tile(6, 5, Color.decode("#8B7355"));
	private Tile t66 = new Tile(6, 6, Color.decode("#CDAA7D"));
	private Tile t67 = new Tile(6, 7, Color.decode("#8B7355"));
	private Tile t68 = new Tile(6, 8, Color.decode("#CDAA7D"));

	private Tile t71 = new Tile(7, 1, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t72 = new Tile(7, 2, Color.decode("#8B7355"), 2, "B", true);
	private Tile t73 = new Tile(7, 3, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t74 = new Tile(7, 4, Color.decode("#8B7355"), 2, "B", true);
	private Tile t75 = new Tile(7, 5, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t76 = new Tile(7, 6, Color.decode("#8B7355"), 2, "B", true);
	private Tile t77 = new Tile(7, 7, Color.decode("#CDAA7D"), 2, "B", true);
	private Tile t78 = new Tile(7, 8, Color.decode("#8B7355"), 2, "B", true);

	private Tile t81 = new Tile(8, 1, Color.decode("#8B7355"), 2, "T", true);
	private Tile t82 = new Tile(8, 2, Color.decode("#CDAA7D"), 2, "S", true);
	private Tile t83 = new Tile(8, 3, Color.decode("#8B7355"), 2, "L", true);
	private Tile t84 = new Tile(8, 4, Color.decode("#CDAA7D"), 2, "Q", true);
	private Tile t85 = new Tile(8, 5, Color.decode("#8B7355"), 2, "K", true);
	private Tile t86 = new Tile(8, 6, Color.decode("#CDAA7D"), 2, "L", true);
	private Tile t87 = new Tile(8, 7, Color.decode("#8B7355"), 2, "S", true);
	private Tile t88 = new Tile(8, 8, Color.decode("#CDAA7D"), 2, "T", true);
	//Bottom Row
	
	public Board(){
		this.setVisible(true);
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLayout(gridLayoutManager);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//add Rows to Board
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
		
	}
	
	MouseAdapter ma = new MouseAdapter(){

		@Override
		public void mouseDragged(MouseEvent mouseEvent) {
			if(isListenerInterrupted() == false){
				if(SwingUtilities.isLeftMouseButton(mouseEvent)){
					mouseClicked(mouseEvent);
					setListenerInterrupted(true);
				}
				else{}		
			}
			else{}
		}

		@Override
		public void mouseMoved(MouseEvent mouseEvent) {
			// unused!
		}
	
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			//
			if(SwingUtilities.isLeftMouseButton(mouseEvent)){
				if(isPickedUp()==false){
					setTileCurrentlyOccupied(((Tile) mouseEvent.getSource()).isTileCurrentlyOccupied());
						if(isTileCurrentlyOccupied() == false){
							System.err.println("No Figure!");
						}
						else{
							setTileCurrentPlayer(((Tile) mouseEvent.getSource()).getTileCurrentPlayer());
							if(getTileCurrentPlayer() != getCurrentActivePlayer()){
								System.err.println("Not your Figure!");
							}
							else{
								setChosenFigure(((Tile) mouseEvent.getSource()).getTileCurrentFigure());
								//setPosX(((Tile) mouseEvent.getSource()).getPosX());
								//setPosY(((Tile) mouseEvent.getSource()).getPosY());
								setPickedUp(true);
								((Tile) mouseEvent.getSource()).setTileCurrentlyOccupied(false);
								((Tile) mouseEvent.getSource()).setTileCurrentFigure("none");
								((Tile) mouseEvent.getSource()).setTileCurrentPlayer(0);
								mouseEntered(mouseEvent);
								System.out.println(((Tile) mouseEvent.getSource()));
								
							}
						}
					
				}
				else{
					((Tile) mouseEvent.getSource()).setTileCurrentlyOccupied(true);
					((Tile) mouseEvent.getSource()).setTileCurrentFigure(getChosenFigure());
					((Tile) mouseEvent.getSource()).setTileCurrentPlayer(getCurrentActivePlayer());
					setPickedUp(false);
					setTileCurrentlyOccupied(false);
					setTileCurrentPlayer(0);
					setChosenFigure("none");
					System.out.println(((Tile) mouseEvent.getSource()));
					if(getCurrentActivePlayer() == 1){
						setCurrentActivePlayer(2);
					}
					else{
						setCurrentActivePlayer(1);
					}
					mouseEntered(mouseEvent);
				}
				
				
				
				
				
				
				/*if (getCurrentActivePlayer()==1){
					setCurrentActivePlayer(2);
					((Tile) mouseEvent.getSource()).setBackground(Color.BLACK);
					((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.WHITE);
				}
				else{
					setCurrentActivePlayer(1);
					((Tile) mouseEvent.getSource()).setBackground(Color.WHITE);
					((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.BLACK);
				}*/
				
			}
			else{
				System.err.println("STOP IT");
			}
			//setListenerInterrupted(false);

		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {
		//
			if (isPickedUp()==true){
				((Tile) mouseEvent.getSource()).setBackground(Color.GREEN);
				((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.BLACK);
			}
			else if(getCurrentActivePlayer()==1){
				((Tile) mouseEvent.getSource()).setBackground(Color.WHITE);
				((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.BLACK);
			}
			else{
				((Tile) mouseEvent.getSource()).setBackground(Color.BLACK);
				((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.WHITE);
			}
		}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {
		//
			((Tile) mouseEvent.getSource()).setBackground(((Tile) mouseEvent.getSource()).getTileColor()); //Magic
			if(((Tile) mouseEvent.getSource()).getTileCurrentPlayer() == 1){
				((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.WHITE);
			}
			if(((Tile) mouseEvent.getSource()).getTileCurrentPlayer() == 2){
				((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.BLACK);
			}
			if(((Tile) mouseEvent.getSource()).getTileCurrentPlayer() == 0){
				((Tile) mouseEvent.getSource()).getTileFigureDisplay().setForeground(Color.RED);
			}	
		}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			// unused!
		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			// unused!
		}};
	
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

}