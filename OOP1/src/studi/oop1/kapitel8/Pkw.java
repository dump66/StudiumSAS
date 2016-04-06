package studi.oop1.kapitel8;

public class Pkw extends Kfz{

	protected int sitze;
	
	public Pkw(String kennzeichen, int ps, int sitze){
		super(kennzeichen, ps);
		this.sitze = sitze;
	}
	
	public void print(){
		super.print();
		System.out.println("Sitze " + this.sitze);
	}
}
