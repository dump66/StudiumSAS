package studi.oop1.kapitel10;

public class Polstelle {

	public static void main(String[] args) {
		for (int i = -10; i < 11; i++){
			try {
			System.out.println(i + ": " + calculate(i));
			} catch (Exception e){
				System.out.println(i + ": " + e.getMessage());
			}
		}
	}

	private static double calculate(int x) throws Exception{
		double nenner = x*x*x-5*x*x-x+5;
		if (nenner != 0){
			double d = 1/nenner;
			return d;
		} else{
			throw new Exception("Polstelle");
		}
	}
}
