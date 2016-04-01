package studi.oop1.kapitel7;

public class Zeit {

	private int stunden;
	private int minuten;
	
	public Zeit(){
		this.stunden = 0;
		this.minuten = 0;
	}
	
	public Zeit(int stunden, int minuten){
		this();
		if (stunden <= 23 && stunden >= 0 && minuten <= 59 && minuten >= 0){
			this.stunden = stunden;
			this.minuten = minuten;
		} else {
			System.out.println("Es wurden keine gültige Zeit eingegeben. Die Zeit wird auf 00:00 festgelegt!");
		}
	}
	
	public void print(){
		System.out.println("Die Uhrzeit ist: ");
		if (stunden < 10){
			System.out.print("0");
		}
		System.out.print(stunden + ":");
		if (minuten<10){
			System.out.print("0");
		}
		System.out.println(minuten);
		
	}
	
}
