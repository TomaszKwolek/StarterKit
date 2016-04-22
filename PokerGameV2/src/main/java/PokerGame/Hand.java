package PokerGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Hand {
	

	/**
	 * @param filePath with cards
	 * @return Score for next hand in the file (high card->0, one pair->1, 
	 * 										   (two pairs->2, three of a kind->3, straight->4,
	 * 	     								   (flush->5, full house->6, four of a kind->7,  
	 * 		     							   (straight flush->8, royal flush->9)  
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getScoreForHand(List<String> handCards);
	
	/**
	 * @return ranks of the cards from the sorted map
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Integer> getCardsRanksFromSortedMap();
	
}
