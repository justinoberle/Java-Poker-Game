package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Poker {

	public static List<String> deck = Arrays.asList("xA", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9", "10", "xJ", "xQ", "xK");
//	public static List<String> deckSuits = Arrays.asList("Club", "Spade", "Heart");
	public static List<String> deckSuits = Arrays.asList("Spade", "Heart", "Club", "Diamond");
	public static int numberPlayers = 10;
	public static List<String> shuffledDeck;
	
	public static List<String> getShuffledDeck() {
		return shuffledDeck;
	}
	public static void setShuffledDeck() {
		shuffledDeck = NoLimitHoldEm.shuffledDeck();
	}
	// Create full deck from the two variables
	public static List<String> fullDeck() {
		List<String> fullDeck = new ArrayList<String>();
		for(int i = 0; i < deck.size(); i++) {
			String temp = deck.get(i);
			for(int j = 0; j < deckSuits.size(); j++) {
				fullDeck.add(temp + deckSuits.get(j));
			}
		}
		return fullDeck;
	}	
	
	//--------------------------------------------------------MAIN----------------------------------------------------------
	//--------------------------------------------------------MAIN----------------------------------------------------------
	
	public static void main(String[] args) {
		
//		System.out.println(ConvertStrings.handNumbersTwoDList(wholeCards));
//		System.out.println(ConvertStrings.handNumbersOneDList(flop) + ", " + ConvertStrings.handNumbersString(turn) + ", " + ConvertStrings.handNumbersString(river));
//		System.out.println(ConvertStrings.handSuitsTwoDList(wholeCards));
//		System.out.println(ConvertStrings.handSuitsOneDList(flop) + ", " + ConvertStrings.handSuitsString(turn) + ", " + ConvertStrings.handSuitsString(river));
//		System.out.println(flopHands);
//		System.out.println(turnHands);
//		System.out.println(riverHands);
//		System.out.println(wholeCards);
		
		BufferedImageDisplay.shuffleDealImage();
		

	}


}
