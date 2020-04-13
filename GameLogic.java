package poker;

import java.util.List;

public class GameLogic {
	
	// convert 1's to 14's
	public static List<List<Integer>> onesToFourteens(List<List<Integer>> twoDList){
		
		for (int i = 0; i < twoDList.size(); i++) {
			if (twoDList.get(i).contains(1)) {
				int index = twoDList.get(i).indexOf(1);
				twoDList.get(i).set(index, 14);
			}
		}
		return twoDList;
		
	}
	

}


