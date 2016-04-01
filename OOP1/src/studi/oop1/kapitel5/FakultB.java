package studi.oop1.kapitel5;

public class FakultB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int zahl1 = 49;
		int zahl2 = 6;
		if (zahl1 < 0 || zahl2 < 0) {
			System.out.println("Bitte nicht negative Zahlen verwenden");
		} else {
			double result = calc(zahl1)/(calc(zahl1-zahl2)*calc(zahl2));
			System.out.println(result);
		}
	}

	static double calc(int zahl){
		double result = 1;
		for (int i = 1; i <= zahl; i++){
			result *= i;
		}
		return result;
	}
}
