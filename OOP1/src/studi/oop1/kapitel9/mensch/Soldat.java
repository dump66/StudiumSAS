package studi.oop1.kapitel9.mensch;

import studi.oop1.kapitel9.bubble.Sortierbar;

public class Soldat extends Mensch implements Sortierbar {

	private int groesse;

	public Soldat(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}

	public int getGroesse() {
		return this.groesse;
	}

	public int istGroesser(Sortierbar element) {
		Soldat s = (Soldat) element;
		return this.groesse - s.groesse;
	}

}
