package studi.oop1.kapitel8;

public class KfzVerwaltung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pkw auto1 = new Pkw("N-AS-1", 75, 5);
		Lkw lkw1 = new Lkw("N-AS-2", 300, 4000);
		
		auto1.print();
		System.out.println();
		lkw1.print();
	}

}
