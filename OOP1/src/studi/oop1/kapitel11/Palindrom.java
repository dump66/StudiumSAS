package studi.oop1.kapitel11;

import java.util.Scanner;

public class Palindrom {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String line = reader.nextLine();
		line.trim();
		line.toLowerCase();
		line.replaceAll(" ", "");
		System.out.println(isPalindrom(line, 0, 2));
	}

	public static boolean isPalindrom(String line, int start, int end) {

		StringBuffer firstPart = new StringBuffer(line.substring(start, end));
		StringBuffer lastPart = firstPart.reverse();
		int wordLength = end - start;
		int length = line.lastIndexOf(lastPart.toString()) + wordLength - 1
				- start;
		int cancelLength = length / 2;
		if (line.lastIndexOf(lastPart.toString()) != -1) {
			if (cancelLength == firstPart.length()) {
				return true;
			} else {
				return isPalindrom(line, start, end + 1);
			}
		} else {
			if (cancelLength == firstPart.length() || end == line.length()) {
				return false;
			}
			return isPalindrom(line, start + 1, start + 2);
		}
	}
}
