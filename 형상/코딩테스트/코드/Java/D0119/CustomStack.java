package D0119;

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

	final static int n = 7;
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
					cs.pop();
					break;
				case "top":
					cs.top();
					break;
				case "size":
					cs.size();
					break;
				case "empty":
					cs.empty();
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
	
	void pop() {
		if(top != null) {
			System.out.println(top.getN());
			top = top.getPre();
			size--;
		}
		else {
			System.out.println("-1");
		}
	}
	
	void size() {
		System.out.println(size);
	}
	
	void empty() {
		if(top==null) 
			System.out.println("1");		
		else
			System.out.println("0");
	}
	
	void top() {
		if(top!=null)
			System.out.println(top.getN());
		else
			System.out.println("-1");
	}
	
	public static void main(String[] args) {
		for(int i=0; i<n; i++) {
			solution(input2[i]);
		}		
	}
	
}
