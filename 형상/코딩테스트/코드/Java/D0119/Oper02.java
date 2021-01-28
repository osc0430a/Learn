package CodingTest.D0119;

import java.util.Stack;

public class Oper02 {
	final static String[] input = {
		"So When I die (the [first] I will see in "
		+ "(heaven) is a score list)."
		,"[ first in ] ( first out )."
		,"Half Moon tonight (At least it is better "
		+"than no Moon at all]."
		,"A rope may form )( a trail in a maze."
		,"Help( I[m being held prisoner in a "
		+"fortune cookie factory)]."
		,"([ (([( [ ] ) ( ) (( ))] )) ])."
		," ."
		,"."
	};
	
	static void solution(String in) {
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0; i<in.length(); i++) {
			char top = '\\';
			char tmp = in.charAt(i);
			if(!st.empty())
				top = st.pop();
			switch(tmp) {
				case '(':
					if(top != '\\')
						st.push(top);
					st.push(tmp);
					break;
				case ')':
					if(top == '(')
						continue;
				case '[':
					if(top != '\\')
						st.push(top);
					st.push(tmp);
					break;
				case ']':
					if(top == '[')
						continue;
				default:
					if(top!='\\')
						st.push(top);
			}
		}
		System.out.println(st);		
		
		if(st.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static void main(String[] args) {
		for(int i=0; i<input.length; i++) {
			if(input[i].length() == 1)
				continue;
			solution(input[i]);
		}
	}
}
