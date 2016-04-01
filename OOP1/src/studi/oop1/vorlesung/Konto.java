package studi.oop1.vorlesung;

public abstract class Konto {

	protected int stand;
	protected int nummer;
	
	public Konto(int stand, int nummer){
		this.stand = stand;
		this.nummer = nummer;
	}
	
	public void einzahlen(int betrag){
		this.stand += betrag;
	}
	
	public abstract void kennung();
}
