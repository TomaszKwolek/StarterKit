package GameOfLife;

public class WrongCellsStateException extends RuntimeException {
	public WrongCellsStateException(String message) {
		super(message);
	}
}
