package poker;

import java.util.List;

public class RunGameLoop {
	
	private List<List<String>> wholeCards;
	public List<List<String>> getWholeCards(){
		return wholeCards;
	}
	public void setWholeCards() {
		List<List<String>> newCards = NoLimitHoldEm.dealWholeCards();
		this.wholeCards = newCards;
	}
	
	private List<String> flop; 
	public List<String> getFlop(){
		return flop;
	}
	public void setFlop() {
		List<String> newCards = NoLimitHoldEm.dealFlop();
		this.flop = newCards;
	}
	
	private String turn;
	public String getTurn(){
		return turn;
	}
	public void setTurn() {
		String newCards = NoLimitHoldEm.dealTurn();
		this.turn = newCards;
	}
	
	private String river;
	public String getRiver(){
		return river;
	}
	public void setRiver() {
		String newCards = NoLimitHoldEm.dealRiver();
		this.river = newCards;
	}
	
	private List<List<String>> flopHands;
	public List<List<String>> getFlopHands(){
		return flopHands;
	}
	public void setFlopHands() {
		List<List<String>> newCards = Hands.flopHands(wholeCards);
		this.flopHands = newCards;
	}

	private List<List<String>> turnHands;
	public List<List<String>> getTurnHands(){
		return turnHands;
	}
	public void setTurnHands() {
		List<List<String>> newCards = Hands.turnHands(flopHands);
		this.turnHands = newCards;
	}
	
	private List<List<String>> riverHands;
	public List<List<String>> getRiverHands(){
		return riverHands;
	}
	public void setRiverHands() {
		List<List<String>> newCards = Hands.riverHands(turnHands);
		this.riverHands = newCards;
	}
	
	public static RunGameLoop hand = new RunGameLoop();
	public RunGameLoop getHand() {
		return hand;
	}
	public void reset() {
		RunGameLoop newHand = new RunGameLoop();
		hand = (newHand);
	}

	
	public static void runGame(int iterations) {
		for (int i = 0; i < iterations; i++) {
			hand.reset();
			Poker.setShuffledDeck();
			hand.setWholeCards();
			hand.setFlop();
			hand.setTurn();
			hand.setRiver();
//			System.out.println(hand.getWholeCards());
//			System.out.println(hand.getFlop() + ", " + hand.getTurn() + ", " + hand.getRiver());
			hand.setFlopHands();
//			System.out.println(hand.getFlopHands());
			hand.setTurnHands();
//			System.out.println(hand.getTurnHands());
			hand.setRiverHands();
			
//			System.out.println(hand.getRiverHands());
//			System.out.println();
		}


	}
}
