package studi.oop1.kapitel6;

import java.util.Scanner;

public class Temperatur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Geben Sie nacheinander die 7 Temperaturen ein:"); 
		int[] temps = {read.nextInt(), read.nextInt(), read.nextInt(), read.nextInt(), read.nextInt(), read.nextInt(), read.nextInt()};
		read.close();
		double durchschnitt = 0;
		int max = 0;
		for (int i = 0; i < temps.length; i++){
			durchschnitt += temps[i];
			if (temps[i]>max){
				max = temps[i];
			}
		}
		System.out.println("Mittlere Temperatur ist: " + (durchschnitt/7) + "°C! Die höchste Temperatur beträgt: " + max + "°C!");
	}

}
