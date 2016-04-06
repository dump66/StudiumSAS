package studi.oop1.kapitel8;

public class Rechteck extends Quadrat{

	private int breite;
	
	public Rechteck(String farbe, int laenge, int breite){
		super(farbe, laenge);
		this.breite = breite;
	}
	
	public void setBreite(int breite){
		this.breite = breite;
	}
	
	public int getBreite(){
		return this.breite;
	}
	
	public void getUmfang(){
		System.out.println("Umfang: " + (this.breite+this.breite+this.getLaenge()+this.getLaenge()) + " E");
	}
	
	public void getFlaeche(){
		System.out.println("Flaeche: " + (this.breite*this.getLaenge()) + " E²");
	}
	
	public void print(){
		System.out.println("--------------------");
		System.out.println("Typ: Rechteck");
		System.out.println("Farbe: " + this.getFarbe());
		System.out.println("Laenge: " + this.getLaenge() + " E");
		System.out.println("Breite: " + this.breite + " E");
		this.getUmfang();
		this.getFlaeche();
		System.out.println("--------------------");
		System.out.println();
	}
}
