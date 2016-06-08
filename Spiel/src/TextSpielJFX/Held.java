package TextSpielJFX;

import java.util.Scanner;

public class Held {

	/* Heldwerte */
	private String nameH;
	private int alter = 16;
	private int geld = 15;
	private int erfahrungspunkte = 0;
	private int stufe = 1;
	private String charakterklasse = "Bauer"; // in Unterklassen entsprechenden
												// Held festlegen

	/* Eigenschaftswerte */
	private int angriffsbonus = 0;
	private int schaden = 0;
	private int staerkeH = 3; // Für Angriffswert
	private int widerstandH = 3; // Für Verteidigung
	private int geschickH = 1; // beeinflusst Finden von etwas (Schatz, Nahrung, etc)
	private int gesundheitH = 100;
	private int maxGesundheit = 100;
	// private int charisma = 0; // beeinflusst Händlerpreise
	// private int durst;
	// private int hunger;
	// private int fingerfertigkeit = 0; // beeinflusst Magie, Schlösserknacken

	// Ausrüstung des Helden 
	private int fell = 0;
	private int proviant = 3;
	private int wasser = 7;
	private int heilkraut = 0;
	private int kapaRucksack = 50;
	
	// Konstruktor Held
	public Held(String name, int staerke, int geschicklichkeit, int geschicklickeit) {
		this.nameH = name;
		this.staerkeH = staerke;
		this.widerstandH = geschicklichkeit;
		this.geschickH = geschicklichkeit;
	}
	// max Live verwalten
	public int getmaxGesundheit() {
		return this.maxGesundheit;
	}
	public void setmaxGesundheit(int gesundheit) {
		this.maxGesundheit = gesundheit;
	}
	// Heilkrautausstattung verwalten
	public int getheilkraut() {
		return this.heilkraut;
	}
	public void setheilkraut(int heilkraut) {
		this.heilkraut = heilkraut;
	}
	// Wasserausstattung verwalten
	public int getwasser() {
		return this.wasser;
	}
	public void setwasser(int wasser) {
		this.wasser = wasser;
	}
	// Proviantausstattung verwalten
	public int getproviant() {
		return this.proviant;
	}
	public void setproviant(int proviant) {
		this.proviant = proviant;
	}
	// Fellausstattung verwalten
	public int getfell() {
		return this.fell;
	}
	public void setfell(int fell) {
		this.fell = fell;
	}
	// Geschicklichkeit verwalten
	public int getgeschickH() {
		return this.geschickH;
	}

	public void setgeschickH(int geschick) {
		this.geschickH = geschick;
	}
	// Widerstand verwalten
	public int getwiderstandH() {
		return this.widerstandH;
	}

	public void setwiderstandH(int widerstand) {
		this.widerstandH = widerstand;
	}

	// Staerke verwalten
	public int getstaerkeH() {
		return this.staerkeH;
	}

	public void setstaerkeH(int staerke) {
		this.staerkeH = staerke;
	}

	// Gesundheit verwalten
	public int getGesundheit() {
		return this.gesundheitH;
	}

	public void setGesundheit(int gesundheit) {
		this.gesundheitH = gesundheit;
	}

	// Geldverwaltung Held
	public int getGeld() {
		return this.geld;
	}

	public void setGeld(int geld) {
		this.geld = geld;
	}

	// Erfahrungspunkteverwaltung Held
	public int getErfahrung() {
		return this.erfahrungspunkte;
	}

	public void setErfahrung(int erfahrung) {
		this.erfahrungspunkte = erfahrung;
	}

	// Namensverwaltung Held
	public String getnameH() {
		return this.nameH;
	}

	public void setnameH(String nameH) {
		this.nameH = nameH;
	}

	// Held anschauen
	public void anzeigeHeld() {
		System.out.println("==================================================================");
		System.out.println("| Name: " + this.nameH + "\t \t \t" + " | Profession: " + this.charakterklasse + "\t \t |");
		System.out.println("| Taler: " + this.geld + "\t \t \t" + " | Alter: " + this.alter + "\t \t \t |");
		System.out.println(
				"| Erfahrungspunkte: " + this.erfahrungspunkte + "\t \t " + "| Stufe: " + this.stufe + "\t \t \t |");
		System.out.println("==================================================================");
		System.out
				.println("| Staerke: " + this.staerkeH + "\t \t \t" + " | Gesundheit: " + this.gesundheitH + "\t \t |");
		System.out.println("| Widerstand: " + this.widerstandH + "\t\t \t " + "| Geschicklichkeit: " + this.geschickH + " \t \t |");
		System.out.println("==================================================================");
		
		// Hier neue Ausgabe Inventar einbauen
		System.out.println("==================================================================");
		System.out.println("| Rucksackkapazität: "  + this.kapaRucksack + "\t \t \t \t \t \t |");
		System.out.println("------------------------------------------------------------------");
		System.out.println("| Proviant: " + this.proviant + "\t \t \t " + "| Wasser: " + this.wasser + "\t \t \t |");
		System.out.println("| Fell: " + this.fell + "\t \t \t " + "| Heilkräuter: " + this.heilkraut + "\t \t |");
		System.out.println("==================================================================");
	}

	// Held Kampfansicht
	public void anzeigeHeldkampf() {
		System.out.println("==================================================================");
		System.out.println("| Name: " + this.nameH + "\t \t \t" + " | Lebenspunkte: " + this.gesundheitH + "\t \t |");
		System.out
				.println("| Staerke: " + this.staerkeH + "\t \t \t" + " | Widerstand: " + this.widerstandH + "\t \t |");
		System.out.println("| Angriffsbonus: " + angriffsbonus + "\t \t" + " | \t \t \t \t |");
		System.out.println("==================================================================");
	}

	// Helden erstellen
	public void generieren() {
		Scanner einlesen = new Scanner(System.in);
		System.out.println("Ein neuer Held wird geboren. Wie soll er oder sie heißen?"); // maximal
																							// 7
																							// Buchstaben
		System.out.print(">");
		this.nameH = einlesen.next();
		// System.out.println("Was für eine charakterklasse? Druide, Dieb,
		// Jaeger?);
		// Werteverteilung ==> Extragenerationszeug (eigene Methode)
	}

	// Kampfsystem Held
	public void angriffHeld(Gegner tier) {
		if (getGesundheit() <= 0) {
			System.out.println("       ___");
			System.out.println("      /  /\\   |---.");
			System.out.println("      |__|/__ |---,\\");
			System.out.println("      |  `   |= ");
			System.out.println("      |      /|");
			System.out.println("      |  .--' |");
			System.out.println("      |   |   |");
			System.out.println("      |   |   |");
			System.out.println("     /    |   |");
			System.out.println("    /_____\\ ");
			System.out.println("Dein Held ist gestorben.");
			System.exit(0);
		}

		System.out.println("");
		System.out.println("Was möchtest du als nächstes machen?");
		System.out.println(
				"fliehen = f, angreifen = a, verteidigen = v, auf den Boden schmeißen und wie ein Baby winseln = w");
		System.out.println(">");

		Scanner lese = new Scanner(System.in);
		String aktion = lese.next();
		switch (aktion) {
		case "f":
			if ((int) (Math.random() * 6) + 1 >= 4) {
				System.out.println("Du konntest erfolgreich fliehen.");
				tier.setgesundheitG(-100);
			} else {
				System.out.println("Du bist zu langsam, der Kampf geht weiter ...");
			}
			break;
		case "a":
			// +1 Stärke wegen angriff
			if ((getstaerkeH() + 1) > tier.getwiderstandG()) {
				if ((int) (Math.random() * 6) + 1 >= 3) {
					schaden = (((int) (Math.random() * 10) + 1) + getstaerkeH() + angriffsbonus);
					tier.setgesundheitG(tier.getgesundheitG() - schaden);
					System.out.println("Du hast erfolgreich getroffen und " + schaden + " Schadenspunkte ausgeteilt.");
					tier.anzeigeGegner();
					this.angriffsbonus = 0;
				} else {
					System.out.println("Der Angriff von dir ging knapp daneben.");
					tier.anzeigeGegner();
				}

			} else if (getstaerkeH() == tier.getwiderstandG()) {
				if ((int) (Math.random() * 6) + 1 >= 4) {
					schaden = (((int) (Math.random() * 10) + 1) + getstaerkeH() + angriffsbonus);
					tier.setgesundheitG(tier.getgesundheitG() - schaden);
					System.out.println("Du hast erfolgreich getroffen und " + schaden + " Schadenspunkte ausgeteilt");
					tier.anzeigeGegner();
					this.angriffsbonus = 0;
				} else {
					System.out.println("Der Angriff von dir ging daneben.");
					tier.anzeigeGegner();
				}
			} else {
				if ((int) (Math.random() * 6) + 1 >= 5) {
					schaden = (((int) (Math.random() * 10) + 1) + getstaerkeH() + angriffsbonus);
					tier.setgesundheitG(tier.getgesundheitG() - schaden);
					System.out.println("Du hast erfolgreich getroffen und " + schaden + " Schadenspunkte ausgeteilt");
					tier.anzeigeGegner();
					this.angriffsbonus = 0;
				} else {
					System.out.println("Der Angriff von dir ging voll daneben.");
					tier.anzeigeGegner();
				}
			}
			break;
		case "v":
			if ((getwiderstandH() + 1) > tier.getstaerkeG()) {
				if ((int) (Math.random() * 6) + 1 >= 3) {
					this.angriffsbonus = 10;
					System.out.println(
							"Du hast dich erfolgreich verteidigt und erhälst einen Angriffsbonus für deinen nächsten Angriff.");
					tier.anzeigeGegner();
				} else {
					System.out.println("Deine Verteidigung ging fürchterlich schief.");
					tier.anzeigeGegner();
				}

			} else if ((getwiderstandH() + 1) == tier.getstaerkeG()) {
				if ((int) (Math.random() * 6) + 1 >= 4) {
					this.angriffsbonus = 7;
					System.out.println(
							"Du hast dich erfolgreich verteidigt und erhälst einen Angriffsbonus für deinen nächsten Angriff.");
					tier.anzeigeGegner();
				} else {
					System.out.println("Deine Verteidigung ging schief.");
				}

			} else {
				if ((int) (Math.random() * 6) + 1 >= 5) {
					this.angriffsbonus = 5;
					System.out.println(
							"Du hast dich erfolgreich verteidigt und erhälst einen Angriffsbonus für deinen nächsten Angriff.");
					tier.anzeigeGegner();
				} else {
					System.out.println("Deine Verteidigung ging leider schief.");
				}

			}
			break;
		case "w":
			if ((int) (Math.random() * 6) + 1 >= 3) {
				System.out.println("Das Tier wendet sich angewiedert von dir ab und verschwindet.");
				tier.setgesundheitG(-100);
			} else {
				System.out.println("Du wirst nun ohne Gegenwehr angenagt. Der Kampf geht weiter.");
			}
			break;
		default:
			System.out.println(
					"Sie haben keine Aktion gewählt und werden nun ohne Gegenwehr angenagt. Der Kampf geht weiter.");
			break;
		}

	}
}
