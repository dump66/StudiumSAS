package TextSpielJFX;

public class Gegner {

	// Werte Gegner
	private String nameG = "Tier";
	private int staerkeG = 0;
	private int widerstandG = 0;
	private int gesundheitG = 50;
	private int angriff = 5; // Angriffsschaden
	private int schaden = 0;
	private int erfahrungsbonus = 0;
	private int fell = 0;
	private int geld = 0;
	private int fleisch = 0;
	int zufallszahl = (int) (Math.random() * 6) + 1;

	// Konstruktor
	public Gegner(int staerke, int widerstand) {
		this.staerkeG = staerke;
		this.widerstandG = widerstand;
	}

	// Erfahrungspunke verwalten
	public int geterfahrungsbonus() {
		return this.erfahrungsbonus;
	}

	// Verwaltung Staerke
	public int getstaerkeG() {
		return this.staerkeG;
	}

	public void setstaerkeG(int staerkeG) {
		this.staerkeG = staerkeG;
	}

	// Verwaltung Widerstand
	public int getwiderstandG() {
		return this.widerstandG;
	}

	public void setwiderstandG(int widerstandG) {
		this.widerstandG = widerstandG;
	}

	// Verwaltung Gesundheit
	public int getgesundheitG() {
		return this.gesundheitG;
	}

	public void setgesundheitG(int gesundheit) {
		this.gesundheitG = gesundheit;
	}
	// Ausbeute nach Kampf verwalten
	public void ausbeute(Held held) {
		if (getgesundheitG() <= 0 && getgesundheitG() > -99) {
			System.out.println("Du hast dein Gegner in die ewigen Jagdgründe befördert.");
			held.setErfahrung(held.getErfahrung() + geterfahrungsbonus());
			System.out.println("Du erhälst " + geterfahrungsbonus() + " Erfahrungspunkte.");
			if (this.geld > 0) {
				held.setGeld(held.getGeld() + this.geld);
				System.out.println("Du findest " + this.geld + " Taler in den Taschen des Bandites");
			}
			if (this.fell > 0) {
			 if (held.getgeschickH() <=3)
			 {
				 if ((int) (Math.random() * 6) + 1 >= 5)
				 {
					 held.setfell(held.getfell() + this.fell);
					 System.out.println("Du konntest erfolgreich " + this.fell + " Fell gewinnen.");
				 }
				 else
				 {
					 System.out.println("Du konntest leider kein Fell gewinnen."); 
				 }
				 if ((int) (Math.random() * 6) + 1 >= 5)
				 {
					 held.setproviant(held.getproviant() + this.fleisch);
					 System.out.println("Du konntest erfolgreich deinen Proviant um " + this.fleisch + " Fleisch erweitern.");
				 }
				 else
				 {
					 System.out.println("Du konntest leider kein Fleisch für dein Proviant gewinnen."); 
				 }
			 }
			 if (held.getgeschickH() == 4)
			 {
				 if ((int) (Math.random() * 6) + 1 >= 4)
				 {
					 held.setfell(held.getfell() + this.fell);
					 System.out.println("Du konntest erfolgreich " + this.fell + " Fell gewinnen.");
				 }
				 else
				 {
					 System.out.println("Du konntest leider kein Fell gewinnen."); 
				 }
				 if ((int) (Math.random() * 6) + 1 >= 4)
				 {
					 held.setproviant(held.getproviant() + this.fleisch);
					 System.out.println("Du konntest erfolgreich deinen Proviant um " + this.fleisch + " Fleisch erweitern.");
				 }
				 else
				 {
					 System.out.println("Du konntest leider kein Fleisch für dein Proviant gewinnen."); 
				 }
			 }
			 if (held.getgeschickH() >=5)
			 {
				 if ((int) (Math.random() * 6) + 1 >= 3)
				 {
					 held.setfell(held.getfell() + this.fell);
					 System.out.println("Du konntest erfolgreich " + this.fell + " Fell gewinnen."); 
				 }
				 else 
				 {
					 System.out.println("Du konntest leider kein Fell gewinnen."); 
				 }
				 if ((int) (Math.random() * 6) + 1 >= 3)
				 {
					 held.setproviant(held.getproviant() + this.fleisch);
					 System.out.println("Du konntest erfolgreich deinen Proviant um " + this.fleisch + " Fleisch erweitern.");
				 }
				 else
				 {
					 System.out.println("Du konntest leider kein Fleisch für dein Proviant gewinnen."); 
				 }
			 }
			}

		}
	}

	// Festlegung Werte Gegner
	public void generierenGegner()
	{
		switch (zufallszahl) {
		case 1:
			this.nameG = "Baer";
			this.staerkeG = 4;
			this.widerstandG = 4;
			this.angriff = 10;
			this.erfahrungsbonus = 50;
			this.gesundheitG = 50;
			this.fell = 4;
			this.fleisch = 3;
			break;
		case 2:
			this.nameG = "Eber";
			this.staerkeG = 3;
			this.widerstandG = 2;
			this.angriff = 7;
			this.erfahrungsbonus = 30;
			this.gesundheitG = 40;
			this.fell = 2;
			this.fleisch = 2;
			break;
		case 3:
			this.nameG = "Luchs";
			this.staerkeG = 4;
			this.widerstandG = 2;
			this.angriff = 8;
			this.erfahrungsbonus = 40;
			this.gesundheitG = 45;
			this.fell = 3;
			this.fleisch = 1;
			break;
		case 4:
			this.nameG = "Laus";
			this.staerkeG = 1;
			this.widerstandG = 1;
			this.angriff = 2;
			this.erfahrungsbonus = 10;
			this.gesundheitG = 25;
			this.fell = 1;
			this.fleisch = 0;
			break;
		case 5:
			this.nameG = "Bandit";
			this.staerkeG = 3;
			this.widerstandG = 3;
			this.angriff = 7;
			this.erfahrungsbonus = 45;
			this.gesundheitG = 90;
			this.geld = ((int) (Math.random() * 10) + 1);
			break;
		default:
			this.nameG = "Wolf";
			this.staerkeG = 2;
			this.widerstandG = 2;
			this.angriff = 6;
			this.erfahrungsbonus = 20;
			this.gesundheitG = 35;
			this.fell = 2;
			this.fleisch = 1;
			break;
		}
	}
	// Anzeige Werte Gegner
	public void anzeigeGegner() {

		System.out.println("==================================================================");
		System.out
				.println("| Name Gegner: " + this.nameG + "\t \t" + " | Lebenspunkte: " + this.gesundheitG + "\t \t |");
		System.out
				.println("| Staerke: " + this.staerkeG + "\t \t \t" + " | Widerstand: " + this.widerstandG + "\t \t |");
		System.out.println("==================================================================");
	}

	// Kampfsystem Gegner
	public void angriffG(Held held) {
		if (getstaerkeG() > held.getwiderstandH()) {
			if ((int) (Math.random() * 6) + 1 >= 3) {
				schaden = ((int) (Math.random() * this.angriff) + 1 + getstaerkeG());
				held.setGesundheit((held.getGesundheit()) - schaden);
				System.out.println("Du wurdest getroffen und erleidest " + schaden + " Schadenspunkte.");
				held.anzeigeHeldkampf();
			} else {
				System.out.println("Der Angriff des Gegners hat dich knapp verfehlt.");
				held.anzeigeHeldkampf();
			}

		} else if (getstaerkeG() == held.getwiderstandH()) {
			if ((int) (Math.random() * 6) + 1 >= 4) {
				schaden = ((int) (Math.random() * this.angriff) + 1 + getstaerkeG());
				held.setGesundheit((held.getGesundheit()) - schaden);
				System.out.println("Du wurdest getroffen und erleidest " + schaden + " Schadenspunkte.");
				held.anzeigeHeldkampf();
			} else {
				System.out.println("Der Angriff des Gegners hat dich verfehlt.");
				held.anzeigeHeldkampf();
			}

		} else {
			if ((int) (Math.random() * 6) + 1 >= 5) {
				schaden = ((int) (Math.random() * this.angriff) + 1 + getstaerkeG());
				held.setGesundheit((held.getGesundheit()) - schaden);
				System.out.println("Du wurdest getroffen und erleidest " + schaden + " Schadenspunkte.");
				held.anzeigeHeldkampf();
			} else {
				System.out.println("Der Angriff des Gegners hat dich voll verfehlt.");
				held.anzeigeHeldkampf();
			}

		}

	}
}
