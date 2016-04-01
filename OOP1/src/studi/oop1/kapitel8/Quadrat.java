package studi.oop1.kapitel8;

public class Quadrat extends Figur{

	private int laenge;
	
	public Quadrat(String farbe, int laenge){
		super(farbe);
		this.laenge = laenge;
	}
	
	public void setLaenge(int laenge){
		this.laenge = laenge;
	}
	
	public int getLaenge(){
		return this.laenge;
	}
	
	public void getUmfang(){
		System.out.println("Umfang: " + (4*this.laenge) + " E");
	}
	
	public void getFlaeche(){
		System.out.println("Flaeche: " + (this.laenge*this.laenge) + " E²");
	}
	
	public void print(){
		System.out.println("--------------------");
		System.out.println("Typ: Quadrat");
		System.out.println("Farbe: " + this.getFarbe());
		System.out.println("Seitenlaenge: " + this.laenge + " E");
		this.getUmfang();
		this.getFlaeche();
		System.out.println("--------------------");
		System.out.println();
	}
}
