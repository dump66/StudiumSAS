package studi.oop1.kapitel7;

public class RechteckListe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rechteck[] rechtecke = new Rechteck[1000];
		long flaeche = 0;
		int istQuadrat = 0;
		
		for (int i = 0; i<1000; i++){
			rechtecke[i] = new Rechteck(calcRandom(), calcRandom());
			flaeche += rechtecke[i].flaeche();
			istQuadrat += rechtecke[i].istQuadrat()?1:0;
		}
		
		System.out.println("Durchschnitt: " + (flaeche/1000) + " ! Quadrate: " + istQuadrat + " !"); 
	}
	
	public static int calcRandom(){
		double j = Math.random()*10;
		int i = (int) j;
		i++;
		return i;
	}

}
