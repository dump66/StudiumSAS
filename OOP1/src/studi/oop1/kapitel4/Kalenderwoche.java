package studi.oop1.kapitel4;
public class Kalenderwoche {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int tag = 32;
		int monat = 12;
		int daysToDate = -1;

		if (monat <= 0 || monat > 12 || tag < 1 || tag > 31) {
			System.out.println("Sascha hat gemeckert, muss geprüft werden, blablabla! Immer diese Erbsenzähler!!");
		} else {
			for (int i = 1; i < monat; i++) {
				if (i == 2) {
					daysToDate += 28;
				} else if (i == 4 || i == 6 || i == 9 || i == 11) {
					daysToDate += 30;
				} else {
					daysToDate += 31;
				}
			}
			daysToDate += tag;
			int kw = daysToDate / 7;
			kw++;
			System.out.println(kw);
		}
	}

}
