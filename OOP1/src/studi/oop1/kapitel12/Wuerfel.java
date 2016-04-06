package studi.oop1.kapitel12;

import java.util.Scanner;

public class Wuerfel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		while(true){
			read.nextLine();
			System.out.println(rollTheDice());
		}
	}
	
	public static int rollTheDice(){
		return (int) Math.floor(Math.random()*6+1);
	}

}
