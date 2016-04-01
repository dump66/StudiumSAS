package studi.oop1.kapitel4;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 432;
		int y = 432;
		int z = 463;

		if (x > y){
			if (x > z){
				if (y > z){
					System.out.println(x + " " + y + " " + z);
				} else {
					System.out.println(x + " " + z + " " + y);
				}
			} else {
				System.out.println(z + " " + x + " " + y);
			}
		} else if (x > z){
			System.out.println(y + " " + x + " " + z);
		} else if (y > z){
			System.out.println(y + " " + z + " " + x);
		} else {
			System.out.println(z + " " + y + " " + x);
		}
	}

}
