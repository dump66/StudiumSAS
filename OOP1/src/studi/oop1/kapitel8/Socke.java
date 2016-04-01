package studi.oop1.kapitel8;

public class Socke implements Sortierbar {

	private String farbe;
	private int groesse;
	
	public Socke(String farbe, int groesse){
		this.farbe = farbe;
		this.groesse = groesse;
	}

	public int istGroesser(Sortierbar element) {
		Socke socke = (Socke) element;
		return this.groesse - socke.groesse;
	}
	
	@Override
	public String toString(){
		return "" + this.groesse;
	}
}
