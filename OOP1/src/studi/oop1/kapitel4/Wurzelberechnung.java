package studi.oop1.kapitel4;

public class Wurzelberechnung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = 3;
		double x = a;
		double xAlt = 0;
		long y = 0;
		long yAlt = 0;
		double sol;
		
		while (true){
			x = (x + a/x)/2;
			y = (long) (x*Math.pow(10, 10));
			yAlt = (long) (xAlt*Math.pow(10, 10));
			if (y == yAlt){
				long i = (long) (x * Math.pow(10, 11));
				i = (long) (i%10);
				sol = y / Math.pow(10, 10);
				if (i >= 5){
					double j = (double) 1 / Math.pow(10, 10);
					sol += j;
				}
				break;
			}
			xAlt = x;
		}
		
		System.out.println("Wurzel ist: " + sol);
	}

}
