package studi.oop1.kapitel9.armee;


import studi.oop1.kapitel9.bubble.Bubbelsort;
import studi.oop1.kapitel9.bubble.Sortierbar;
import studi.oop1.kapitel9.mensch.Mensch;
import studi.oop1.kapitel9.mensch.Soldat;

public class Armee {

	public static void main(String[] args){
		Sortierbar[] armee = new Sortierbar[11];
		String name = "Stephan";
		for (int i = 0; i<10; i++){
			armee[i] = new Soldat(name+i, (int) (Math.random()*10));
		}
		armee[10] = new Mensch("Sascha");
		System.out.println();
		Bubbelsort.sort(armee);
		
	}
	
	private static void print(Sortierbar[] arr){
		for (int i = 0; i<10; i++){
			//System.out.println(arr[i].getName() + " " + arr[i].getGroesse());
		}
	}
}
