package D0119;

import java.util.ArrayList;
import java.util.Stack;

public class StackSequence {
	final static int[] n = {8, 5};
	final static int[][] input = {{4, 3, 6, 8, 7, 5, 2, 1}
							, {5, 1, 2, 5, 3}};	
	
	static void solution(int n, int[] in) {
		// 수열의 현재 수가 더 클 때.
		//	수열의 수와 같을 때까지 스텍에 수를 하나씩 집어넣는다.
		// 수열의 현재 수가 더 작을 때.
		//	스택에서 맨 위의 것을 꺼내 수열의 수와 비교한다.
		//		같으면 반복 진행.
		//		다르면 같은 수열을 만들 수 없는 경우이므로 NO출력 후 종료
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
