package studi.oop1.kapitel5;

public class WeihnachtsbaumB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int hoehe = 10;
		for (int i = 1; i <= hoehe; i++){
			printKette('+', hoehe+1-i, i*2-1);
			
		}
	}
	
	static void printKette(char zeichen, int start, int laenge){
		for (int i = 1; i < start; i++){
			System.out.print(" ");
		}
		for (int i = 1; i <= laenge; i++){
			System.out.print(zeichen);
		}
		System.out.println();
	}

}
