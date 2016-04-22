package GameOfLife;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class GameOfLife  {

	private List<List<Cell>> board = new ArrayList<List<Cell>>();
	private static final Logger log4j = LogManager.getLogger(GameOfLife.class.getName());
	
	public GameOfLife(CellState[][] inputBoard) {
		try {
			board=createBoard(inputBoard);
		} catch (WrongCellsStateException e) {
			log4j.warn("Wrong state of cells in input table!", e);
		} catch (EmptyInputTableException e) {
			log4j.warn("Input table ampty!", e);
		}
	}

	/**
	 * @param number
	 *            of generations to the resulting generation
	 */
	public void goToGeneration(int numberOfGeneration) {
		for (int i = 0; i < numberOfGeneration; i++) {
			setNumberOfLivinNeighobursForEachCell(board);
			calculateNextStates(board);
			updateAllStates(board);
		}
	}

	/**
	 * @return game board
	 */
	public List<List<Cell>> getCurrentBoard() {
		return board;
	}

	private void calculateNextStates(List<List<Cell>> gameBoard) {
		int boardWidth=boardWeidth(gameBoard);
		int boardHeight=boardHeight(gameBoard);
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				gameBoard.get(i).get(j).calculateStateInNextGeneration();
			}
		}
	}

	private void updateAllStates(List<List<Cell>> gameBoard) {
		int boardWidth=boardWeidth(gameBoard);
		int boardHeight=boardHeight(gameBoard);
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				gameBoard.get(i).get(j).updateCurrentState();
			}
		}
	}

	private List<List<Cell>> createBoard(CellState[][] inputBoardTable) throws WrongCellsStateException, EmptyInputTableException {
		List<List<Cell>> gameBoard = new ArrayList<List<Cell>>();
		checkSizeOfTheInputTable(inputBoardTable);
		int gameBoardWidth = inputBoardTable.length;
		int gameBoardHeight = inputBoardTable[0].length;
		for (int i = 0; i < gameBoardWidth; i++) {
			gameBoard.add(new ArrayList<Cell>(gameBoardWidth));
			for (int j = 0; j < gameBoardHeight; j++) {
				gameBoard.get(i).add(new Cell(i, j));
				checkInputStateOfTheCell(inputBoardTable, i, j);
				gameBoard.get(i).get(j).setCellState(inputBoardTable[i][j]);
			}
		}
		return gameBoard;
	}
	
	private int boardWeidth(List<List<Cell>> board){
		return board.size();
		
	}
	
	private int boardHeight(List<List<Cell>> board){
		return board.get(0).size();
		
	}

	private void checkInputStateOfTheCell(CellState[][] inputBoardTable, int i, int j) throws WrongCellsStateException {
		if (inputBoardTable[i][j].getState() != 0 && inputBoardTable[i][j].getState() != 1) {
			throw new WrongCellsStateException("Wrong cells state! The cell should be ALIVE or DEAD");
		}
	}

	private void checkSizeOfTheInputTable(CellState[][] inputBoardTable) throws EmptyInputTableException {
		if (inputBoardTable.length == 0) {
			throw new EmptyInputTableException("Input table is empty!");
		}
	}

	private void setNumberOfLivinNeighobursForEachCell(List<List<Cell>> gameBoard) {
		int boardWidth=boardWeidth(gameBoard);
		int boardHeight=boardHeight(gameBoard);
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				int numberOfLN = numberOfLivingNeighbours(i, j, board);
				board.get(i).get(j).setNumberOfLivinNeighbours(numberOfLN);
			}
		}

	}

	private int numberOfLivingNeighbours(int xPosition, int yPosition, List<List<Cell>> gameBoard) {
		int numberOfLivingNeighbours = 0;
		int boardWidth=boardWeidth(gameBoard);
		int boardHeight=boardHeight(gameBoard);
		for (NeighboursPositon offsetPosition : NeighboursPositon.values()) {
			int xPosNeighbour = xPosition + offsetPosition.getXPosition();
			int yPosNeighbour = yPosition + offsetPosition.getYPosition();
			if (xPosNeighbour >= 0 && xPosNeighbour <= boardWidth - 1 && yPosNeighbour >= 0
					&& yPosNeighbour <= boardHeight - 1) {
				int neighbourStateValue = gameBoard.get(xPosNeighbour).get(yPosNeighbour).getCellStateValue();
				numberOfLivingNeighbours += neighbourStateValue;
			}
		}
		return numberOfLivingNeighbours;
	}

}
