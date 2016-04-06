package studi.oop1.kapitel5;

import java.util.Scanner;

public class ZaehleHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Wie viele Scheiben?");
		int disks = read.nextInt();
		read.close();
		if (disks < 0) {
			System.out.println("Geben Sie eine nicht negative Zahl ein!");
		} else {
			System.out.println(count(disks));
		}
	}

	static long count(int disks) {
		if (disks == 0) {
			return 0;
		}
		if (disks == 1) {
			return 1;
		}
		return 1+2*count(disks-1);
	}

}
