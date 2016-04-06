package studi.oop1.kapitel8;

public class Bubbelsort {
	
	public static Sortierbar[] sort(Sortierbar[] arr){
		boolean isFinished = false;
		while (!isFinished){
			isFinished = true;
			for (int i = 0; i < arr.length-1; i++){
				if (arr[i].istGroesser(arr[i+1]) > 0){
					Sortierbar temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					isFinished = false;
				}
			}
		}
		
		return arr;
	}

}
