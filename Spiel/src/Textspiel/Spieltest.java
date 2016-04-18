package Textspiel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Spieltest extends Application {
	static Held held1;

	public static void main(String[] args) throws IOException {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		held1 = new Held("Stephan", 3, 3, 1);
		Abenteuer1 abenteuer = new Abenteuer1();
		
		System.out.println("Moechtest du einen alten Spielstand laden? (j/n)");
		System.out.print(">");
		Scanner lesein = new Scanner(System.in);
		String yain = lesein.next();
		System.out.println(yain);
		
		if (yain.equals("j"))
		{
			FileChooser fc = new FileChooser();
			File alterHeld = fc.showOpenDialog(primaryStage);
			BufferedReader bf = new BufferedReader(new FileReader(alterHeld));
			held1.setnameH(bf.readLine());
			held1.setGesundheit(Integer.parseInt(bf.readLine()));
			
			abenteuer.setZeile(Integer.parseInt(bf.readLine()));
			abenteuer.setSpalte(Integer.parseInt(bf.readLine()));
			bf.close();
		};


		// held1.generieren();
		// held1.anzeigeHeld();

		// Abenteuer initialisieren
		abenteuer.intro();
		abenteuer.erstelleKarte();
		abenteuer.reisen(held1);

	}

}
