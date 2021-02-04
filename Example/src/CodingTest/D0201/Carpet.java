package CodingTest.D0201;

import java.util.Arrays;
import java.util.Collections;

public class Carpet {
	static Integer[] answer = new Integer[2];
		
	private static void solution(int x, int y, int[] in) {
		int brown = in[0];
		int yellow = in[1];
		
		int tmp_brown = x * 2 + (y - 2) * 2;
		int tmp_yellow = (x - 2) * (y - 2);
		if(tmp_brown == brown) {
			if(tmp_yellow == yellow) {
				answer[0] = x;
				answer[1] = y;
			}
		}
		else {
			solution(x+1, y, in);
			solution(x, y+1, in);
		}
	}
	
	public static void main(String[] args) {
		final int[] input1 = {10, 2};
		final int[] input2 = {8, 1};
		final int[] input3 = {24, 24};
		int[] in = input3;
		
		System.out.print("INPUT = ");
		for(int i: in) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		solution(3, 3, in);
		Arrays.sort(answer, Collections.reverseOrder());
		System.out.print("ANSWER = ");
		for(int i: answer) {
			System.out.print(i + " ");
		}		
		System.out.println();
	}
	
}
