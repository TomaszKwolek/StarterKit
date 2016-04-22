package GameOfLifeTest;
import static org.junit.Assert.*;

import org.junit.Test;

import GameOfLife.Cell;
import GameOfLife.CellState;
import GameOfLife.EmptyInputTableException;
import GameOfLife.GameOfLife;

public class GameOfLifeTest {

	CellState c;
			
	@Test
	public void shouldCreateBoardTable() {
	//given
		CellState[][] inputBoardTable = {
				{c.ALIVE, c.DEAD, c.ALIVE, c.DEAD, c.ALIVE},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD},
				{c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.ALIVE},
				{c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE},
				{c.DEAD, c.ALIVE, c.DEAD, c.ALIVE, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		//then
		assertEquals(inputBoardTable.length, game.getCurrentBoard().size());
		assertEquals(inputBoardTable[0].length, game.getCurrentBoard().get(0).size());				
	}
	
	@Test
	public void shouldReturnDEADForDEADCellWithoutLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.DEAD);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnDEADForDEADCellWithTwoLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.DEAD);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.DEAD, c.ALIVE},
				{c.ALIVE, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnAliveForDEADCellWithThreeLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.ALIVE);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.DEAD, c.ALIVE},
				{c.ALIVE, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.ALIVE},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnDEADForDeadCellWithFourLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.DEAD);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.ALIVE, c.ALIVE},
				{c.ALIVE, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.ALIVE},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}

	@Test
	public void shouldReturnDEADForLivingCellWithZeroLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.DEAD);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.ALIVE, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnDEADForLivingCellWithOneLivingNeighbour() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.DEAD);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.ALIVE, c.DEAD},
				{c.DEAD, c.ALIVE, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnAlIVEForLivingCellWithTwoLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.ALIVE);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.ALIVE, c.DEAD},
				{c.DEAD, c.ALIVE, c.DEAD},
				{c.ALIVE, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnAlIVEForLivingCellWithThreeLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.ALIVE);
		CellState[][] inputBoardTable = {
				{c.DEAD, c.ALIVE, c.DEAD},
				{c.DEAD, c.ALIVE, c.ALIVE},
				{c.ALIVE, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnAlIVEForLivingCellWithFourLivingNeighbours() {
	//given
		Cell expectedCell = new Cell(0,0);
		expectedCell.setCellState(CellState.DEAD);
		CellState[][] inputBoardTable = {
				{c.ALIVE, c.ALIVE, c.DEAD},
				{c.DEAD, c.ALIVE, c.ALIVE},
				{c.ALIVE, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(1);
		//then
		assertEquals(expectedCell.getCellStateValue(), game.getCurrentBoard().get(1).get(1).getCellStateValue());			
	}
	
	@Test
	public void shouldReturnCorrectTableAfterSevetnyFifeGenerationsForCrocodile() {
	//given
		CellState[][] expectedBordTable = {
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
		};
		CellState[][] inputBoardTable = {
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(75);
		//then
		int boardWidth=game.getCurrentBoard().size();
		int boardHeight=game.getCurrentBoard().get(1).size();
		for(int i=0; i<boardWidth; i++){
			for(int j=0; j<boardHeight; j++){
				assertEquals(expectedBordTable[i][j], game.getCurrentBoard().get(i).get(j).getCellState());	
				}
		}		
	}
	
	@Test
	public void shouldReturnCorrectTableAfterSevetnySixGenerationsForCrocodile() {
	//given

		CellState[][] expectedBordTable = {
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
		};
		
		CellState[][] inputBoardTable = {
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
				{c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.ALIVE, c.ALIVE, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD, c.DEAD},
		};
		//when
		GameOfLife game = new GameOfLife(inputBoardTable);
		game.goToGeneration(76);
		//then
		int boardWidth=game.getCurrentBoard().size();
		int boardHeight=game.getCurrentBoard().get(1).size();
		for(int i=0; i<boardWidth; i++){
			for(int j=0; j<boardHeight; j++){
				assertEquals(expectedBordTable[i][j], game.getCurrentBoard().get(i).get(j).getCellState());	
				}
		}		
	}
	
}
