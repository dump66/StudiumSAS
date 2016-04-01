package studi.oop1.kapitel7;

import java.util.Scanner;

public class Ampelschaltung {

	public static void main(String[] args){
		Ampel ampel = new Ampel();
		Scanner scanner = new Scanner(System.in);
		System.out.println(ampel.getFarbe());
		while(true){
			scanner.nextLine();
			ampel.schalte();
			System.out.println(ampel.getFarbe());
		}
	}
}
