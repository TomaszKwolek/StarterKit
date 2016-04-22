package PokerGameTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import PokerGame.HandsFileReader;
import PokerGame.HandsReader;
import PokerGame.PokerGame;

public class PokerGameTest {

	private HandsReader handsReader= null;
	
	@Test
	public void shouldReturnZeroEmptyFile() throws FileNotFoundException, IOException {
		// given
				int expectedNumberOfWinsOfTheFirstPlayer=0;
				//when
				PokerGame game = new PokerGame();
				handsReader = new HandsFileReader("testChecklist2.txt");
				int numberOfWinsOfTheFirstPlayer=game.getNumberOfWinsOfTheFirstHand(handsReader);
				//then
				assertEquals(expectedNumberOfWinsOfTheFirstPlayer, numberOfWinsOfTheFirstPlayer);
	}
	
	@Test
	public void shouldReturnOneForOneWin() throws FileNotFoundException, IOException {
		// given
				int expectedNumberOfWinsOfTheFirstPlayer=1;
				//when
				PokerGame game = new PokerGame();
				handsReader = new HandsFileReader("testChecklist3.txt");
				int numberOfWinsOfTheFirstPlayer=game.getNumberOfWinsOfTheFirstHand(handsReader);
				//then
				assertEquals(expectedNumberOfWinsOfTheFirstPlayer, numberOfWinsOfTheFirstPlayer);
	}

	@Test
	public void shouldReturnTenForTenWins1() throws FileNotFoundException, IOException {
		// given
				int expectedNumberOfWinsOfTheFirstPlayer=10;
				//when
				PokerGame game = new PokerGame();
				handsReader = new HandsFileReader("testChecklist.txt");
				int numberOfWinsOfTheFirstPlayer=game.getNumberOfWinsOfTheFirstHand(handsReader);
				//then
				assertEquals(expectedNumberOfWinsOfTheFirstPlayer, numberOfWinsOfTheFirstPlayer);
	}
	
	@Test
	public void shouldReturnTenForTenWins2() throws FileNotFoundException, IOException {
		// given
				int expectedNumberOfWinsOfTheFirstPlayer=10;
				//when
				PokerGame game = new PokerGame();
				handsReader = new HandsFileReader("testChecklist4.txt");
				int numberOfWinsOfTheFirstPlayer=game.getNumberOfWinsOfTheFirstHand(handsReader);
				//then
				assertEquals(expectedNumberOfWinsOfTheFirstPlayer, numberOfWinsOfTheFirstPlayer);
	}
	
	@Test
	public void shouldReturnTwentyOneForTwentyOneWins() throws FileNotFoundException, IOException {
		// given
				int expectedNumberOfWinsOfTheFirstPlayer=21;
				//when
				PokerGame game = new PokerGame();
				handsReader = new HandsFileReader("testChecklist5.txt");
				int numberOfWinsOfTheFirstPlayer=game.getNumberOfWinsOfTheFirstHand(handsReader);
				//then
				assertEquals(expectedNumberOfWinsOfTheFirstPlayer, numberOfWinsOfTheFirstPlayer);
	}
	
	@Test
	public void shouldReturn376ThirtyFourWins() throws FileNotFoundException, IOException {
		// given
				int expectedNumberOfWinsOfTheFirstPlayer=376;
				//when
				PokerGame game = new PokerGame();
				handsReader = new HandsFileReader("poker.txt");
				int numberOfWinsOfTheFirstPlayer=game.getNumberOfWinsOfTheFirstHand(handsReader);
				//then
				assertEquals(expectedNumberOfWinsOfTheFirstPlayer, numberOfWinsOfTheFirstPlayer);
	}

}