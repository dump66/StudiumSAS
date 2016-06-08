package TextSpielJFX;

import java.util.Scanner;

public class Haendler extends Abenteuer1 {

	private int maxproviant = ((int) (Math.random() * 3) + 1);
	private int maxWasser = ((int) (Math.random() * 4) + 2);;
	private int maxtragWasser = 7; //getMaxWasser von Held verwenden du Held ==> weiter unten

	Scanner lese = new Scanner(System.in);

	public void besuchHaendler(Held held) {
		System.out.println("                                 _ .--.");
		System.out.println("                                ( `    )");
		System.out.println("                             .-'      `--,");
		System.out.println("                  _..----.. (             )`-.");
		System.out.println("                .'_|` _|` _|(  .__,           )");
		System.out.println("               /_|  _|  _|  _(        (_,  .-'");
		System.out.println("              ;|  _|  _|  _|  '-'__,--'`--'");
		System.out.println("              | _|  _|  _|  _| |");
		System.out.println("          _   ||  _|  _|  _|  _|");
		System.out.println("        _( `--.\\_|  _|  _|  _|/");
		System.out.println("     .-'       )--,|  _|  _|.`	Held anschauen(h)");
		System.out.println("    (__, (_      ) )_|  _| /	Proviant auffüllen(p)");
		System.out.println("      `-.__.\\ _,--'\\|__|__/	Wasser auffüllen(w)");
		System.out.println("                    ;____;	weiterreisen?(r)");
		System.out.println("                     \\YT/	mit Haendler erzaehlen(e) ==> karte soll hier hin)");
		System.out.println("                      ||	Heilkräuter kaufen (k)");
		System.out.println("                     |°°|	Fell verkaufen(f)");
		System.out.println("                     '=='");
		System.out.println("Was moechtest du machen?");

		String todogasthof = lese.next();
		switch (todogasthof) {
		case "p":
			// Proviant kaufen
			System.out.println("Wieviel Proviant möchtest du einkaufen? 1 Proviant kostet 1 Taler.");
			System.out.println(
					"Es steht maximal " + this.maxproviant + " Proviant zur Vefügung. Wieviel möchten Sie kaufen?");
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
					besuchHaendler(held);
				} else {
					System.out.println("Deinem Rucksack wurden " + proviant + " Proviant hinzugefügt.");
					System.out.println("Deinem Rucksack wurden " + proviant + " Taler entnommen.");
					besuchHaendler(held);
				}
			} else {
				System.out.println(
						"Ihre Eingabe war falsch. Es steht nur noch " + this.maxproviant + " Proviant zur Vefügung.");
				besuchHaendler(held);
			}
			break;
		case "w":
			// Wasser kaufen
			System.out.println("Wieviel Wasser möchtest du einkaufen? 1 Wasser kostet 1 Taler.");
			System.out.println(
					"Es steht maximal " + this.maxWasser + " Wasser zur Vefügung. Wieviel möchten Sie kaufen?");
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
					besuchHaendler(held);
				} else {
					System.out.println("Deinem Rucksack wurden " + wasser + " Wasser hinzugefügt.");
					System.out.println("Deinem Rucksack wurden " + wasser + " Taler entnommen.");
					besuchHaendler(held);
				}
			} else {
				System.out.println(
						"Ihre Eingabe war falsch. Es steht nur noch " + this.maxproviant + " Wasser zur Vefügung.");
				besuchHaendler(held);
			}

			break;
		case "h":
			held.anzeigeHeld();
			besuchHaendler(held);
			break;
		case "e":
			// Mit Haendler reden
			besuchHaendler(held);
			break;
		case "k":
			// Heilkräuter kaufen
			besuchHaendler(held);
			break;
		case "r":
			//weiterreisen
			System.out.println("Du reist weiter und übernachtest im Freien.");
			passiertNichts(held);
			break;
		case "f":
			//fell verkaufen
			besuchHaendler(held);
			break;
		default:
			System.out.println("Sie haben eine falsche Auswahl getroffen, probieren Sie es nochmal.");
			besuchHaendler(held);
			break;
		}
	}
}
