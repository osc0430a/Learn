package D0125;

import java.util.ArrayList;
import java.util.Collections;

public class MySort2 {

	final static int[] input = {5, 5, 4, 3, 2, 1};
	
	public static void main(String[] args) {
		// �������� ����ص� ���� O(n^2)�� �ƴϸ� �����ѵ� �ϴ�.
		ArrayList<Integer> in = new ArrayList<Integer>();
		
		for(int i: input) {
			if(!in.contains(i))
				in.add(i);
		}
		
		for(int i: input) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Collections.sort(in);
		
		for(int i: in) {
			System.out.print(i + " ");
		}
	}
	
}
