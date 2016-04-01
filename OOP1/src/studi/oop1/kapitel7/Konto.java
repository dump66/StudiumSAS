package studi.oop1.kapitel7;

public class Konto {
	
	private String kontoinhaber;
	private float kontostand;
	private long kontonummer;
	
	public Konto(String inhaber, long nummer){
		this.kontoinhaber = inhaber;
		this.kontonummer = nummer;
		this.kontostand = 0.0f;
	}
	
	public void einzahlen(float betrag){
		this.kontostand += betrag;
	}
	
	public void auszahlen(float betrag){
		this.kontostand -= betrag;
	}
	
	public void kontoauszug(){
		System.out.println(this.kontoinhaber + ", " + this.kontonummer + ": " + this.kontostand + " €");
	}
	
	
}
