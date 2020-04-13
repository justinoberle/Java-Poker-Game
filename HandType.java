package poker;

import java.util.List;

public class HandType {
	
	
	
	public static List<List<Integer>> highCards(List<List<Integer>> twoDList){
		// make 1's 14's
		GameLogic.onesToFourteens(twoDList);
		
		return twoDList;
		
	}
}
