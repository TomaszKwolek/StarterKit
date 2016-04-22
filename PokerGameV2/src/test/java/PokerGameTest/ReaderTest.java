package PokerGameTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import PokerGame.HandsFileReader;
import PokerGame.HandsReader;
import PokerGame.InputHandConverter;

public class ReaderTest {

	@Test(expected = IOException.class)
	public void shouldCatchIOExceptionForWrongFilePathName() throws IOException {
		HandsReader cardsHandReader = new HandsFileReader("wrongFilePath.txt");
		cardsHandReader.getLine();
	}

	@Test
	public void shouldReturnCorrectListForFirstHandInGameNumberOne() throws IOException {
		// given
		List<String> expectedCards = new ArrayList<>();
		expectedCards.add("8C");
		expectedCards.add("TS");
		expectedCards.add("KC");
		expectedCards.add("9H");
		expectedCards.add("4S");
		HandsReader cardsHandReader = new HandsFileReader("poker.txt");
		//when
		String line=getAllCardsForOneGame(1,cardsHandReader);
		List<String> cardsFromFile=InputHandConverter.cardsForFirstHand(line);
		//then
		assertEquals(expectedCards, cardsFromFile);
	}

	@Test
	public void shouldReturnCorrectListForSecondtHandInGameNumberOne() throws IOException {
		// given
		List<String> expectedCards = new ArrayList<>();
		expectedCards.add("7D");
		expectedCards.add("2S");
		expectedCards.add("5D");
		expectedCards.add("3S");
		expectedCards.add("AC");
		HandsReader cardsHandReader = new HandsFileReader("poker.txt");
		//when
		String line=getAllCardsForOneGame(1,cardsHandReader);
		List<String> cardsFromFile=InputHandConverter.cardsForSecondHand(line);
		//then
		assertEquals(expectedCards, cardsFromFile);
	}

	@Test
	public void shouldReturnCorrectListForFirstHandInGameNumberTen() throws FileNotFoundException, IOException {
		// given
		List<String> expectedCards = new ArrayList<>();
		expectedCards.add("JC");
		expectedCards.add("6S");
		expectedCards.add("5H");
		expectedCards.add("2H");
		expectedCards.add("2D");
		HandsReader cardsHandReader = new HandsFileReader("poker.txt");
		//when
		String line=getAllCardsForOneGame(10,cardsHandReader);
		List<String> cardsFromFile=InputHandConverter.cardsForFirstHand(line);
		//then
		assertEquals(expectedCards, cardsFromFile);

	}

	@Test
	public void shouldReturnCorrectListForSecondtHandInGameNumberTen() throws FileNotFoundException, IOException {
		// given
		List<String> expectedCards = new ArrayList<>();
		expectedCards.add("KD");
		expectedCards.add("9D");
		expectedCards.add("7C");
		expectedCards.add("AS");
		expectedCards.add("JS");
		HandsReader cardsHandReader = new HandsFileReader("poker.txt");
		//when
		String line=getAllCardsForOneGame(10,cardsHandReader);
		List<String> cardsFromFile=InputHandConverter.cardsForSecondHand(line);
		//then
		assertEquals(expectedCards, cardsFromFile);
			
	}

	@Test
	public void shouldReturnCorrectListForFirstHandInGameNumberThausand() throws FileNotFoundException, IOException {
		// given
		List<String> expectedCards = new ArrayList<>();
		expectedCards.add("AS");
		expectedCards.add("KD");
		expectedCards.add("3D");
		expectedCards.add("JD");
		expectedCards.add("8H");
		HandsReader cardsHandReader = new HandsFileReader("poker.txt");
		//when
		String line=getAllCardsForOneGame(1000,cardsHandReader);
		List<String> cardsFromFile=InputHandConverter.cardsForFirstHand(line);
		//then
		assertEquals(expectedCards, cardsFromFile);
	}

	@Test
	public void shouldReturnCorrectListForSecondtHandInGameNumberThausand() throws FileNotFoundException, IOException {
		// given
		List<String> expectedCards = new ArrayList<>();
		expectedCards.add("7C");
		expectedCards.add("8C");
		expectedCards.add("5C");
		expectedCards.add("QD");
		expectedCards.add("6C");
		HandsReader cardsHandReader = new HandsFileReader("poker.txt");
		//when
		String line=getAllCardsForOneGame(1000,cardsHandReader);
		List<String> cardsFromFile=InputHandConverter.cardsForSecondHand(line);
		//then
		assertEquals(expectedCards, cardsFromFile);
	}
	
	private String getAllCardsForOneGame(int numberOfGame, HandsReader handCardsReader) throws IOException{
		int gameToSkip=numberOfGame-1;
		String line="";
		for(int i=0; i<=gameToSkip; i++){
			line = handCardsReader.getLine();
		}
		return line;
	}

}