package BowlingScore;


public class LastRound extends Round{

	public LastRound(int nextRoundNumber) {
		super(nextRoundNumber);
	}

	private final int MAX_THROWS_IN_ROUND = 3;
	
	/**
	 * @return isFinished = true -> round is finished | isFinished = false -> round is not finished
	 */
	public boolean isFinished(){
		int scoreInTwoThrows=0;
		if(throwsInRound.size()>=MAX_THROWS_IN_ROUND-1){
			scoreInTwoThrows=addScoresOfTwoFirstRounds();
		}
		return (throwsInRound.size() == MAX_THROWS_IN_ROUND || (scoreInTwoThrows < MAX_SCORE_IN_ROUND 
				&& throwsInRound.size()==MAX_THROWS_IN_ROUND-1));
	}
	
	protected int scoreWithoutBonus() throws WrongNumberOfPinsException{
		int score = 0;
		if(isStrike()){
			score = throwsInRound.get(FIRST_THROW_INDEX);
		}
		if(!isStrike() && throwsInRound.size()>=MAX_THROWS_IN_ROUND-1){
			score = addScoresOfTwoFirstRounds();
		}
		if(score>10){
			throw new WrongNumberOfPinsException("Too many pins in two round!");
		}
		return score;
	}
	
	protected int addBonusForStrike(boolean isStrike) {
		int bonusForStrike = 0;
		if (isStrike && throwsInRound.size()==MAX_THROWS_IN_ROUND) {
			 bonusForStrike=throwsInRound.get(FIRST_THROW_INDEX+1)+throwsInRound.get(FIRST_THROW_INDEX+2);
		}
		return bonusForStrike;
	}
	
	protected int addBonusForSpare(boolean isSpare) {
		int bonusForSpare = 0;
		if (isSpare && throwsInRound.size()==MAX_THROWS_IN_ROUND) {
			bonusForSpare = throwsInRound.get(FIRST_THROW_INDEX+2);
		}
		return bonusForSpare;
	}
			
}
