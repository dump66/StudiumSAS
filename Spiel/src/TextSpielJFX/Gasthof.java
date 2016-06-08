package TextSpielJFX;

import java.util.Scanner;

public class Gasthof extends Abenteuer1 {

	private int maxproviant = ((int) (Math.random() * 3) + 1);
	private int maxWasser = ((int) (Math.random() * 4) + 2);;
	private int maxtragWasser = 7; //getMaxWasser von Held verwenden du Held ==> weiter unten

	Scanner lese = new Scanner(System.in);

	public void besuchGasthof(Held held) {
		System.out.println("             _______");
		System.out.println("            /       \\ ");
		System.out.println("           /    _    \\");
		System.out.println("          /    |_|    \\  ");
		System.out.println("         /             \\  	Held anschauen(h)");
		System.out.println("        /    Gasthof    \\  	Proviant auff�llen(p)");
		System.out.println("       /|     _____     |\\ 	Wasser auff�llen(w)");
		System.out.println("        |    |==|==|    |  	im Gasthof �bernachten(u)");
		System.out.println("|---|---|    |--|--|    |  	weiterreisen?(r)");
		System.out.println("|---|---|    |==|==|    |       mit einem Gast W�rfeln spielen(s)");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("");

		String todogasthof = lese.next();
		switch (todogasthof) {
		case "p":
			System.out.println("Wieviel Proviant m�chtest du einkaufen? 1 Proviant kostet 1 Taler.");
			System.out.println(
					"Es steht maximal " + this.maxproviant + " Proviant zur Vef�gung. Wieviel m�chten Sie kaufen?");
			int proviant = lese.nextInt();
			if (proviant <= this.maxproviant && proviant >= 0) {
				held.setproviant(held.getproviant() + proviant);
				held.setGeld(held.getGeld() - proviant);
				this.maxproviant = this.maxproviant - proviant;
				if (held.getGeld() < 0) {
					System.out.println("Du hast zu wenig Geld.");
					held.setproviant(held.getproviant() - proviant);
					held.setGeld(held.getGeld() + proviant);
					this.maxproviant = this.maxproviant + proviant;
					besuchGasthof(held);
				} else {
					System.out.println("Deinem Rucksack wurden " + proviant + " Proviant hinzugef�gt.");
					System.out.println("Deinem Rucksack wurden " + proviant + " Taler entnommen.");
					besuchGasthof(held);
				}
			} else {
				System.out.println(
						"Ihre Eingabe war falsch. Es steht nur noch " + this.maxproviant + " Proviant zur Vef�gung.");
				besuchGasthof(held);
			}
			break;
		case "w":
			System.out.println("Wieviel Wasser m�chtest du einkaufen? 1 Wasser kostet 1 Taler.");
			System.out.println(
					"Es steht maximal " + this.maxWasser + " Wasser zur Vef�gung. Wieviel m�chten Sie kaufen?");
			int wasser = lese.nextInt();
			if (wasser <= this.maxWasser && wasser >= 0) {
				held.setwasser(held.getwasser() + wasser);
				held.setGeld(held.getGeld() - wasser);
				this.maxWasser = this.maxWasser - wasser;
				if (held.getGeld() < 0 || held.getwasser() > maxtragWasser) {
					if (held.getGeld() < 0) {
						System.out.println("Du hast zu wenig Geld.");
					} else {
						System.out.println("Du kannst nicht mehr als 7 Liter Wasser tragen.");
					}
					held.setwasser(held.getwasser() - wasser);
					held.setGeld(held.getGeld() + wasser);
					this.maxWasser = this.maxWasser + wasser;
					besuchGasthof(held);
				} else {
					System.out.println("Deinem Rucksack wurden " + wasser + " Wasser hinzugef�gt.");
					System.out.println("Deinem Rucksack wurden " + wasser + " Taler entnommen.");
					besuchGasthof(held);
				}
			} else {
				System.out.println(
						"Ihre Eingabe war falsch. Es steht nur noch " + this.maxproviant + " Wasser zur Vef�gung.");
				besuchGasthof(held);
			}

			break;
		case "h":
			held.anzeigeHeld();
			besuchGasthof(held);
			break;
		case "s":
			String spielwiederholen = "j";
			while (spielwiederholen == "j") {
				System.out.println("Muss noch fertig gemacht werden!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				int w1 = ((int) (Math.random() * 6) + 1);
				int w2 = ((int) (Math.random() * 6) + 1);
				System.out.println("gegner W�rfel: " + w1 + " " + w2);
				int w3 = ((int) (Math.random() * 6) + 1);
				int w4 = ((int) (Math.random() * 6) + 1);
				System.out.println("eigene W�rfel: " + w4 + " " + w3);
				System.out.println("Welche Zahl habt Ihr Zusammen erw�rfelt?");
				int wurfheld = lese.nextInt();
				System.out.println("Eigener und Gegner W�rfel anzeigen und Taler verteilen.");
				int wurfgegner = w1 + w2 + ((int) (Math.random() * 12) + 1);
				System.out.println("Ergebnis Gegner:" + wurfgegner);
				System.out.println("Ergebnis Held:" + wurfheld);
				int gesamtwuerfel = w1 + w2 + w3 + w4;
				int wurfh = (Math.abs(gesamtwuerfel - wurfheld));
				int wurfg = (Math.abs(gesamtwuerfel - wurfgegner));

				if (wurfh == wurfg) {
					System.out.println("Unentschieden!");
				}
				if (wurfh > wurfg) {
					System.out.println("Der Gegner gewinnt 1 Taler!");
				} else {
					System.out.println("Du gewinnst 1 Taler!");
				}

				System.out.println(
						"Noch ne Runde? (max 3) - Wenn 3 Runden hintereinander gewonnen, dann chance auf Schl�gerei.");

				System.out.println("M�chtest du nochmal spielen? (j/n)");
				spielwiederholen = lese.next();
			}
			besuchGasthof(held);
			break;
		case "u":
			// Wenn zu wenig Geld
			if (held.getGeld() <= 0) {
				System.out.println("Du hast zu wenig Geld.");
				besuchGasthof(held);
			}
			// Wenn Geld reicht
			int lebenspunkte = ((int) (Math.random() * 10) + 10);
			if (held.getGesundheit() == held.getmaxGesundheit()) {
				System.out.println(
						"Du bist ein Held! Du hattest doch schon maximale Lebenspunkte. Den Taler beh�lt der Wirt jetzt trotzdem.");
			}
			held.setGesundheit(held.getGesundheit() + lebenspunkte);
			System.out.println("Du hast wunderbar geschlafen und erh�lst " + lebenspunkte + " Lebenspunkte zur�ck.");
			held.setGeld(held.getGeld() - 1);

			if (held.getGesundheit() > held.getmaxGesundheit()) {
				System.out.println("Du hast alle deine Lebenspunkte wieder.");
				held.setGesundheit(held.getmaxGesundheit());
			}
			System.out.println("Deinem Rucksack wurde 1 Taler entnommen.");
			passiertNichts(held);
			break;
		case "r":
			System.out.println("Du reist weiter und �bernachtest im Freien.");
			passiertNichts(held);
			break;
		default:
			System.out.println("Sie haben eine falsche Auswahl getroffen, probieren Sie es nochmal.");
			besuchGasthof(held);
			break;
		}
	}
}
