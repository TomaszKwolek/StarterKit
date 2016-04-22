package PokerGame;
import java.util.HashMap;
import java.util.Map;

public final class PokerGameConstants {
	
	public static final Map <Character,Integer> RANK_VALUES_MAP = prepareRanksMap();
	public static final Map <Character,Integer> SUITS_VALUES_MAP = prepareSuitsMap();
	public static final Map <String,Integer> PATTERNS_VALUES_MAP = preparePatternsMap();
	public static final int MAX_CARD_IN_HAND = 5;
	public static final String NOTHING ="";
	public static final String HIGH_CARD ="11111";
	public static final String ONE_PAIR ="1112";
	public static final String TWO_PAIRS ="122";
	public static final String THREE_OF_A_KIND ="113";
	public static final String STRAIGHT ="straight";
	public static final String FLUSH ="flush";
	public static final String FULL ="23";
	public static final String FOUR_OF_A_KIND ="14";
	public static final String STRAIGHT_FLUSH ="straightFlush";
	public static final String ROYAL_FLUSH ="royalFlush";
	
	
	private static Map <Character,Integer> prepareRanksMap(){
		Map <Character,Integer> ranksMap = new HashMap<>();
		ranksMap.put('2', 1);
		ranksMap.put('3', 2);
		ranksMap.put('4', 3);
		ranksMap.put('5', 4);
		ranksMap.put('6', 5);
		ranksMap.put('7', 6);
		ranksMap.put('8', 7);
		ranksMap.put('9', 8);
		ranksMap.put('T', 9);
		ranksMap.put('J', 10);
		ranksMap.put('Q', 11);
		ranksMap.put('K', 12);
		ranksMap.put('A', 13);
		return ranksMap;
	}
	
	private static Map <String,Integer> preparePatternsMap() {
		Map <String,Integer> patternsValuesMap = new HashMap<>();
		patternsValuesMap.put(NOTHING, 0);
		patternsValuesMap.put(HIGH_CARD, 0);
		patternsValuesMap.put(ONE_PAIR, 1);
		patternsValuesMap.put(TWO_PAIRS, 2);
		patternsValuesMap.put(THREE_OF_A_KIND, 3);
		patternsValuesMap.put(STRAIGHT, 4);
		patternsValuesMap.put(FLUSH, 5);
		patternsValuesMap.put(FULL, 6);
		patternsValuesMap.put(FOUR_OF_A_KIND, 7);
		patternsValuesMap.put(STRAIGHT_FLUSH, 8);
		patternsValuesMap.put(ROYAL_FLUSH, 9);
		return patternsValuesMap;
	}
	
	private static Map<Character, Integer> prepareSuitsMap() {
		Map <Character,Integer> siutsValuesMap = new HashMap<>();
		siutsValuesMap.put('H', 0);
		siutsValuesMap.put('D', 0);
		siutsValuesMap.put('C', 0);
		siutsValuesMap.put('S', 0);
		return siutsValuesMap;
	}

}
