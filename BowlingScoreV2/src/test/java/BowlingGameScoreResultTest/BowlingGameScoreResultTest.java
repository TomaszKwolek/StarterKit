package BowlingGameScoreResultTest;

import static org.junit.Assert.*;
import org.junit.Test;

import BowlingScore.BowlingGameScoreResult;
import BowlingScore.Round;
import BowlingScore.WrongNumberOfPinsException;
import junit.framework.Assert;

public class BowlingGameScoreResultTest {

	BowlingGameScoreResult result = new BowlingGameScoreResult();

	@Test
	public void SholudReturnZeroForZeroThrows() {
		// given
		int[] pinsTable = { 0 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 0);
	}

	@Test
	public void sholudReturnCorrectResultForTwoSimpleThrows() {
		// given
		int[] pinsTable = { 5, 4 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 9);
	}

	@Test
	public void sholudReturnCorrectResultForFourSimpleThrows() {
		// given
		int[] pinsTable = { 5, 4, 7, 2 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 18);
	}

	@Test
	public void sholudReturnCorrectResultForTwoSimpleThrowsWithSpare() {
		// given
		int[] pinsTable = { 3, 7, 3, 2 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 18);
	}

	@Test
	public void shouldEighteenOnlyThreeRounds() {
		// given
		int[] pinsTable = { 9, 1, 2, 1, 3, 1 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 19);
	}

	@Test
	public void sholudReturnCorrectResultForTwoSimpleThrowsWithStrike() {
		// given
		int[] pinsTable = { 10, 3, 6 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 28);
	}

	@Test
	public void shouldReturnScoreTwentyAfterTwentyThrowsWithNumberOfPinsOne() {
		// given
		int[] pinsTable = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 20);
	}

	@Test
	public void shouldReturnScoreTenForResultOneInRound() {
		// given
		int[] pinsTable = { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 10);
	}

	@Test
	public void shouldReturnScoreThreeHundredAfterElevenStrikes() {
		// given
		int[] pinsTable = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 300);
	}

	@Test
	public void shouldReturnScoreHundredTwentySevenForStrikeInLastRound() {
		// given
		int[] pinsTable = { 3, 1, 4, 2, 5, 2, 4, 0, 10, 3, 7, 2, 1, 10, 10, 10, 5, 1 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 127);
	}

	@Test
	public void shouldReturnScoreOneHundredSixtyAfterTwentyTwoThrowsWithNumberOfPinsFive() {
		// given
		int[] pinsTable = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 150);
	}

	@Test
	public void shouldReturnScoreOneHundredTwentyAfterElevenRoundsWithNumberOfPinsOneAndNine() {
		// given
		int[] pinsTable = { 10, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 10 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 128);
	}

	@Test
	public void shouldReturnScoreOneHundredTenAfterElevenRoundsWithNumberOfPinsNineAndOne() {
		// given
		int[] pinsTable = { 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 110);
	}

	@Test
	public void shouldReturnScoreOneHundredTwentyAfterElevenRoundsWithNumberOfPinsNineAndOne() {
		// given
		int[] pinsTable = { 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 190);
	}

	@Test
	public void shouldReturnScoreOneHundredEightySevenForGameFromThePresentation() {
		// given
		int[] pinsTable = { 10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 187);
	}

	@Test
	public void shouldReturnScoreEightyFourdForNotFinishedGame() {
		// given
		int[] pinsTable = { 10, 9, 1, 5, 5, 0, 7, 2, 0, 9, 1, 10 };
		int gameScoreResult = 0;
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			gameScoreResult = result.score();
		}
		// then
		assertEquals(gameScoreResult, 84);
	}

	@Test
	public void shouldReturnFalseForOnlyOneThrow() {
		// given
		int[] pinsTable = { 3 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}
		// then
		assertFalse(result.isFinished());
	}

	@Test
	public void shouldReturnFalseAfterNineRounds() {
		// given
		int[] pinsTable = { 3, 1, 4, 2, 5, 2, 4, 0, 10, 3, 7, 2, 1 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}
		// then
		assertFalse(result.isFinished());
	}

	@Test
	public void shouldReturnFalseForNotFishedRoundTen() {
		// given
		int[] pinsTable = { 3, 1, 4, 2, 5, 2, 4, 0, 10, 3, 7, 2, 1, 10, 10, 1 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}
		// then
		assertFalse(result.isFinished());
	}

	@Test
	public void shouldReturnTrueAfterTenRoundsWithoutStrikeAndSpare() {
		// given
		int[] pinsTable = { 3, 1, 4, 2, 5, 2, 4, 0, 10, 3, 7, 2, 1, 10, 10, 1, 5 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}
		// then
		assertTrue(result.isFinished());
	}

	@Test
	public void shouldReturnFalseAfterTwoThrowsInRoundTenWithStrike() {
		// given
		int[] pinsTable = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 1 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}
		// then
		assertFalse(result.isFinished());
	}

	@Test
	public void shouldReturnTrueAfterThreeThrowsInRoundTenWithSpare() {
		// given
		int[] pinsTable = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 1, 6 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}

		// then
		assertTrue(result.isFinished());
	}

	@Test
	public void shouldReturnTrueAfterThreeThrowsInRoundTenWithStrike() {
		// given
		int[] pinsTable = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		// when
		for (int numberOfPins : pinsTable) {
			result.roll(numberOfPins);
			result.score();
		}
		// then
		assertTrue(result.isFinished());
	}

	@Test(expected = WrongNumberOfPinsException.class)
	public void shouldThrowExceptionAfterWrongArgument() {
		// given
		Round oneRound = new Round(1);
		//when
		oneRound.addCurrentNumberOfPins(11);
	}

	@Test(expected = WrongNumberOfPinsException.class)
	public void shouldThrowExceptionAfterWrongArg() {
		// given
		Round oneRound = new Round(1);
		//when
		oneRound.addCurrentNumberOfPins(-6);
	}

	@Test(expected = WrongNumberOfPinsException.class)
	public void shouldThrowExceptionAfterArgumentAboveTen() {
		// given
		Round oneRound = new Round(1);
		//when
		oneRound.addCurrentNumberOfPins(12);
	}

	@Test(expected = WrongNumberOfPinsException.class)
	public void shouldThrowExceptionAfterWrongPinsNumberInOneRound() {
		// given
		Round oneRound = new Round(1);
		oneRound.addCurrentNumberOfPins(7);
		oneRound.addCurrentNumberOfPins(4);
		// when
		oneRound.score();
	}
		
}
