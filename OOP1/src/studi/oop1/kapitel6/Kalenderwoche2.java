package studi.oop1.kapitel6;

public class Kalenderwoche2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int tag = 1;
		int monat = 1;
		int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
		int daysToDate = -1;

		if (monat <= 0 || monat > 12 || tag < 1 || tag > 31) {
			System.out.println("Sascha hat gemeckert, muss geprüft werden, blablabla! Immer diese Erbsenzähler!!");
		} else {
			for (int i = 0; i < monat-1; i++) {
				daysToDate += arr[i];
			}
			daysToDate += tag;
			int kw = daysToDate / 7;
			kw++;
			System.out.println(kw);
		}
	}

}
