import java.util.concurrent.TimeUnit;

public class Figure {
	
	
	private int activePlayer = 1;
	private String activeFigure = "P";
	private int activeFigureX = 2;
	private int activeFigureY = 2;
	private boolean alreadyMoved = false;
	private int field [][] = new int [8][8];
	private int allowedMoving [][] = new int [8][8] ;
	
	/*	0 = none 			none
		1 = Pawn(Bauer)		P
		2 = Bishop(Läufer)	B
		3 = Knight(Springer)Kn
		4 = Rook(Turm)		R
		5 = King(König)		K
		6 = Queen(Königin)	Q
	*/
	private String foreignFigure = "F";
	private boolean foreignOccupied = true;
	private int foreignFigurePlayer = 2;
	private int foreignFigureX = 3;
	private int foreignFigureY = 3;
	
	
	public Figure(){
		calculateAllowedMovement();
	}
	
	public void calculateAllowedMovement(){
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(getActiveFigureX() == x && getActiveFigureY() == y){
					field[y][x] = 1;
				}
				else if(getForeignFigureX() == x && getForeignFigureY() == y){
					field[y][x] = 2;
				}
				else{
					field[y][x] = 0;
				}
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					System.err.println("screwed at Time");
					e.printStackTrace();
				}
				System.out.println();
			}
		}
		
		if(getActiveFigure() == "P"){
			logicP();
		}
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				if(allowedMoving[y][x] == 3){
					System.err.print(field[y][x] + " ");
					System.err.print(allowedMoving[y][x] + " ");
					
				}
				else{
					System.out.print(field[y][x] + " ");
					System.out.print(allowedMoving[y][x] + " ");
				}
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					System.err.println("screwed at Time");
					e.printStackTrace();
				}
			}
			
			System.out.println(" Stop");
		}
		
	}
	
	private void logicP(){
		//TODO Still need some logic for reaching the enemys end
		
		//Find the current Position of the active Figure on the Board.
		for	(int y=0;y<8;y++){
			for (int x=0;x<8;x++){
				if(getActiveFigureX() == x && getActiveFigureY() == y){
					allowedMoving[y][x] = 1;
				}
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		//
		
		//Algorithm for first movement of the Pawn
		//Was the figure moved?
		//Who is the active Player?
		//Is something in front of the Pawn?
		
		//Pawn wasn't moved!
		if(isAlreadyMoved() == false){
			//White Player is active player! This means Pawn moves towards Black!
			if(getActivePlayer() == 1){
				//Nothing is in the way! Can move two steps!
				if(getActiveFigureY()<(getForeignFigureY()-2)&&getActiveFigureY()>(getForeignFigureY()-4)&&getActiveFigureX()==getForeignFigureX()||getActiveFigureY()<(getForeignFigureY()-4)&&getActiveFigureX()==getForeignFigureX()){
					allowedMoving[getActiveFigureY()+1][getActiveFigureX()] = 3;
					allowedMoving[getActiveFigureY()+2][getActiveFigureX()] = 3;
				}
				//Something is in the way! Can only move one step!
				else if(getActiveFigureY()<(getForeignFigureY()-1)&&getActiveFigureY()>(getForeignFigureY()-3)&&getActiveFigureX()==getForeignFigureX()||getActiveFigureY()<(getForeignFigureY()-3)&&getActiveFigureX()==getForeignFigureX()){
					allowedMoving[getActiveFigureY()+1][getActiveFigureX()] = 3;
				}
				//Nothing is in the way! Can move two steps!
				else if(getActiveFigureX() != getForeignFigureX()){
					allowedMoving[getActiveFigureY()+1][getActiveFigureX()] = 3;
					allowedMoving[getActiveFigureY()+2][getActiveFigureX()] = 3;
				}
				//Something is in the way! Can't move at all!
				else{}
			}
			//Black player is active player! This means Pawn moves towards White!
			else{
				//Nothing is in the way! Can move two steps!
				if(getActiveFigureY()>(getForeignFigureY()+2)&&getActiveFigureY()<(getForeignFigureY()+4)&&getActiveFigureX()==getForeignFigureX()||getActiveFigureY()>(getForeignFigureY()+4)&&getActiveFigureX()==getForeignFigureX()){
					allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
					allowedMoving[getActiveFigureY()-2][getActiveFigureX()] = 3;
				}
				//Something is in the way! Can only move one step!
				else if(getActiveFigureY()>(getForeignFigureY()+1)&&getActiveFigureY()<(getForeignFigureY()+3)&&getActiveFigureX()==getForeignFigureX()||getActiveFigureY()>(getForeignFigureY()+3)&&getActiveFigureX()==getForeignFigureX()){
					allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
				}
				//Nothing is in the way! Can move two steps!
				else if(getActiveFigureX() != getForeignFigureX()){
					allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
					allowedMoving[getActiveFigureY()-2][getActiveFigureX()] = 3;
				}
				//Something is in the way! Can't move at all!
				else{}
			}
		}
		//the Figure was moved!
		else{
			//White player is active player! This means Pawn moves towards Black!
			if(getActivePlayer() == 1){
				
				if(getForeignFigureY()<= getActiveFigureY()+1){
					//Nothing is in the way! Can move one step!
					if(getActiveFigureX() != getForeignFigureX()){
						allowedMoving[getActiveFigureY()+1][getActiveFigureX()] = 3;
					}
					//Something is in the way! Can't move at all!
					else{}
				}
				//Nothing is in the way! Can move one step!
				else{
					allowedMoving[getActiveFigureY()+1][getActiveFigureX()] = 3;
				}
			}
			//Black player is active player! This means Pawn moves towards White!
			else{
				if(getForeignFigureY()>= getActiveFigureY()-1){
					if(getActiveFigureX() != getForeignFigureX()){
						allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
					}
					else{
						
					}
				}
				else{
					allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
				}
			}
		}
		
		//Algorithm to kick another figure
		//White player is active player! Foreign figure is Black and is under and right of active figure! 
		if(getActivePlayer() == 1 && getActiveFigureY()+1 == getForeignFigureY() && getActiveFigureX()+1 == getForeignFigureX() && getForeignFigurePlayer() != getActivePlayer()){
			allowedMoving[getActiveFigureY()+1][getActiveFigureX()+1] = 3;
		}
		//White player is active player! Foreign figure is Black and is under and left of active figure!
		else if(getActivePlayer() == 1 && getActiveFigureY()+1 == getForeignFigureY() && getActiveFigureX()-1 == getForeignFigureX() && getForeignFigurePlayer() != getActivePlayer()){
			allowedMoving[getActiveFigureY()+1][getActiveFigureX()-1] = 3;
		}
		//Black player is active player! Foreign figure is White and is above and right of active figure!
		else if(getActivePlayer() == 2 && getActiveFigureY()-1 == getForeignFigureY() && getActiveFigureX()+1 == getForeignFigureX() && getForeignFigurePlayer() != getActivePlayer()){
			allowedMoving[getActiveFigureY()-1][getActiveFigureX()+1] = 3;
		}
		//Black player is active player! Foreign figure is White and is above and left of active figure! 
		else if(getActivePlayer() == 2 && getActiveFigureY()-1 == getForeignFigureY() && getActiveFigureX()-1 == getForeignFigureX() && getForeignFigurePlayer() != getActivePlayer()){
			allowedMoving[getActiveFigureY()-1][getActiveFigureX()-1] = 3;
		}
		//Nothing to kick!
		else{}
	}
	
	private void logicT(){
		
	}
	public int getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(int activePlayer) {
		this.activePlayer = activePlayer;
	}

	public String getActiveFigure() {
		return activeFigure;
	}

	public void setActiveFigure(String activeFigure) {
		this.activeFigure = activeFigure;
	}

	public int getActiveFigureX() {
		return activeFigureX;
	}

	public void setActiveFigureX(int activeFigureX) {
		this.activeFigureX = activeFigureX;
	}

	public int getActiveFigureY() {
		return activeFigureY;
	}

	public void setActiveFigureY(int activeFigureY) {
		this.activeFigureY = activeFigureY;
	}

	public boolean isForeignOccupied() {
		return foreignOccupied;
	}

	public void setForeignOccupied(boolean foreignOccupied) {
		this.foreignOccupied = foreignOccupied;
	}

	public int getForeignFigureX() {
		return foreignFigureX;
	}

	public void setForeignFigureX(int foreignFigureX) {
		this.foreignFigureX = foreignFigureX;
	}

	public int getForeignFigureY() {
		return foreignFigureY;
	}

	public void setForeignFigureY(int foreignFigureY) {
		this.foreignFigureY = foreignFigureY;
	}

	public boolean isAlreadyMoved() {
		return alreadyMoved;
	}

	public void setAlreadyMoved(boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}

	public int[][] getAllowedMoving() {
		return field;
	}

	public void setAllowedMoving(int allowedMoving[][]) {
		this.field = allowedMoving;
	}

	public String getForeignFigure() {
		return foreignFigure;
	}

	public void setForeignFigure(String foreignFigure) {
		this.foreignFigure = foreignFigure;
	}
	
	public int[][] getField() {
		return field;
	}

	public void setField(int[][] field) {
		this.field = field;
	}

	public int getForeignFigurePlayer() {
		return foreignFigurePlayer;
	}

	public void setForeignFigurePlayer(int foreignFigurePlayer) {
		this.foreignFigurePlayer = foreignFigurePlayer;
	}

}
