package CodingTest.D0119;

class CStack{
	int n;
	CStack pre;
	
	CStack(int n){
		this.n = n;
	}
	
	void link(CStack pre) {
		this.pre = pre;
	}
	
	int getN() {
		return this.n;
	}
	
	CStack getPre() {
		return pre;
	}	
}

public class CustomStack {

	final static int[] n = {14, 7};
	final static String[] input1 = {"push 1", "push 2"
			, "top", "size", "empty", "pop", "pop"
			, "pop", "size", "empty", "pop", "push 3"
			, "empty", "top"};	
	final static String[] input2 = {"pop", "top"
			, "push 123", "top", "pop", "top", "pop"};
	
	// 각 함수에 매번 top과 size인스턴트를 넣어주는 불편함을 피하기 위해서
	// static으로 선언.
	static CStack top;
	static int size = 0;
	
	static void solution(String in) {
		String[] s_in = in.split(" ");
		CustomStack cs = new CustomStack();
		
		if(s_in.length > 1) {
			cs.push(Integer.parseInt(s_in[1]));
		}
		else {
			switch (s_in[0]) {
				case "pop":
					System.out.println("POP = " + cs.pop());
					break;
				case "top":
					System.out.println("TOP = " + cs.top());
					break;
				case "size":
					System.out.println("SIZE = " + cs.size());
					break;
				case "empty":
					System.out.println("EMPTY = " + cs.empty());
					break;
			}
		}
	}
	
	void push(int n) {
		CStack now = new CStack(n);
		if(top!=null)
			now.link(top);
		top = now;
		size++;
	}
	
	int pop() {
		if(top != null) {
			int val = top.getN();
			top = top.getPre();
			size--;
			return val;
		}
		else {
			return -1;
		}
	}
	
	int size() {
		return size;
	}
	
	int empty() {
		if(top==null) 
			return 1;		
		else
			return 0;
	}
	
	int top() {
		if(top!=null)
			return top.getN();
		else
			return -1;
	}
	
	public static void main(String[] args) {
		for(int i=0; i<n[1]; i++) {
			solution(input2[i]);
		}		
	}
	
}
