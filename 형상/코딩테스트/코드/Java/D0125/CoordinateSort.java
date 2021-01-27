package D0125;

import java.util.Arrays;
import java.util.Comparator;

public class CoordinateSort {
	static int[][] input = {{3, 4}, {1, 1}
	, {1, -1}, {2, 2}, {3, 3}};

	public static void main(String[] args) {		
		for(int[] i:input) {
			System.out.print("["+i[0]+", "+i[1]+"] ");
		}
		System.out.println();
				
		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}			
		});
		
		for(int[] i:input) {
			System.out.print("["+i[0]+", "+i[1]+"] ");
		}
		System.out.println();
	}	
}
