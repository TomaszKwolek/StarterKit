package BowlingScore;


import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;

public class BowlingGameScoreResult implements BowlingGameResultCalculator {

	private final int NUMBER_OF_ROUNDS_IN_GAME = 10;
	private List<Round> allRoundsInGame = new ArrayList<Round>(NUMBER_OF_ROUNDS_IN_GAME);
	private static final Logger log4j = LogManager.getLogger(BowlingGameScoreResult.class.getName());

	public BowlingGameScoreResult() {
		addRoundsToGame();
	}

	@Override
	public void roll(int numberOfPins) {
		if (!isFinished()) {
			addNumberOfPinsToGame(numberOfPins);
		} else {
			log4j.info("Game over! To many Pins");
		}
		udpateThrowsForBonus();
	}

	@Override
	public int score() {
		int score = 0;
		try {
			for (Round round : allRoundsInGame) {
				score += round.score();
			}
		} catch (WrongNumberOfPinsException e) {
			score = 0;
			log4j.warn("Wrong number of pins in one Round!", e);
		}
		return score;
	}

	@Override
	public boolean isFinished() {
		return allRoundsInGame.get(NUMBER_OF_ROUNDS_IN_GAME - 1).isFinished();
	}

	private void addRoundsToGame() {
		for (int i = 0; i < NUMBER_OF_ROUNDS_IN_GAME - 1; i++) {
			allRoundsInGame.add(new Round(i - 1));
		}
		allRoundsInGame.add(new LastRound(0));
	}

	private void addNumberOfPinsToGame(int numberOfPins) {
		boolean currentThrowAdded = false;
		java.util.Iterator<Round> allRoundsIterator = allRoundsInGame.iterator();
		try {
			while (allRoundsIterator.hasNext() && !currentThrowAdded) {
				Round round = allRoundsIterator.next();
				currentThrowAdded = round.addCurrentNumberOfPins(numberOfPins);
			}
		} catch (WrongNumberOfPinsException e) {
			log4j.warn("Wrong number of pins!", e);
		}
	}

	private void udpateThrowsForBonus() {
		int FIRST_THROW_INDEX = 0;
		Round secondNextRound = null;

		for (int i = 0; i < NUMBER_OF_ROUNDS_IN_GAME - 1; i++) {
			int scoreOfFirstNextThrow = 0;
			int scoreOfSecondNextThrow = 0;
			Round firstNextRound = allRoundsInGame.get(i + 1);
			int numberOfThrowsInNextFirstRound = firstNextRound.throwsInRound.size();
			scoreOfFirstNextThrow = firstNextRound.getScoreForThrow(FIRST_THROW_INDEX);

			if (i < NUMBER_OF_ROUNDS_IN_GAME - 2) {
				secondNextRound = allRoundsInGame.get(i + 2);
			}
			if (numberOfThrowsInNextFirstRound > 1) {
				scoreOfSecondNextThrow = firstNextRound.getScoreForThrow(FIRST_THROW_INDEX + 1);
			}
			if (numberOfThrowsInNextFirstRound <= 1) {
				scoreOfSecondNextThrow = secondNextRound.getScoreForThrow(FIRST_THROW_INDEX);
			}

			allRoundsInGame.get(i).setScoreInFirstThrowInNextRound(scoreOfFirstNextThrow);
			allRoundsInGame.get(i).setScoreInSecondThrowInNextRound(scoreOfSecondNextThrow);
		}
	}

}
