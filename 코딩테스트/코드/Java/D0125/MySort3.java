package CodingTest.D0125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MySort3 {
	
	final static int[] input = {5, 2, 3, 1, 4, 2
			, 3, 5, 1, 7};
	
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		ArrayList<Integer> in = new ArrayList<Integer>();
//		int[] test = new int[10000000];
//		
//		for(int i=0; i<test.length; i++) {
//			test[i] = new Random().nextInt();
//		}
//		
//		
		for(int i: input) {
			in.add(i);
		}
		System.out.print("INPUT = ");
		for(int i: input) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Collections.sort(in);
		
		System.out.print("RESULT = ");
		for(int i: in) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		long after = System.currentTimeMillis();
		System.out.println("Collections.sort");
		System.out.println("Run Time = " + (after - before) + "ms");
		
	}

}
