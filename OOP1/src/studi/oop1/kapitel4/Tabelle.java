package studi.oop1.kapitel4;
public class Tabelle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 10; i <= 20; i++) {
			System.out.println(i + ":");
			System.out.println("---");
			for (int j = 1; j <= 10; j++) {
				System.out.println(j + " x " + i + " = " + (j * i));
			}
			System.out.println("=============\n");
		}
	}

}
