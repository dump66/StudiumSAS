package Textspiel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Abenteuer1 {
	
	private int laengeKarte = 10; // Länge Karte
	private int breiteKarte = 60; // Breite Karte
	private String[][] karte; // Felder der Karte
	private int tageszähler = 0;
	//private int maxproviant = 3;
	//private int maxWasser = 5;

	// Spielfeldpositionskoordinaten des Helden (auch Startposition)
	private int zeile = 7;
	private int spalte = 4;

	// Scanner initialisieren
	Scanner lese = new Scanner(System.in);

	// Missionstext für das Abenteuer
	public void intro() throws IOException {
		
		FileReader fr = new FileReader(new File(".\\Intro"));
		int c = 0;
		String s = "";
		while ((c=fr.read())!=-1){
			s = s + (String.valueOf((char) c));
		}
		String[] anfang = s.split("\\r\\n");
		//String[] anfang = new String[15];
//		anfang[0] = "Du bist in einem kleinen Dorf als Sohn eines Bauern aufgewachsen ... (weiter geht es mit Enter)";
//		anfang[1] = "Dein Vater hat dich gebeten einen Brief an deinem Onkel in Jena zu überbringen.";
//		anfang[2] = "Was im Brief steht und warum das nicht ein Boote machen kann, wollte dir der alte Herr nicht beantworten.";
//		anfang[3] = "Aber eigentlich ist es dir auch egal warum du die lange Reise auf dich nehmen sollst ...";
//		anfang[4] = "schließlich bedeutet das für eine Weile, keine Schweine ausmisten, keine Kuehe melken oder das Feld bestellen.";
//		anfang[5] = "Darüber hinaus konntest du deinen alten Herren eh nicht leiden... ";
//		anfang[6] = "da seine harsche und kühle Sklaventreibermentalität nicht wirklich zur Gesamtzufriedenheit beitrug.";
//		anfang[7] = "Also stehst du am nächsten morgen früh auf und beginnst deine 40 tägige Reise nach Jena.";
//		anfang[8] = "Als du die Türschwelle betritts ruft dir deine Mutter hinterher ... ";
//		anfang[9] = "Willst du klamm heimlich verschwinden ohne deine Mutter zu verabschieden?";
//		anfang[10] = "HIER EIN BISSEL WAS INTERAKTIVES + StringLine blockiert!!!!!!!!!!!!!!!!!!!";
//		anfang[11] = "Ende: Mutter zeigt auf Rucksack ... Verpflegung für eine Woche, Karte und 15 Taler.";
//		anfang[12] = "Du drueckst zum Abschied nochmal deine Mutter und sagst das du ja in 2 Monaten wieder da bist";
//		anfang[13] = "Dann verlässt du das Haus und begibst dich Richtung Osten nach Jena.";
//		anfang[14] = "Was möchtest du als nächstes tun?";
		
		for (int i = 0;i<anfang.length;i++)
		{
		System.out.print(anfang[i]);
		//String weiter = lese.nextLine();
		}
	}

	// Missionskarte mit wichtigen Objekten (Städte, Start, usw.) erstellen
	public void erstelleKarte() {
		String[][] karte = new String[laengeKarte][breiteKarte];

		for (int i = 0; i < laengeKarte; i++) {
			for (int j = 0; j < breiteKarte; j++) {
				karte[i][j] = "*";
			}
		}

		// Stadt und Symbol für Start auf Karte positionieren
		karte[this.zeile][this.spalte] = "0";
		karte[3][45] = "J";

		this.karte = karte;
		
	}
	
	// Methoden um Held auf Karte zu positionieren
	public void setZeile(int zeile)
	{
		this.zeile = zeile;
	}
	public void setSpalte(int spalte)
	{
		this.spalte = spalte;
	}

	// Karte während des Abenteuers ausdrucken lassen
	public void anzeigeKarte() {
		System.out.println("Karte - Dorf nach Jena");
		System.out.println("___________________________________________________________________________");
		System.out.println("");
		for (int x = 0; x < laengeKarte; x++) {
			for (int y = 0; y < breiteKarte; y++) {
				System.out.print(karte[x][y]);
			}
			System.out.println("");
		}
		System.out.println("___________________________________________________________________________");
		System.out.println("J = Jena \t  0 = aktueller Standort \t  . = bereits besuchter Ort");
	}

	// Durch die Karte bewegen
	public void bewegen() {
		System.out.println("");
		System.out.println("In welche Richtung möchtest du dich bewegen?");
		System.out.println("Norden(w) Sueden(s) Osten(d) Westen(a)");
		System.out.println(">");

		String richtung = lese.next();

		switch (richtung) {
		case "w":
			if (this.zeile == 0)
			{
				System.out.println("Du kannst nicht weiter in den Norden reisen.");
				System.out.println("Du kommst sonst zuweit vom Weg ab. Bitte waehle eine andere Richtung.");
				bewegen();
			}
			else
			{
				karte[this.zeile][this.spalte] = ".";
				this.zeile = this.zeile - 1;
				karte[this.zeile][this.spalte] = "0";
				
			}
			break;

		case "s":
			if (this.zeile == (laengeKarte-1))
			{
				System.out.println("Du kannst nicht weiter in den Sueden reisen.");
				System.out.println("Du kommst sonst zuweit vom Weg ab. Bitte waehle eine andere Richtung.");
				bewegen();
			}
			else
			{
				System.out.println("this Zeile:" + this.zeile);
				karte[this.zeile][this.spalte] = ".";
				this.zeile = this.zeile + 1;
				karte[this.zeile][this.spalte] = "0";
				
			}
			break;
		case "d":
			if (this.spalte == (breiteKarte -1))
			{
			System.out.println("Du kannst nicht weiter in den Osten reisen.");
			System.out.println("Du kommst sonst zuweit vom Weg ab. Bitte waehle eine andere Richtung.");
			bewegen();
			}
			else
			{
			karte[this.zeile][this.spalte] = ".";
			this.spalte = this.spalte + 1;
			karte[this.zeile][this.spalte] = "0";
			}

			break;
		case "a":
			if (this.spalte == 0)
			{
			System.out.println("Du kannst nicht weiter in den Westen reisen.");
			System.out.println("Du kommst sonst zuweit vom Weg ab. Bitte waehle eine andere Richtung.");
			bewegen();
			}
			else
			{
				karte[this.zeile][this.spalte] = ".";
				this.spalte = this.spalte - 1;
				karte[this.zeile][this.spalte] = "0";
			}

			break;
		default:
			System.out.println("Sie haben eine falsche Richtung gewaehlt, probieren Sie es nochmal.");
			break;
		}
	}

	// Abenteuer reisebewegungen
	public void reisen(Held held) {
		passiertNichts(held);
		do {
			// Tageszähler
			tageszähler++;

			// Wertanpassungen pro Tag
			// Wasserverwaltung
			held.setwasser(held.getwasser() - 1);
			if (held.getwasser() < 1) {
				held.setGesundheit(held.getGesundheit() - 20);
				System.out.println("Du hast seit Tagen nichts mehr getrunken und verlierst 20 Lebenpunkte.");
			}
			if (held.getGesundheit() < 1) {
				System.out.println("Dein Held ist verdurstet.");
				System.exit(0);
			}

			// Nahrungsverwaltung
			if (tageszähler % 3 == 0) {
				held.setproviant(held.getproviant() - 1);
				if (held.getproviant() < 1) {
					held.setGesundheit(held.getGesundheit() - 15);
					System.out.println("Du hast seit Tagen nichts mehr gegessen und verlierst 15 Lebenpunkte.");
				}
				if (held.getGesundheit() < 1) {
					System.out.println("Dein Held ist verhungert.");
					System.exit(0);
				}
			}

			// Verwaltung zufälliger Tagesablauf
			// Achtung !!! Zufallszahl ist 6 anstatt zufallszahl
			int zufallszahl = (int) (Math.random() * 6) + 1;
			switch (6) { // ACHTUNG!!!
			case 1:
				// Wasser finden + später Heilkräuter
				System.out.println("Du findest eine Quelle und kannst dein Wasservorrat auffüllen.");
				held.setwasser(7);
				passiertNichts(held);
				break;
			case 2:
				// Angriff von Gegner
				System.out.println("Du wirst angegriffen ...");
				Gegner gegner = new Gegner(zufallszahl, zufallszahl);
				gegner.generierenGegner();
				gegner.anzeigeGegner();
				held.anzeigeHeldkampf();
				do {
					gegner.angriffG(held);
					held.angriffHeld(gegner);
				} while (gegner.getgesundheitG() > 0 && held.getGesundheit() > 0);
				gegner.ausbeute(held);
				passiertNichts(held);
				break;
			case 3:
				// Gasthof finden + reden + kartenspielen + schlägerei
				System.out.println("Du findest einen Gasthof."); // Neues Objekt erstellen
				Gasthof gasthof = new Gasthof();
				gasthof.besuchGasthof(held);
				passiertNichts(held);
				break;
			case 4:
				// Reisegruppe treffen + Würfelspiel + reden + ausrauben (beidseitig)
				passiertNichts(held);
				break;
			case 5:
				// Tausende Formen von es passiert nichts
				passiertNichts(held);
				break;
			case 6:
				// Händler treffen + reden + karten + heilung
				System.out.println("Ein fliegender Haendler besucht dich."); // Neues Objekt erstellen
				Haendler haendler = new Haendler();
				haendler.besuchHaendler(held);
				passiertNichts(held);
				break;
			default:
				System.out.println("Wurde etwa ne Sieben gewuerfelt?");
				break;
			}
		} while (true);
	}
	
	// passiert Nichts reaktion
	public void passiertNichts(Held held) {
		System.out.println("");
		System.out.println("reisen(r) Karte anschauen(k) Held anschauen(h) Spielratgeber(s) speichern(p)");
		System.out.print(">");

		String auswahl = lese.next();

		switch (auswahl) {
		case "s":
			System.out.println("Der Spielratgeber zeigt dir was du in den einzelnen Situationen machen kannst.");
			System.out.println("Es empfiehlt sich also immer mal wieder reinzuschauen!");
			System.out.println("Die Buchstaben hinter den einzelnen Aktionen zeigen dir an ... ");
			passiertNichts(held);
			break;
		case "r":
			bewegen();
			break;
		case "p":
			try {
				BufferedWriter bf = new BufferedWriter(new FileWriter("C:\\Users\\Stephan.Pautz\\Downloads\\test.txt"));
				bf.write(held.getnameH() + System.lineSeparator() +
				held.getGesundheit() + System.lineSeparator() +
				this.zeile + System.lineSeparator() +
				this.spalte + System.lineSeparator() +
				
				held.getproviant() + System.lineSeparator() +
				held.getwasser() + System.lineSeparator() +
				held.getstaerkeH() + System.lineSeparator() +
				held.getwiderstandH() + System.lineSeparator() +
				held.getgeschickH() + System.lineSeparator() +
				held.getErfahrung() + System.lineSeparator() +
				held.getGeld() + System.lineSeparator() +
				held.getfell() + System.lineSeparator());
				bf.flush();
				bf.close();
				System.out.println(" ... Das Spiel wurde erfolgreich hier gespeichert:");
				try { // Wartet eine Sekunde bevor es im Programm weitergeht
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("C:\\Users\\Stephan.Pautz\\Downloads\\test.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			passiertNichts(held);
			break;
		case "h":
			held.anzeigeHeld();
			passiertNichts(held);
			break;
		case "k":
			anzeigeKarte();
			passiertNichts(held);
			break;
		default:
			System.out.println("Sie haben eine falsche Auswahl getroffen, probieren Sie es nochmal.");
			passiertNichts(held);
			break;
		}

	}

}
