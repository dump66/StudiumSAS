package studi.oop1.kapitel7;

public class RaumBelegung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Raum raum1 = new Raum();
		raum1.reservieren();
		raum1.reservieren();
		raum1.reservieren();
		raum1.reservieren();
		raum1.stornieren();
		
		raum1.zeigeBelegung();
	}
}

