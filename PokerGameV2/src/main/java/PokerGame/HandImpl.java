package PokerGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HandImpl implements Hand {

	private List<String> inputCards = new ArrayList<>();
	private List<Card> sortedCards = new ArrayList<>();
	private Map<Integer, Integer> sortedRanksValuesMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> ranksValuesMap = new HashMap<Integer, Integer>();

	private String handPattern = "";

	@Override
	public int getScoreForHand(List<String> handCards) {
		int score = -1;
		inputCards = handCards;

		if (inputCards.size() == PokerGameConstants.MAX_CARD_IN_HAND) {
			sortedCards = HandHelper.prepareSortedCardsList(inputCards);
			ranksValuesMap = HandHelper.prepareRanksValuesMap(sortedCards);
			sortedRanksValuesMap = HandHelper.sortByNumberOfRanksRepetitions(ranksValuesMap);
			handPattern = createHandPattern(sortedRanksValuesMap.values());

			score = PokerGameConstants.PATTERNS_VALUES_MAP.get(handPattern);
		}
		return score;
	}

	@Override
	public List<Integer> getCardsRanksFromSortedMap() {
		List<Integer> sortedCardsFromMap = new ArrayList<>();
		if (sortedRanksValuesMap != null) {
			List<Map.Entry<Integer, Integer>> entriesFirstHand = new LinkedList<Map.Entry<Integer, Integer>>(
					sortedRanksValuesMap.entrySet());
			for (Map.Entry<Integer, Integer> entry : entriesFirstHand) {
				sortedCardsFromMap.add(entry.getKey());
			}
		}
		return sortedCardsFromMap;
	}

	private boolean isStraight() {
		int valueOffHighestCard = sortedCards.get(PokerGameConstants.MAX_CARD_IN_HAND - 1).getValueOfRank();
		int valueOfLowestCard = sortedCards.get(0).getValueOfRank();
		int differenceBeetwenHighAndLowCard = valueOffHighestCard - valueOfLowestCard;
		int highCardPatternSize = 5;
		return ((sortedRanksValuesMap.size() == highCardPatternSize) && (differenceBeetwenHighAndLowCard == 4));
	}

	private boolean isFlush() {
		boolean isFlush = true;
		Character firstSuit = sortedCards.get(0).getSuit();
		for (Card card : sortedCards) {
			if (!card.getSuit().equals(firstSuit)) {
				isFlush = false;
			}
		}
		return isFlush;
	}

	private boolean isStrightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isRolyalFlush() {
		int ranksValueOfAce = PokerGameConstants.RANK_VALUES_MAP.get('A');
		return isStrightFlush()
				&& sortedCards.get(PokerGameConstants.MAX_CARD_IN_HAND - 1).getValueOfRank() == ranksValueOfAce;
	}

	private String createHandPattern(Collection<Integer> valuesFromCardsMap) {
		String pattern = "";
		if (valuesFromCardsMap.size() > 0) {
			for (Integer value : valuesFromCardsMap) {
				pattern = pattern + value;
			}
			if (isStraight()) {
				pattern = "straight";
			}
			if (isFlush()) {
				pattern = "flush";
			}
			if (isStrightFlush()) {
				pattern = "straightFlush";
			}
			if (isRolyalFlush()) {
				pattern = "royalFlush";
			}
		}
		return pattern;
	}

}
