package PokerGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PokerGame {

	private int numberOfWinsOfTheFirstHand = 0;
	private static final Logger log4j = LogManager.getLogger(InputHandConverter.class.getName());
	
	/**
	 * @param filePathName
	 * @return wins number of the first player
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public int getNumberOfWinsOfTheFirstHand(HandsReader handCards) {
		Hand loadedHand = new HandImpl();
		int scoreForFirstHand = 0;
		int scoreForSecondHand = 0;
		List<Integer> cardsRanksValuesFirstHand = null;
		List<Integer> cardsRanksValuesSecondHand = null;
		
		while (scoreForFirstHand != -1 && scoreForSecondHand != -1) {
		
			String line="";
			try {
				line = handCards.getLine();
			} catch (FileNotFoundException e) {
				log4j.warn("File cannot be found!", e);
			} catch (IOException e) {
				log4j.warn("File cannot be read!", e);
			}
			
			List<String> firstHandCards = InputHandConverter.cardsForFirstHand(line);	
			scoreForFirstHand = loadedHand.getScoreForHand(firstHandCards);
			cardsRanksValuesFirstHand = loadedHand.getCardsRanksFromSortedMap();

			List<String> secondHandCards = InputHandConverter.cardsForSecondHand(line);
			scoreForSecondHand = loadedHand.getScoreForHand(secondHandCards);
			cardsRanksValuesSecondHand = loadedHand.getCardsRanksFromSortedMap();
			if (wonFirstHand(scoreForFirstHand, scoreForSecondHand, cardsRanksValuesFirstHand, cardsRanksValuesSecondHand)) {
				numberOfWinsOfTheFirstHand++;
			}
		}
		return numberOfWinsOfTheFirstHand;
	}

	private boolean wonFirstHand(int scoreFirstHand, int scoreSecondHand, List<Integer> sortedRanksValuesFirstPlayer,
			List<Integer> sortedRanksValuesSecondPlayer) {

		boolean wonFirstHand = false;
		if (scoreFirstHand > scoreSecondHand) {
			wonFirstHand = true;
		}
		if (scoreFirstHand == scoreSecondHand) {
			wonFirstHand = arbitrateTie(sortedRanksValuesFirstPlayer, sortedRanksValuesSecondPlayer, wonFirstHand);
		}
		return wonFirstHand;
	}
	
	private boolean arbitrateTie(List<Integer> sortedRanksValuesFirstPlayer, List<Integer> sortedRanksValuesSecondPlayer,
			boolean wonFirstHand) {
		int numberOfRanks = sortedRanksValuesFirstPlayer.size();
		for (int i = numberOfRanks - 1; i >= 0; i--) {
			if (sortedRanksValuesFirstPlayer.get(i) > sortedRanksValuesSecondPlayer.get(i)) {
				wonFirstHand = true;
				i = 0;
			}
			if (sortedRanksValuesFirstPlayer.get(i) < sortedRanksValuesSecondPlayer.get(i)) {
				i = 0;
			}
		}
		return wonFirstHand;
	}

}
