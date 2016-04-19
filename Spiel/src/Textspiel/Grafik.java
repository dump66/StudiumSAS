package Textspiel;

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Grafik extends Application {
	
	TextField inhaltZentrum = new TextField("Hier soll der Text hin");
	Button weiter = new Button("weiter");
	Button test2 = new Button("ok");
	int klickcounter = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		HBox hboxoben = new HBox();
		hboxoben.getChildren().add(weiter);
		hboxoben.getChildren().add(test2);
		
		EventHandler weiterEvent = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event1) {
				Scanner lese = new Scanner(System.in);
				
			String[] anfang = new String[15];
			anfang[0] = "Du bist in einem kleinen Dorf als Sohn eines Bauern aufgewachsen ... (weiter geht es mit Enter)";
			anfang[1] = "Dein Vater hat dich gebeten einen Brief an deinem Onkel in Jena zu überbringen.";
			anfang[2] = "Was im Brief steht und warum das nicht ein Boote machen kann, wollte dir der alte Herr nicht beantworten.";
			anfang[3] = "Aber eigentlich ist es dir auch egal warum du die lange Reise auf dich nehmen sollst ...";
			anfang[4] = "schließlich bedeutet das für eine Weile, keine Schweine ausmisten, keine Kuehe melken oder das Feld bestellen.";
			anfang[5] = "Darüber hinaus konntest du deinen alten Herren eh nicht leiden... ";
			anfang[6] = "da seine harsche und kühle Sklaventreibermentalität nicht wirklich zur Gesamtzufriedenheit beitrug.";
			anfang[7] = "Also stehst du am nächsten morgen früh auf und beginnst deine 40 tägige Reise nach Jena.";
			anfang[8] = "Als du die Türschwelle betritts ruft dir deine Mutter hinterher ... ";
			anfang[9] = "Willst du klamm heimlich verschwinden ohne deine Mutter zu verabschieden?";
			anfang[10] = "HIER EIN BISSEL WAS INTERAKTIVES + StringLine blockiert!!!!!!!!!!!!!!!!!!!";
			anfang[11] = "Ende: Mutter zeigt auf Rucksack ... Verpflegung für eine Woche, Karte und 15 Taler.";
			anfang[12] = "Du drueckst zum Abschied nochmal deine Mutter und sagst das du ja in 2 Monaten wieder da bist";
			anfang[13] = "Dann verlässt du das Haus und begibst dich Richtung Osten nach Jena.";
			anfang[14] = "Was möchtest du als nächstes tun?";
			
			inhaltZentrum.setText(anfang[klickcounter]);

			klickcounter++;
			}
		};
		
		weiter.setOnAction(weiterEvent);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(inhaltZentrum);
		pane.setTop(hboxoben);
		
		Scene scene = new Scene(pane, 700, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
