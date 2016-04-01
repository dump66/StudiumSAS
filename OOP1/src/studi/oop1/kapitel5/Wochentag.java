package studi.oop1.kapitel5;

import java.util.Scanner;

public class Wochentag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dieses Programm zeigt dir den Wochentag zu einem gegebenen Datum an. Geben Sie zun‰chst den Tag ein:");
		int day = scanner.nextInt();
		System.out.println("Geben Sie nun den Monat ein:");
		int month = scanner.nextInt();
		System.out.println("Geben Sie abschlieﬂend das Jahr ein:");
		int year = scanner.nextInt();
		scanner.close();
		int weekday;

		long days = 0;

		// Jahre
		for (int i = 1980; i < year; i++) {
			if ((i % 4 == 0) && (i % 100 != 0) || i % 400 == 0) {
				days += 366;
			} else {
				days += 365;
			}
		}

		// Monate
		for (int i = 1; i < month; i++) {
			if (i == 2) {
				if ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0) {
					days += 29;
				} else {
					days += 28;
				}
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				days += 30;
			} else {
				days += 31;
			}
		}
		
		// Tage
		days += day-1;
		
		weekday = (int) (days%7);
		
		switch(weekday){
		case 0:
			System.out.println("Der gesuchte Wochentag ist ein Dienstag");
			break;
		case 1:
			System.out.println("Der gesuchte Wochentag ist ein Mittwoch");
			break;
		case 2:
			System.out.println("Der gesuchte Wochentag ist ein Donnerstag");
			break;
		case 3:
			System.out.println("Der gesuchte Wochentag ist ein Freitag");
			break;
		case 4:
			System.out.println("Der gesuchte Wochentag ist ein Samstag");
			break;
		case 5:
			System.out.println("Der gesuchte Wochentag ist ein Sonntag");
			break;
		case 6:
			System.out.println("Der gesuchte Wochentag ist ein Montag");
			break;
		default:
			System.out.println("Fehler: Falsche Berechnung beim Wochentag");
			break;
		}
	}

}
