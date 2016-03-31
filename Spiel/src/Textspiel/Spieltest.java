package Textspiel;

import java.util.Scanner;

public class Spieltest {
	static Held held1;

	public static void main(String[] args) {
		
		System.out.println("==================================================================");
		System.out.println("| Spielstand Speichern (S) \t" + "| Neues Spiel (N)" + "\t \t |");
		System.out.println("| Spielstand Laden (L) \t\t" + "| Spielhilfe (H)" + "\t \t |");
		System.out.println("==================================================================");
		
		held1 = new Held("Stephan", 3, 3, 1);
		Abenteuer1 Abenteuer = new Abenteuer1();

		// held1.generieren();
		// held1.anzeigeHeld();

		// Abenteuer initialisieren
		Abenteuer.intro();
		Abenteuer.erstelleKarte();
		Abenteuer.reisen(held1);
	}

}
