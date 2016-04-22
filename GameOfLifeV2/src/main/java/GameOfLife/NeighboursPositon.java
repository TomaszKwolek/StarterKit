package GameOfLife;

public enum NeighboursPositon {

	WN(-1,-1),
	N(0,-1),
	EN(1,-1),	
	W(-1,0),
	WS(-1,1),
	S(0,1),	
	E(1,0),
	ES(1,1);
		
	private int xPosition, yPosition;
	
	NeighboursPositon(int xPos, int yPos){
		xPosition = xPos;
		yPosition = yPos;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
}
