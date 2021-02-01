package D0119;

import java.util.Stack;

public class NGE {
	final static int[] n = {4, 4};
	final static int[][] input = {{3, 5, 2, 7}, {9, 5, 4, 8}};
		
	static void solution(int n, int[] in) {
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			st.add(in[i]);
		}
		for(int i=0; i<n; i++) {
			Stack<?> tmp = (Stack<?>)st.clone();
			nge(tmp, in[i]);
		}
	}
	
	static void nge(Stack<?> st, int n) {
		int tmp;
		int max = -1;
		// �̷��� �����ϴ� ���� ������ ���� �Ϲ����� �뵵�̴�.
		// ������ �̷��� ���ÿ��� pop�ϸ� ���� nge ������� �Ź� ������ ����
		// ����� �־�� �Ѵ�. 
		// �׷��� �������� ������ ���������ؼ� ����ϰų�
		// index�� �̿��� �����ؾ� �Ѵ�.
		while(!st.isEmpty()) {
			tmp = (Integer)st.pop();
			if(tmp==n)
				break;
			if(tmp>n)
				max = tmp;
		}
		System.out.print(max + " ");
	}

	public static void main(String[] args) {
		solution(n[0], input[0]);
	}

	
}
