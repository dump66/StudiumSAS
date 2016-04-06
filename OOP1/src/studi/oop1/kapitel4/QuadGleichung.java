package studi.oop1.kapitel4;
public class QuadGleichung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 5;
		double sol;

		if (a == 0) {
			if (b == 0) {
				System.out.println("Es wird durch Null geteilt->Keine L�sung!");
			} else {
				sol = (double)-c / b;
				System.out.println("Eine L�sung: " + sol);
			}
		} else {
			double wurzel = b * b - 4 * a * c;
			if (wurzel < 0) {
				System.out.println("Es gibt keine L�sung!");
			} else {
				double root = Math.sqrt(wurzel);
				if (wurzel == 0) {
					sol = (double) -b / (2 * a);
					System.out.println("Eine L�sung: " + sol);
				} else {
					double x1 = (-b + root) / (2 * a);
					double x2 = (-b - root) / (2 * a);
					System.out.println("Zwei L�sungen: " + x1 + " und " + x2);
				}
			}
		}
	}

}
