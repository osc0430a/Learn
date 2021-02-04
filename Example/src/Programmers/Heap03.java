package Programmers;

public class Heap03 {	
	private Node top = null;
	private Node bottom = null;
	
	class Node{
		private int v;
		private Node next_t;
		private Node next_b;
		
		Node(int v){
			this.v = v;
		}
	
		private int getV() {
			return this.v;
		}
		
		private Node getNextTop() {
			return next_t;
		}
		
		private Node getNextBottom() {
			return next_b;
		}
		
		private void setNextTop(Node top) {
			this.next_t = top;
		}
		
		private void setNextBottom(Node bottom) {
			this.next_b = bottom;
		}
	}
	
	private void push(int v) {
		Node n = new Node(v);
		
		if(top == null) {
			top = n;
			bottom = n;
			return;
		}
		
		Node tmp = top;
		
		while (tmp != null) {
			if(tmp.getV() <= v) {
				top.setNextBottom(n);
				n.setNextTop(top);
				top = n;
				return;
			}
			else if(tmp.getNextTop() == null) {
				top.setNextTop(n);
				n.setNextBottom(top);
				bottom = n;
				return;
			}
			else
				tmp = tmp.getNextTop();
		}		
	}
	
	private int popTop() {
		if(top == null)
			return 0;
		int pop = top.getV();
		if(top.getNextTop() != null) {
			top = top.getNextTop();
			top.setNextBottom(null);
			if(top == null)
				bottom = null;
		}
		else {
			top = null;
			bottom = null;
		}
		
		return pop;
	}
	
	private int popBottom() {
		if(bottom == null)
			return 0;
		int pop = bottom.getV();
		if(bottom.getNextBottom() != null) {
			bottom = bottom.getNextBottom();
			bottom.setNextTop(null);
			if(bottom == null)
				top = null;
		}
		else {
			top = null;
			bottom = null;
		}
		
		return pop;
	}
	
	private Node getTop() {
		return top;
	}

	private Node getBottom() {
		return bottom;
	}
	
	private int getTopV() {
		return top.getV();
	}
	
	private int getBottomV() {
		return bottom.getV();
	}
	
	public static void main(String[] args) {
		String[] input1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		String[] input2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		Heap03 h = new Heap03();
		int answer[] = new int[2];
		
		for(int i=0; i<input2.length; i++) {
			String[] oper = input2[i].split(" ");
			
			if(oper[0].equals("I")) {
				h.push(Integer.parseInt(oper[1]));
			}			
			else if(oper[1].charAt(0) == '-') {
				h.popBottom();
			}
			else {
				h.popTop();
			}
			
			Node tmp = h.getTop();
			System.out.println();
			
			System.out.println("TOP");
			while(tmp != null) {
				System.out.print(tmp.getV() + " ");
				tmp = tmp.getNextTop();
			}
			System.out.println();
			System.out.println("BOTTOM");
			tmp = h.getBottom();
			while(tmp != null) {
				System.out.print(tmp.getV() + " ");
				tmp = tmp.getNextBottom();
			}
			System.out.println();
		}

		answer[0] = h.getTopV();
		answer[1] = h.getBottomV();
		
	}

}
