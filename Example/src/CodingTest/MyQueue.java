package CodingTest;

public class MyQueue<T> {
	
	private Node TOP;
	private int size = 0;
	
	private class Node {
		
		private T t;
		private Node next;
		
		void setT(T t) {
			this.t = t;
		}
		
		void linkNode(Node next) {
			this.next = next;
		}
		
		public T getT() {
			return this.t;
		}
		
		public Node getNext() {
			return this.next;
		}
	}
	
	private void add(T t) {
		Node node = new Node();
		node.setT(t);
		node.linkNode(TOP);
		TOP = node;
		size++;
	}
	
	private T poll() {
		T t;
		if(TOP == null)
			return null;
		t = TOP.getT();
		TOP = TOP.getNext();
		size--;
		return t;
	}
	
	private int size() {
		return this.size;
	}
	
	public static void main(String[] args) {		
		MyQueue<String> mq = new MyQueue<>();
		mq.add("Hello World!!");
		mq.add("U Right!!");
		int size = mq.size();
		System.out.println(size);
		String tmp = mq.poll();
		System.out.println(tmp);
		size = mq.size();
		System.out.println(size);
		tmp = mq.poll();
		System.out.println(tmp);
	}
	
}
