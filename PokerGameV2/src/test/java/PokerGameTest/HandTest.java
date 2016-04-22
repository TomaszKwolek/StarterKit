package PokerGameTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import PokerGame.Hand;
import PokerGame.InputCardException;
import PokerGame.InputHandConverter;
import PokerGame.NumberOfCardsException;
import PokerGame.PokerGame;
import PokerGame.HandImpl;
import PokerGame.HandsFileReader;
import PokerGame.HandsReader;

public class HandTest {

	@Test
	public void shouldReturnScoreZeroForHighCard() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 0;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(1, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreOneForOnePair() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 1;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(2, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreTwoForTwoPair() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 2;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(3, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreThreeForThreeOfAKind() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 3;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(4, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreFourForStraight() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 4;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(5, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreFiveForColour() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 5;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(6, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreSixForFull() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 6;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(7, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreSevenForFourOfaKind() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 7;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(8, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreEightForStraightFlush() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 8;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(9, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnScoreNineForRoyalFlush() throws FileNotFoundException, IOException {
		// given
		int expectedScore = 9;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(10, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test
	public void shouldReturnMinusOneForNotEnoughCards()
			throws FileNotFoundException, IOException, InputCardException, NumberOfCardsException {
		// given
		int expectedScore = -1;
		HandsReader fileReader = new HandsFileReader("testCheckList.txt");
		String line = getAllCardsForOneGame(11, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForHand = hand.getScoreForHand(cardsForFirstHand);
		// then
		assertEquals(expectedScore, scoreForHand);
	}

	@Test(expected = FileNotFoundException.class)
	public void shouldCatchExceptionForWrongFilePath() throws IOException {
		// given
		HandsReader fileReader = new HandsFileReader("testWrongFileName.txt");
		// when
		getAllCardsForOneGame(1, fileReader);
	}

	@Test
	public void shouldReturnScoreZeroForBothHandsForWrongRank() throws FileNotFoundException, IOException {
		// given
		int expectedScoreFirstHand = -1;
		int expectedScoreSecondHand = -1;
		HandsReader fileReader = new HandsFileReader("testChecklistWrongRank.txt");
		String line = getAllCardsForOneGame(1, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		List<String> cardsForSecondHand = InputHandConverter.cardsForSecondHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForFirstHand = hand.getScoreForHand(cardsForFirstHand);
		int scoreForSecondHand = hand.getScoreForHand(cardsForSecondHand);
		// then
		assertEquals(expectedScoreFirstHand, scoreForFirstHand);
		assertEquals(expectedScoreSecondHand, scoreForSecondHand);
	}

	@Test
	public void shouldReturnScoreZeroForBothHandsForWrongSuit() throws IOException {
		// given
		int expectedScoreFirstHand = -1;
		int expectedScoreSecondHand = -1;
		HandsReader fileReader = new HandsFileReader("testChecklistWrongSuit.txt");
		String line = getAllCardsForOneGame(1, fileReader);
		List<String> cardsForFirstHand = InputHandConverter.cardsForFirstHand(line);
		List<String> cardsForSecondHand = InputHandConverter.cardsForSecondHand(line);
		Hand hand = new HandImpl();
		// when
		int scoreForFirstHand = hand.getScoreForHand(cardsForFirstHand);
		int scoreForSecondHand = hand.getScoreForHand(cardsForSecondHand);
		// then
		assertEquals(expectedScoreFirstHand, scoreForFirstHand);
		assertEquals(expectedScoreSecondHand, scoreForSecondHand);
	}

	private String getAllCardsForOneGame(int numberOfGame, HandsReader handCardsReader) throws IOException {
		int gameToSkip = numberOfGame - 1;
		String line = "";
		for (int i = 0; i <= gameToSkip; i++) {
			line = handCardsReader.getLine();
		}
		return line;
	}

}