package studi.oop1.kapitel4;
public class Wochentag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int day = 1;
		int month = 1;
		int year = 1980;
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
			System.out.println("Der Wochentag ist Dienstag");
			break;
		case 1:
			System.out.println("Der Wochentag ist Mittwoch");
			break;
		case 2:
			System.out.println("Der Wochentag ist Donnerstag");
			break;
		case 3:
			System.out.println("Der Wochentag ist Freitag");
			break;
		case 4:
			System.out.println("Der Wochentag ist Samstag");
			break;
		case 5:
			System.out.println("Der Wochentag ist Sonntag");
			break;
		case 6:
			System.out.println("Der Wochentag ist Montag");
			break;
		default:
			System.out.println("Fehler: Falsche Berechnung beim Wochentag");
			break;
		}
	}

}
