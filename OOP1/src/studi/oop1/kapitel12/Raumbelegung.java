package studi.oop1.kapitel12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Raumbelegung {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("Raumbelegung.txt");
		Scanner reader = new Scanner(System.in);
		String roomList = new String();
		while (true) {
			System.out.println("New room? Press R button and return");
			System.out.println("Write file? Presse W button and return");

			String line = reader.next();
			if (line.equalsIgnoreCase("W")) {
				FileWriter fw = new FileWriter(file);
				fw.append(roomList);
				fw.flush();
				fw.close();
			} else if (line.equalsIgnoreCase("R")) {
				if (!roomList.isEmpty()) {
					roomList = roomList + System.lineSeparator();
				}
				System.out.println("Sector?");
				roomList = roomList + reader.next().charAt(0) + ",";
				System.out.println("Room number?");
				roomList = roomList + reader.nextInt() + ",";
				System.out.println("Description?");
				roomList = roomList + reader.next() + ",";
				System.out.println("Size");
				roomList = roomList + reader.nextInt();
			}
		}
	}
}
