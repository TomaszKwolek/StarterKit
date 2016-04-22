package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HandHelper {
	
	public static List<Card> prepareSortedCardsList(List<String> unsortedCards) {
		List<Card> sortedCards = new ArrayList<>();
		if (unsortedCards.size() == PokerGameConstants.MAX_CARD_IN_HAND) {
			for (String card : unsortedCards) {
				sortedCards.add(new Card(card));
			}
			Collections.sort(sortedCards);
		}
		return sortedCards;
	}

	public static Map<Integer, Integer> prepareRanksValuesMap(List<Card> cards) {
		Map<Integer, Integer> mapWithCount = new HashMap<>();
		Integer valueOfRank = null;
		Integer rankCount = null;
		for (Card card : cards) {
			valueOfRank = card.getValueOfRank();
			rankCount = mapWithCount.get(valueOfRank);
			if (rankCount != null) {
				mapWithCount.put(valueOfRank, ++rankCount);
			}
			if (rankCount == null) {
				mapWithCount.put(valueOfRank, 1);
			}
		}
		return mapWithCount;
	}

	public static Map<Integer, Integer> sortByNumberOfRanksRepetitions(Map<Integer, Integer> unsortedMap) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortedMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
