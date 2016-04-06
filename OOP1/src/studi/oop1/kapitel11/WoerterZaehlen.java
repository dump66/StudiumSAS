package studi.oop1.kapitel11;

import java.util.Scanner;

public class WoerterZaehlen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String input = "";
		while(true){
			String s = read.nextLine();
			if (s.equals("q")){
				break;
			} else {
				input = input + " " + s;
			}
		}
		System.out.println(input);
		input = input.trim();
		String[] s = input.split(" ");
		int count = 0;
		for (int i = 0; i<s.length; i++){
			if (!s[i].isEmpty()){
				count++;
			}
		}
		System.out.println("Anzahl: " + count);
	}

}
