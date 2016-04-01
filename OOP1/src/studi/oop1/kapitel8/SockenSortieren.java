package studi.oop1.kapitel8;

import java.util.Arrays;

public class SockenSortieren {

	public static void main(String[] args){
		Sortierbar[] sockList = new Sortierbar[10];
		
		for (int i = 0; i<10; i++){
			sockList[i] = new Socke("Schwarz", (int) (Math.random()*100));
		}
		
		System.out.println(Arrays.toString(sockList));
		sockList = Bubbelsort.sort(sockList);
		System.out.println(Arrays.toString(sockList));
	}
}
