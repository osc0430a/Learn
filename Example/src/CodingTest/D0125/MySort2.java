package CodingTest.D0125;

import java.util.ArrayList;
import java.util.Collections;

public class MySort2 {

	final static int[] input = {5, 4, 3, 2, 1};
	
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		// �������� ����ص� ���� O(n^2)�� �ƴϸ� �����ѵ� �ϴ�.
		ArrayList<Integer> in = new ArrayList<Integer>();
		
		for(int i: input) {
			if(!in.contains(i))
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
		long after = System.currentTimeMillis();
		System.out.println("RUNTIME = " + (after - before) + "ms");
	}
	
}
