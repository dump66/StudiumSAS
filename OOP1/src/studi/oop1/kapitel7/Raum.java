package studi.oop1.kapitel7;

import java.util.Scanner;

public class Raum {
	private boolean[] isOccupied;
	Scanner read = new Scanner(System.in);
	
	public Raum(){
		this.isOccupied = new boolean[24];
		for (int i=0; i<24; i++){
			this.isOccupied[i] = false;
		}
	}
	
	public void reservieren(){
		System.out.println("Geben Sie die gewünschte Stunde an:");
		int stunde = read.nextInt();
		this.isOccupied[stunde] = true;
	}
	
	public void stornieren(){
		System.out.println("Geben Sie die gewünschte Stunde an:");
		int stunde = read.nextInt();
		this.isOccupied[stunde] = false;
	}
	
	public void zeigeBelegung(){
		System.out.println("Der Raum ist reserviert um:");
		for (int i = 0; i<24; i++){
			if (this.isOccupied[i]){
				System.out.println(i + " - " + (i+1) + " Uhr");
			}
		}
	}
}
