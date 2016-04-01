package studi.oop1.kapitel7;

public class Bruch {

	private static int zaehler;
	private static int nenner;
	
	public Bruch(int zaehler, int nenner){
		Bruch.zaehler = zaehler;
		Bruch.nenner = nenner;
		Bruch.kuerzen();
		tauscheVorzeichen();
	}
	
	public static void addieren(int zaehler, int nenner){
		Bruch.zaehler = nenner*Bruch.zaehler + Bruch.nenner*zaehler;
		Bruch.nenner *= nenner;
		kuerzen();
		tauscheVorzeichen();
	}
	
	public static void substrahieren(int zaehler, int nenner){
		Bruch.zaehler = nenner*Bruch.zaehler - Bruch.nenner*zaehler;
		Bruch.nenner *= nenner;
		kuerzen();
		tauscheVorzeichen();
	}
	
	public static void multiplizieren(int zaehler, int nenner){
		Bruch.zaehler *= zaehler;
		Bruch.nenner *= nenner;
		kuerzen();
		tauscheVorzeichen();
	}
	
	public static void dividieren(int zaehler, int nenner){
		Bruch.zaehler *= nenner;
		Bruch.nenner *= zaehler;
		kuerzen();
		tauscheVorzeichen();
	}
	
	private static void kuerzen(){
		int j = (Bruch.zaehler<Bruch.nenner)?Bruch.zaehler:Bruch.nenner;
		for (int i = Math.abs(j); i > 1; i--){
			if (Bruch.zaehler%i == 0 && Bruch.nenner%i == 0){
				Bruch.zaehler /= i;
				Bruch.nenner /= i;
				break;
			}
		}
	}
	
	private static void tauscheVorzeichen(){
		if (Bruch.nenner < 0){
				Bruch.zaehler*=-1;
				Bruch.nenner*=-1;
		}
	}
	
	public String toString(){
		return Bruch.zaehler + "/" + Bruch.nenner;
	}
	
}
