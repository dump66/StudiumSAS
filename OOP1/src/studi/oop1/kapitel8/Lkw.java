package studi.oop1.kapitel8;

public class Lkw extends Kfz{
	
	protected int gewicht;
	
	public Lkw(String kennzeichen, int ps, int gewicht){
		super(kennzeichen, ps);
		this.gewicht = gewicht;
	}
	
	public void print(){
		super.print();
		System.out.println("Gewicht: " + this.gewicht);
	}

}
