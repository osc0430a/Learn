package CodingTest.D0119;

import java.util.Stack;

public class Oper01 {
	final static int[] n = {6, 3};
	final static String[][] input = {{"(())())"
		, "(((()())()", "(()())((()))"
		, "((()()(()))(((())))()", "()()()()(()()())()"
		, "(()((())()("}
		, {"((", "))", "())(()"}};
	
	static void solution(int n, String[] in){
		// 기본 아이디어는 스택에 하나씩 쌓아가는 방식
		// 다 쌓고 꺼내면서 확인하면 탐색수가 늘기 때문에
		// 쌓으면서 넣으려하는 괄호가 ) 일때 스택 최상단의
		// 괄호가 ( 라면 최상단의 것을 pop하고 반복진행
		// 위와같은 방법으로 스택을 채우고 끝에 스택에 값이 남아있다면
		// 괄호는 쌍을 이루지 못한 것이다.
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<n; i++) {
			System.out.println(in[i]);
			for(int j=0; j<in[i].length(); j++) {
				char tmp = in[i].charAt(j);
				char top = 'N';
				if(st.empty()) {
					st.push(tmp);
					continue;
				}
				top = st.pop();
				if(top == '(' && tmp == ')') 
					continue;
				st.push(top);
				st.push(tmp);
			}
			System.out.println(st);
			if(st.empty())
				System.out.println("YES");
			else
				System.out.println("NO");
			st.clear();
		}
		
	}
	
	public static void main(String[] args) {		
		solution(n[1], input[1]);
	}
	
}
