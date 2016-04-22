package GameOfLife;

	public enum CellState{
		DEAD(0), ALIVE(1);
		
		private int stateOfTheCell;
		
		CellState(int state){
			stateOfTheCell = state;
		}
		
		public int getState() {
			return stateOfTheCell;
		}
	
}
