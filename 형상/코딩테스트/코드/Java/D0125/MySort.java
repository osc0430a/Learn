package CodingTest.D0125;
import java.util.Arrays;

public class MySort {

	static int[] input = {5, 2, 3, 4, 1};
	
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		System.out.print("INPUT = ");
		for(int i:input) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Arrays.sort(input);
		
		System.out.print("RESULT = ");
		for(int i:input) {
			System.out.print(i + " ");
		}
		System.out.println();
		long after = System.currentTimeMillis();
		System.out.println("RUNTIME = " + (after - before) + "ms");
	}
	
}
