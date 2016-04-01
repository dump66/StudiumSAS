package studi.oop1.kapitel4;
public class Boolean {
	public static void main(String[] args) {
		int m = 1, n = -1;
		boolean a = true, b = false;
		System.out.println(a && !b);					// true
		System.out.println(!a || b && a || !b);			// true
		System.out.println(!a || !b || m < n);			// true
		System.out.println(m > n || m == n && m > n);	// true
	}
}