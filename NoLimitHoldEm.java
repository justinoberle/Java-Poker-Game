package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class NoLimitHoldEm {

	public static List<String> shuffledDeck(){
		List<String> shuffledDeck = Poker.fullDeck();
		Collections.shuffle(shuffledDeck);	
		return shuffledDeck;	
	}
	
	public static List<List<String>> dealWholeCards(){
		
		List<String> firstCard = new ArrayList<String>();
		List<String> secondCard = new ArrayList<String>();
		List<List<String>> wholeCards = new ArrayList<List<String>>();
		
		for (int i = 0; i < Poker.numberPlayers; i++) {
			firstCard.add(Poker.shuffledDeck.get(i));
		}
		
		for (int i = Poker.numberPlayers; i < Poker.numberPlayers * 2; i++) {
			secondCard.add(Poker.shuffledDeck.get(i));
		}
		for (int i = 0; i < firstCard.size(); i++) {
			List<String> wholeCard = new ArrayList<String>();
			wholeCard.add(firstCard.get(i));
			wholeCard.add(secondCard.get(i));
			wholeCards.add(wholeCard);
		}
		remainingDeck(true, false, false, false);
		return wholeCards;
	}
	
	public static List<String> dealFlop(){
		List<String> flop = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			flop.add(Poker.shuffledDeck.get(i));
		}
		remainingDeck(false, true, false, false);
		return flop;
	}
	
	public static String dealTurn(){
		String turn;
		turn = Poker.shuffledDeck.get(0);
		remainingDeck(false, false, true, false);
		return turn;
	}
	public static String dealRiver(){
		String river;
		river = Poker.shuffledDeck.get(0);
		remainingDeck(false, false, false, true);
		return river;
	}
	
	public static List<String> dealAllCommunityCards() {
		List<String> comCards = new ArrayList<String>();
		comCards = dealFlop();
		comCards.add(dealTurn());
		comCards.add(dealRiver());
		return comCards;
	}
	
	public static void remainingDeck(boolean whole_cards, boolean flop, boolean turn, boolean river){
		if (whole_cards == true) {
			Poker.shuffledDeck.subList(0, Poker.numberPlayers*2).clear();
		}
		if (flop == true) {
			Poker.shuffledDeck.subList(0, 4).clear();
		}
		if (turn == true) {
			Poker.shuffledDeck.subList(0, 2).clear();
		}
		if (river == true) {
			Poker.shuffledDeck.subList(0, 2).clear();
		}
							
	}

}
