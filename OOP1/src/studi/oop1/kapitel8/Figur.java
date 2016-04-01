package studi.oop1.kapitel8;

public abstract class Figur {

	private String farbe;
	
	public Figur (String farbe){
		this.farbe = farbe;
	}
	
	public void setFarbe(String farbe){
		this.farbe = farbe;
	}
	
	public String getFarbe(){
		return this.farbe;
	}
	
	public abstract void getUmfang();
	
	public abstract void getFlaeche();
	
	public abstract void print();
}
