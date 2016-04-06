package studi.oop1.kapitel4;

/**
 * @author Andreas.Schultze
 *
 */
public class Schaltjahr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int year = 2000;
		
		if ((year%4 == 0) && (year%100 != 0) || year%400 == 0){
			System.out.println("Das Jahr " + year + " ist ein Schaltjahr!");
		} else{
			System.out.println("Das Jahr " + year + " ist kein Schaltjahr!");
		}
	}

}
