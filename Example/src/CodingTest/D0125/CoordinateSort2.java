package CodingTest.D0125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoordinateSort2 {
	static int[][] input = {{0, 4}, {1, 2}
	, {1, -1}, {2, 2}, {3, 3}};

	public static void main(String[] args) {
		System.out.print("INPUT = ");
		for(int[] i:input) {
			System.out.print("["+i[0]+", "+i[1]+"] ");
		}
		System.out.println();
		Collections.sort(new ArrayList<int[]>(), null);
		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}			
		});
		
		System.out.print("ANSWER = ");
		for(int[] i:input) {
			System.out.print("["+i[0]+", "+i[1]+"] ");
		}
		System.out.println();
	}
}
