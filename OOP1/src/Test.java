import java.io.FileWriter;
import java.io.IOException;


public class Test {

	public static void main(String[] args) {
		int number = 100000;
		int[] count = new int[49];
		for (int i = 0; i<number; i++){
			int j = (int) Math.floor(Math.random()*49+1);
			count[j-1]++;
		}
		int sum = 0;
		double high = 0;
		double low = number;
		for (int k = 0; k<49; k++){
			sum+=count[k];
			high = count[k]>high?count[k]:high;
			low = count[k]<low?count[k]:low;
			System.out.println(k+1 + ": " + count[k]);
		}
		System.out.println();
		double mid = sum/49D;
		//System.out.println("Mittel: " + mid);
		System.out.println("Entfernung zu high: " + (1-mid/high));
		System.out.println("Entfernung zu low: " + (1-low/mid));
	}

}
