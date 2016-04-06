package studi.oop1.kapitel7;

public class Kontofuehrung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long kontonummern = 1;
		
		Konto meier = new Konto("Herr Maier", kontonummern++);
		Konto mueller = new Konto("Frau Mueller", kontonummern++);
		
		meier.einzahlen(5500);
		mueller.einzahlen(5000);
		meier.auszahlen(1200);
		mueller.auszahlen(250.75f);
		meier.kontoauszug();
		mueller.kontoauszug();
	}

}
