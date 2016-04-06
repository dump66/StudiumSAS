package studi.oop1.kapitel8;

public class Zeichenprogramm {

	public static void main(String[] args){
		Figur[] figuren = new Figur[3];
		figuren[0] = new Kreis("Weiﬂ", 3);
		figuren[1] = new Quadrat("Rot", 2);
		figuren[2] = new Rechteck("Blau", 3, 4);
		
		for(int i = 0; i < figuren.length; i++){
			figuren[i].print();
		}
		
	}
}
