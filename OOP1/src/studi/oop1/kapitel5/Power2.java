package studi.oop1.kapitel5;

import java.util.Scanner;

public class Power2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Basis: ");
		int basis = read.nextInt();
		System.out.println("Exponent: ");
		int exponent = read.nextInt();
		read.close();
		System.out.println(power(basis, exponent));
	}
	
	static long power(int basis, int exponent){
		if (exponent == 0){
			return 1;
		}
		return basis * power(basis, exponent-1);
	}

}
