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
		// �⺻ ���̵��� ���ÿ� �ϳ��� �׾ư��� ���
		// �� �װ� �����鼭 Ȯ���ϸ� Ž������ �ñ� ������
		// �����鼭 �������ϴ� ��ȣ�� ) �϶� ���� �ֻ����
		// ��ȣ�� ( ��� �ֻ���� ���� pop�ϰ� �ݺ�����
		// ���Ͱ��� ������� ������ ä��� ���� ���ÿ� ���� �����ִٸ�
		// ��ȣ�� ���� �̷��� ���� ���̴�.
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
