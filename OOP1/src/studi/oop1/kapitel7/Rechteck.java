package studi.oop1.kapitel7;

public class Rechteck {
	
	private int laenge;
	private int breite;
	
	public Rechteck(int laenge, int breite){
		this.laenge = laenge;
		this.breite = breite;
	}
	
	public long flaeche(){
		return (this.laenge*this.breite);
	}
	
	public boolean istQuadrat(){
		return (this.laenge==this.breite);
	}
}
