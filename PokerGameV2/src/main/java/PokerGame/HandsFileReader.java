package PokerGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HandsFileReader implements HandsReader {

	private final int SIZE_OF_LINE = 31;
	private int lineCounter = 1;
	private String gameFilePath = "";

	public HandsFileReader(String filePath) {
		gameFilePath = filePath;
	}

	@Override
	public String getLine() throws FileNotFoundException, IOException {

		FileReader reader = new FileReader(gameFilePath);
		BufferedReader input = new BufferedReader(reader);
		String line = "";

		input.skip((lineCounter - 1) * SIZE_OF_LINE);
		if ((line = input.readLine()) != null) {
			lineCounter++;

		}
		if (line == null) {
			line = "";
		}
		input.close();
		return line;
	}

}
