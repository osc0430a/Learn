package CodingTest;

import java.util.ArrayList;
import java.util.Stack;

public class StackSequence {
	final static int[] n = {8, 5};
	final static int[][] input = {{4, 3, 6, 8, 7, 5, 2, 1}
							, {5, 1, 2, 5, 3}};	
	
	static void solution(int n, int[] in) {
		int cnt = 1;
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<String> answer = new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			int tmp = in[i];
			int match = 0;
			
			while(cnt <= tmp) {
				st.push(cnt);
				answer.add("+");
				cnt++;
			}
			System.out.println(st);
			if(!st.empty()) {
				match = st.pop();
				if(match != tmp) {
					System.out.println("NO");
					return;
				}
				else
					answer.add("-");
			}
		}
		for (String s : answer) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		solution(n[1], input[1]);
	}
	
}
