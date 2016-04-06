package studi.oop1.kapitel11;

import java.util.ArrayList;

public class Lotto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(6);
		for (int i = 0; i<6; i++){
			numbers.add(getNewNumber(numbers));
		}
		System.out.println(numbers.toString());
	}
	
	public static int getNewNumber(ArrayList<Integer> numbers){
		int number = (int) Math.floor(Math.random()*49+1);
		if (numbers.contains(number)){
			return getNewNumber(numbers);
		} else {
			return number;
		}
	}

}
