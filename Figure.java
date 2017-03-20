import java.util.concurrent.TimeUnit;

//This class has the movement algorithms of all figures.
public class Figure {
	
	//Attributes for calculating figure movement.
	//TODO safe all foreign figures in an array.
	private int activePlayer = 1;
	private String activeFigure = "P";
	private int activeFigureX = 2;
	private int activeFigureY = 2;
	private boolean alreadyMoved = false;
	private int field [][] = new int [8][8];
	private int allowedMoving [][] = new int [8][8] ;
	
	/*	0 = none 		none
		1 = Pawn(Bauer)		P
		2 = Bishop(Läufer)	B
		3 = Knight(Springer)	Kn
		4 = Rook(Turm)		R
		5 = King(König)		K
		6 = Queen(Königin)	Q
	*/
	private String foreignFigure = "F";
	private boolean foreignOccupied = true;
	private int foreignFigurePlayer = 2;
	private int foreignFigureX = 3;
	private int foreignFigureY = 3;
	//END of attributes
	
	//constructor for moving algorithm.
	public Figure(){
		//call moving algorithm.
		calculateAllowedMovement();
	}
	//END of constructor.
	
	//Moving algorithm. Fills calculation into arrays. Searches for figures on board!
	public void calculateAllowedMovement(){
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				//Found active figure on the board! Marking it with 1!
				if(getActiveFigureX() == x && getActiveFigureY() == y){
					field[y][x] = 1;
				}
				//Found foreign figure on the board! Marking it with 2!
				//TODO add the function to find more than one figure.
				else if(getForeignFigureX() == x && getForeignFigureY() == y){
					field[y][x] = 2;
				}
				//Found empty field on the board! Marking it with 0!
				else{
					field[y][x] = 0;
				}
				//Do a break for printing into console!
				//TODO remove after implementation into the game!
				try {
					//Break is 5 millisecond.
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					//Break can't be executed!
					System.err.println("Breaktimer in class Figure at 52 doesn't work! Printing StackTrace!");
					e.printStackTrace();
				}
				//Printing current field of the board array.
				System.out.print(field[y][x] + " ");
			}
			//Print a line break for visualizing array as board in console!
			System.out.println(" Stop");
		}
		//Printing a spacer for separating arrays in console!
		System.out.println();
		System.out.println("Spacer");
		//END of printing board array.
		
		//What is the active figure?
		
		//Active Figure is Pawn! Executing Pawn moving logic!
		if(getActiveFigure() == "P"){
			logicP();
		}
		//Active Figure is Rook! Executing Rook moving logic!
		if(getActiveFigure() == "R"){
			logicR();
		}
		//TODO add logic for other figures as well!
		//END of searching for active figure.
		
		//Moving algorithm. Prints allowed movement.
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				//Can move to field on board! Marking it with 3(can override figures)!
				if(allowedMoving[y][x] == 3){
					System.err.print(allowedMoving[y][x] + " ");
				}
				//Can't move to field on board! Marking it with 0(none), 1(activeFigure), 2(foreignFigure)!
				else{
					System.out.print(allowedMoving[y][x] + " ");
				}
				//Do a break for printing into console!
				//TODO remove after implementation into the game!
				try {
					//Wait for 5 milliseconds!
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					//Can't execute waiting timer!
					System.err.println("Breaktimer in class Figure at 92 doesn't work! Printing StackTrace!");
					e.printStackTrace();
				}
			}
			//Print a line break for visualizing array as board in console!
			System.out.println(" Stop");
		}
		//END of allowed movement printing.
	}//END of moving algorithm.
	
	//Algorithms for figure movements.
	//Calculation algorithm for movement of the Pawn figure.
	private void logicP(){
		//TODO Still need some logic for reaching the enemys end
		
		//Find the current Position of the active Figure on the Board.
		for	(int y=0;y<8;y++){
			for (int x=0;x<8;x++){
				//Found the active Figure! Marking this field with 1 in Array!
				if(getActiveFigureX() == x && getActiveFigureY() == y){
					allowedMoving[y][x] = 1;
				}
				//Still not found active Figure! Marking this field with 0 in Array!
				else {
					allowedMoving[y][x] = 0;
				}
			}
		}
		
		//Algorithm for first movement of the Pawn.
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
					//Nothing is in the way! Can move one step!
					if(getActiveFigureX() != getForeignFigureX()){
						allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
					}
					//Something is in the way! Can't move at all!
					else{}
				}
				//Nothing is in the way! Can move one step!
				else{
					allowedMoving[getActiveFigureY()-1][getActiveFigureX()] = 3;
				}
			}
		}
		
		//Algorithm to kick another figure.
		//Who is the active player?
		//What color has the foreign figure?
		//Where is the foreign figure?
		
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
	
	//Calculation algorithm for movement of the Rook figure.
	private void logicR(){
		
	}
	//END of figure movement algorithms.
	
	//Getter and Setter methods.
	//TODO alter or remove unused, old or changed attributes!
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
	//END of Getter and Setter methods
}
//END of class
