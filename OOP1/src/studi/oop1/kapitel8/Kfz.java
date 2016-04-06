package studi.oop1.kapitel8;

public class Kfz {

	protected String kennzeichen;
	protected int ps;
	
	public Kfz(String kennzeichen, int ps){
		this.kennzeichen = kennzeichen;
		this.ps = ps;
	}
	
	public void print(){
		System.out.println("Kennzeichen: " + this.kennzeichen);
		System.out.println("PS-Stärke: " + this.ps);
	}
}
