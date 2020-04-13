package poker;

import java.util.ArrayList;
import java.util.List;

public class ConvertStrings {
	// converts each card into an array of numbers and/or suits
	public static List<List<Integer>> handNumbersTwoDList(List<List<String>> twoDList){
		// capture the x# only for each card and create a number list
		List<List<Integer>> numbers = new ArrayList<List<Integer>>();
		for(int i = 0; i < twoDList.size(); i++) {
			List<Integer> number = new ArrayList<Integer>();
			for(int j = 0; j < twoDList.get(i).size(); j++) {
				if (twoDList.get(i).get(j).substring(0, 2).equals("xJ")) {
					number.add(11);
				}
				else if (twoDList.get(i).get(j).substring(0, 2).equals("xQ")) {
					number.add(12);
				}
				else if (twoDList.get(i).get(j).substring(0, 2).equals("xK")) {
					number.add(13);
				}
				else if (twoDList.get(i).get(j).substring(0, 2).equals("xA")) {
					number.add(1);
				}
				else if (twoDList.get(i).get(j).substring(0, 2).equals("10")) {
					number.add(10);
				}
				else {
					number.add(Integer.parseInt(twoDList.get(i).get(j).substring(1, 2)));
				}
			}
			numbers.add(number);
		}
		return numbers;
	}
	
	public static List<Integer> handNumbersOneDList(List<String> oneDList){
		// capture the x# only for each card and create a number list
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < oneDList.size(); i++) {
			if (oneDList.get(i).substring(0, 2).equals("xJ")) {
				numbers.add(11);
			}
			else if (oneDList.get(i).substring(0, 2).equals("xQ")) {
				numbers.add(12);
			}
			else if (oneDList.get(i).substring(0, 2).equals("xK")) {
				numbers.add(13);
			}
			else if (oneDList.get(i).substring(0, 2).equals("xA")) {
				numbers.add(1);
			}
			else if (oneDList.get(i).substring(0, 2).equals("10")) {
				numbers.add(10);
			}
			else {
				numbers.add(Integer.parseInt(oneDList.get(i).substring(1, 2)));
			}
			
		}
		return numbers;
	}
	
	public static Integer handNumbersString(String string){
		// capture the x# only for each card and create a number list
		Integer number;
		if (string.substring(0, 2).equals("xJ")) {
			number = 11;
		}
		else if (string.substring(0, 2).equals("xQ")) {
			number = 12;
		}
		else if (string.substring(0, 2).equals("xK")) {
			number = 13;
		}
		else if (string.substring(0, 2).equals("xA")) {
			number = 1;
		}
		else if (string.substring(0, 2).equals("10")) {
			number = 10;
		}
		else {
			number = Integer.parseInt(string.substring(1, 2));
		}
		return number;
	}
	
	public static List<List<String>> handSuitsTwoDList(List<List<String>> twoDList){
		List<List<String>> suits = new ArrayList<List<String>>();
			for(int i = 0; i < twoDList.size(); i++) {
				List<String> suit = new ArrayList<String>();
				for(int j = 0; j < twoDList.get(i).size(); j++) {
					suit.add(twoDList.get(i).get(j).substring(2));
				}
				suits.add(suit);
			}
		return suits;
	}
	
	public static List<String> handSuitsOneDList(List<String> oneDList){
		List<String> suits = new ArrayList<String>();
		for(int i = 0; i < oneDList.size(); i++) {
			suits.add(oneDList.get(i).substring(2));
		}
		return suits;
	}
	
	public static String handSuitsString(String string){
		String suits;
		suits = string.substring(2);
		return suits;
	}
}
