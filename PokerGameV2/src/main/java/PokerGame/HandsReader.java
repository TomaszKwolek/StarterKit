package PokerGame;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HandsReader {
	

	/**
	 * @return String with all cards for two hand
	 * @throws IOException, FileNotFoundException, InputCardsException
	 */
	public String getLine() throws FileNotFoundException, IOException, InputCardException;
	
}
