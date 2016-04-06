package studi.oop1.kapitel8;

public class Kreis extends Figur{

	private int radius;
	
	public Kreis(String farbe, int radius){
		super(farbe);
		this.radius = radius;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	public void getUmfang(){
		System.out.println("Umfang: " + (2*this.radius*Math.PI) + " E");
	}
	
	public void getFlaeche(){
		System.out.println("Flaeche: " + (this.radius*this.radius*Math.PI) + " E²");
	}
	
	public void print(){
		System.out.println("--------------------");
		System.out.println("Typ: Kreis");
		System.out.println("Farbe: " + this.getFarbe());
		System.out.println("Radius: " + this.radius + " E");
		this.getUmfang();
		this.getFlaeche();
		System.out.println("--------------------");
		System.out.println();
	}
}
