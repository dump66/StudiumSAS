package studi.oop1.kapitel7;

public class Ampel {

	public static final int ROT = 0;
	public static final int ROT_GELB = 1;
	public static final int GRUEN = 2;
	public static final int GELB = 3;
	private int farbe;

	
	public Ampel(){
		this.farbe = Ampel.ROT;
	}
	
	public String getFarbe() {
		switch (farbe) {
		case 0:
			return "Rot";
		case 1:
			return "Rot-Gelb";
		case 2:
			return "Grün";
		case 3:
			return "Gelb";
		default:
			return "";
		}
	}
	
	public void schalte(){
		switch (farbe) {
		case 0:
			this.farbe = Ampel.ROT_GELB;
			break;
		case 1:
			this.farbe = Ampel.GRUEN;
			break;
		case 2:
			this.farbe = Ampel.GELB;
			break;
		case 3:
			this.farbe = Ampel.ROT;
			break;
		}
	}

}
