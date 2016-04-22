package PokerGame;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputHandConverter {

	private static final int NUMBER_OF_CARDS_IN_GAME = 10;
	private static int sizeOfLine = 0;
	private static final Logger log4j = LogManager.getLogger(InputHandConverter.class.getName());

	/**
	 * @param String
	 *            with all cards for two hands
	 * @return List of string for first hand
	 */
	public static List<String> cardsForFirstHand(String line) {
		List<String> cardsForHand = new ArrayList<String>();
		try {
			cardsForHand = cardsForTwoHands(line);
			cardsForHand = cardsForHand.subList(0, 5);
		} catch (InputCardException e) {
			log4j.warn("Unknow card!", e);
		} catch (NumberOfCardsException e) {
			log4j.warn("Wrong number of cards in game!", e);
		}
		return cardsForHand;
	}

	/**
	 * @param String
	 *            with all cards for two hands
	 * @return List of string for first hand
	 */
	public static List<String> cardsForSecondHand(String line) {
		List<String> cardsForHand = new ArrayList<String>();
		try {
			cardsForHand = cardsForTwoHands(line);
			cardsForHand = cardsForHand.subList(5, 10);
		} catch (InputCardException e) {
			log4j.warn("Unknow card!", e);
		} catch (NumberOfCardsException e) {
			log4j.warn("Wrong number of cards in game!", e);
		}
		return cardsForHand;
	}

	private static List<String> cardsForTwoHands(String line) throws InputCardException, NumberOfCardsException {
		Character cardChar = null;
		List<String> cardsForTwoHands = new ArrayList<String>();
		String card = "";
		sizeOfLine = line.length();
		for (int i = 0; i < sizeOfLine; i++) {
			cardChar = line.charAt(i);
			if (!Character.isWhitespace(cardChar) && isCharCorrect(cardChar)) {
				card = card + cardChar;
			}
			if (card.length() == 2 || i == sizeOfLine) {
				cardsForTwoHands.add(card);
				card = "";
			}
		}
		if (!isNumberOfCardsCorrect(cardsForTwoHands)) {
			cardsForTwoHands.clear();
			cardsForTwoHands.add("");
		}
		return cardsForTwoHands;
	}

	private static boolean isNumberOfCardsCorrect(List<String> cardsForTwoHands) throws NumberOfCardsException {
		boolean numberOfCardsCorrect = true;
		if (cardsForTwoHands.size() != NUMBER_OF_CARDS_IN_GAME) {
			numberOfCardsCorrect = false;
			throw new NumberOfCardsException("Wrong number of Cards");
		}
		return numberOfCardsCorrect;
	}

	private static boolean isCharCorrect(Character cardChar) throws InputCardException {
		boolean isCharCorrect = true;
		if (PokerGameConstants.RANK_VALUES_MAP.get(cardChar) == null
				&& PokerGameConstants.SUITS_VALUES_MAP.get(cardChar) == null) {
			isCharCorrect = false;
			throw new InputCardException("Wrong rank or suit!");
		}
		return isCharCorrect;
	}

}
