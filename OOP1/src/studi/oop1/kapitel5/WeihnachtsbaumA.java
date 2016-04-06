package studi.oop1.kapitel5;

public class WeihnachtsbaumA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printKette('a', 3, 5);
	}

	static void printKette(char zeichen, int start, int laenge) {
		for (int i = 1; i < start; i++) {
			System.out.print(" ");
		}
		for (int i = 1; i <= laenge; i++) {
			System.out.print(zeichen);
		}
	}

}
