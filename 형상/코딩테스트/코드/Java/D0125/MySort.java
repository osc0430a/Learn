package D0125;
import java.util.Arrays;

public class MySort {

	static int[] input = {5, 5, 2, 3, 4, 1};
	
	public static void main(String[] args) {
		
		for(int i:input) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Arrays.sort(input);
		
		for(int i:input) {
			System.out.print(i + " ");
		}
		
	}
	
}
