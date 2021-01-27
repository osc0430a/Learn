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
		// 이렇게 구현하는 것이 스택의 가장 일반적인 용도이다.
		// 하지만 이렇게 스택에서 pop하면 이후 nge 계산전에 매번 스택을 새로
		// 만들어 주어야 한다. 
		// 그렇지 않으러면 스택을 깊은복사해서 사용하거나
		// index를 이용해 접근해야 한다.
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
