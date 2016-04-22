package GameOfLife;

public class Cell {
	
	private CellState currentState;
	private CellState stateInNextGeneration;
	private int xPosition=0;
	private int yPosition=0;
	private int numberOfLivingNeighbours=0;
	
	public Cell(int xPos, int yPos){
		xPosition=xPos;
		yPosition=yPos;
	}

	/**
	 * @param state of the cell in next generation
	 */
	public void setCellState(CellState newState){
		currentState=newState;
	}
	
	public void setNumberOfLivinNeighbours(int numberOfLivingNeighbours){
		this.numberOfLivingNeighbours=numberOfLivingNeighbours;
	}
	
	/**
	 * @return current states value of the in current generation (DEAD->, ALIVE->2)
	 */
	public int getCellStateValue(){
		return currentState.getState();
	}
	
	/**
	 * @return current state of the cell
	 */
	public CellState getCellState(){
		return currentState;
	}
	
	/**
	 * calculate state of the cell in next generation
	 */
	public void calculateStateInNextGeneration(){
		stateInNextGeneration=currentState;
		if(numberOfLivingNeighbours<2 || numberOfLivingNeighbours>3){
			stateInNextGeneration=CellState.DEAD;
		}	
		if(numberOfLivingNeighbours==3){
			stateInNextGeneration=CellState.ALIVE;
		}	
	}
	
	/**
	 * update current state of the cell
	 */
	public void updateCurrentState(){
		currentState=stateInNextGeneration;
	}
	
}
