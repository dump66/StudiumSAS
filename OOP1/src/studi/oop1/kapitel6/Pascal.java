package studi.oop1.kapitel6;

import java.util.Scanner;

public class Pascal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Geben Sie die Tiefe des pascalschen Dreiecks ein:");
		int tiefe = read.nextInt();
		read.close();
		int[] topRow = new int[tiefe - 1];
		int[] botRow = new int[tiefe];
		System.out.println(1 + " ");
		// Zeilen
		for (int i = 2; i <= tiefe; i++) {
			// Spalten
			for (int j = 0; j < i; j++) {
				if (j == 0) {
					botRow[0] = 1;
					System.out.print(1 + " ");
				} else if (j == i - 1) {
					botRow[j] = 1;
					System.out.println(1);
				} else {
					botRow[j] = topRow[j - 1] + topRow[j];
					System.out.print(botRow[j] + " ");
				}
			}
			if (i != tiefe) {
				topRow = botRow.clone();
			}
		}
	}

}
