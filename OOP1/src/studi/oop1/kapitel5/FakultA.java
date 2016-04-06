package studi.oop1.kapitel5;

public class FakultA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int zahl = 5;
		if (zahl < 0) {
			System.out.println("Bitte eine nicht negative Zahl verwenden");
		} else {
			double result = calc(zahl);
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
