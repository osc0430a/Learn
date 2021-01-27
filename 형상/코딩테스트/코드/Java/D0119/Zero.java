package D0119;

import java.util.Stack;

public class Zero {
	final static int[] n = {4, 10};
	final static int[][] input = {{3, 0, 4, 0}
				, {1, 3, 5, 4, 0, 0, 7, 0, 0 ,6}};
	
	static Stack<Integer> solution(int n, int[] in) {
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i=0; i<n; i++) {
			if(in[i]==0) {
				st.pop();
			}
			else {
				st.push(in[i]);
			}
		}
		
		return st;
	}
	
	static void print(Stack<Integer> st) {
		int answer = 0;
		while(!st.empty()) {
			answer += st.pop();
		}		
		System.err.println("answer = " + answer);
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st = solution(n[0], input[0]);
		print(st);
	}

	
}
