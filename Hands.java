package poker;

import java.util.ArrayList;
import java.util.List;

public class Hands {
	
	// deals a 5 cards hand to every player
	public static List<List<String>> flopHands(List<List<String>> wholeCards){
		List<List<String>> flopHands = new ArrayList<List<String>>();
		for (int i = 0; i < wholeCards.size(); i++) {
			List<String> playerCards = new ArrayList<String>();
			playerCards.addAll(wholeCards.get(i));
			for (int j = 0; j < RunGameLoop.hand.getFlop().size(); j++) {
				playerCards.add(RunGameLoop.hand.getFlop().get(j));
			}

			flopHands.add(playerCards);
		}
		return flopHands;
	}
	
	// deals a 6 card hand to every player
	public static List<List<String>> turnHands(List<List<String>> flopHand){
		List<List<String>> turnHands = new ArrayList<List<String>>();
		for (int i = 0; i < Poker.numberPlayers; i++) {
			List<String> playerCards = new ArrayList<String>();
			playerCards.addAll(flopHand.get(i));
			playerCards.add(RunGameLoop.hand.getTurn());
			turnHands.add(playerCards);
		}
		return turnHands;
	}
	
	// deals a 7 card hand to every player
	public static List<List<String>> riverHands(List<List<String>> turnHand){
		List<List<String>> riverHands = new ArrayList<List<String>>();
		for (int i = 0; i < Poker.numberPlayers; i++) {
			List<String> playerCards = new ArrayList<String>();
			playerCards.addAll(turnHand.get(i));
			playerCards.add(RunGameLoop.hand.getRiver());
			riverHands.add(playerCards);
		}
		return riverHands;
	}
}
