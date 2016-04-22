package BowlingScore;


import java.util.ArrayList;
import java.util.List;

public class Round {
	
	protected final int MAX_SCORE_IN_ROUND = 10;
	protected final int FIRST_THROW_INDEX = 0;
	protected List<Integer> throwsInRound = new ArrayList<Integer>();
	private final int MAX_THROWS_IN_ROUND = 2;
	private int nextRoundNumber = 0;
	private int scoreInFirstThrowInNextRound=0;
	private int scoreInSecondThrowInNextRound=0;
	
	public Round(int nextRoundNumber){
		this.nextRoundNumber=nextRoundNumber;
	}
	
	/**
	 * @return score of the round
	 */
	public int score() throws WrongNumberOfPinsException{
		return scoreWithoutBonus() + addBonusForSpare(isSpare()) + addBonusForStrike(isStrike());
	}
	
	/**
	 * @return isFinished = true -> round is finished | isFinished = false -> round is not finished
	 */
	public boolean isFinished() {
		return (throwsInRound.size() == MAX_THROWS_IN_ROUND || scoreWithoutBonus() == MAX_SCORE_IN_ROUND);
	}
	
	/**
	 * @param add current pins number to throwsInRound in round
	 * @return	  TRUE -> number of pins been added to this round
	 *			  FALSE -> number of pins not been added to this round
	 */
	public boolean addCurrentNumberOfPins(int numberOfPins) throws WrongNumberOfPinsException{
		boolean numberOfPinsAdded = false;
		if(numberOfPins<0 ||numberOfPins>10){
			throw new WrongNumberOfPinsException("Wrong pins number!");
		}
		else if (!isFinished()) {
			throwsInRound.add(numberOfPins);
			numberOfPinsAdded = true;
		}
		return numberOfPinsAdded;
	}
		
	/**
	 * @return next round number
	 */
	public int getNextRoundNumber(){
		return nextRoundNumber;
	}
	
	/**
	 * @param score of first throw in next round
	 */
	public void setScoreInFirstThrowInNextRound(int score){
		scoreInFirstThrowInNextRound=score;
	}
	
	/**
	 * @param score of second throw in next round or first throw in next round + 1 
	 * 			when in next round was strike 
	 */
	public void setScoreInSecondThrowInNextRound(int score){
		scoreInSecondThrowInNextRound=score;
	}
	
	/**
	 * @param number of throw in round
	 * @return score for throw 
	 */
	public int getScoreForThrow(int throwNumber) {
		int score = 0;
		if (throwsInRound.size() >= throwNumber + 1) {
			score = throwsInRound.get(throwNumber);
		}
		return score;
	}
	
	protected int scoreWithoutBonus() throws WrongNumberOfPinsException{
		int score = 0;
		for (Integer currentThrow : throwsInRound) {
			score += currentThrow;
		}
		if(score>10){
			throw new WrongNumberOfPinsException("Too many pins in two round!");
		}
		return score;
	}
	
	
	protected int addScoresOfTwoFirstRounds() {
		return getScoreForThrow(FIRST_THROW_INDEX)+getScoreForThrow(FIRST_THROW_INDEX+1);
	}

	protected boolean isStrike() {
		boolean isStrike = false;
		if (throwsInRound.size() >= 1 && throwsInRound.get(FIRST_THROW_INDEX) == MAX_SCORE_IN_ROUND) {
			isStrike = true;
		}
		return isStrike;
	}

	protected boolean isSpare() {
		int scoreInCurrentRound = 0;
		boolean isSpare = false;
		if (throwsInRound.size()>= MAX_THROWS_IN_ROUND) {
			scoreInCurrentRound = addScoresOfTwoFirstRounds();
		}
		if (scoreInCurrentRound == MAX_SCORE_IN_ROUND) {
			isSpare = true;
		}
		return isSpare;
	}
	
	protected int addBonusForStrike(boolean isStrike) {
		int bonusForStrike = 0;
		if (isStrike) {
			bonusForStrike = scoreInFirstThrowInNextRound + scoreInSecondThrowInNextRound;
		}
		return bonusForStrike;
	}

	protected int addBonusForSpare(boolean isSpare) {
		int bonusForSpare = 0;
		if (isSpare) {
			bonusForSpare = scoreInFirstThrowInNextRound;
		}
		return bonusForSpare;
	}

}
