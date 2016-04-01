package studi.oop1.kapitel9.mensch;

import studi.oop1.kapitel9.bubble.Sortierbar;

public class Mensch implements Sortierbar{

	private String name;
	
	public Mensch(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public int istGroesser(Sortierbar element) throws Exception {
		return 0;
	}
}
