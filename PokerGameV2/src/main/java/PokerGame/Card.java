package PokerGame;

public class Card implements Comparable<Card> {

	private Integer valueOfRank;
	private Character suit;

	public Card(String card) {
		valueOfRank = PokerGameConstants.RANK_VALUES_MAP.get(card.charAt(0));
		suit = card.charAt(1);
	}

	/**
	 * @return Card figure value from the PokerGameConstants.COLORS_VALUES_MAP
	 */
	public Integer getValueOfRank() {
		return valueOfRank;
	}
	
	/**
	 * @return suit of the card
	 */
	public Character getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card o) {
		return valueOfRank - o.getValueOfRank();
	}
}
