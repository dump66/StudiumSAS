package studi.oop1.kapitel6;

public class Bubbelsort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,3,6,1,5,7,9,8,4,0};
		arr = sort(arr);
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	private static int[] sort(int[] arr){
		boolean isFinished = false;
		while (!isFinished){
			isFinished = true;
			for (int i = 0; i < arr.length-1; i++){
				if (arr[i] < arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					isFinished = false;
				}
			}
		}
		
		return arr;
	}

}
