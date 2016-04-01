package studi.oop1.vorlesung;

public class Girokonto extends Konto implements Ikonto{
	

	public Girokonto(int nummer, int stand){
		super(stand, nummer);
	}
	
	public Girokonto(){
		super(3, 4);
	}

	@Override
	public void kennung() {
		System.out.println("Girokonto");
	}
}
