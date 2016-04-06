package studi.oop1.kapitel5;

import java.util.Random;

public class Wuerfeln {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextInt(6)+1);
	}

}
