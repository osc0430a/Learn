package CodingTest.D0125;

public class MyLengthSort {
	String[] heap;
	int size = 0;
	
	class Node{
		String word;
		int length;
		
		Node(String word, int length, int n){
			this.word = word;
			this.length = length;
			heap = new String[n];
		}
	}
	
	public void add(String word) {
		int length = word.length();
		size++;
		int cNode = size;
		heap[cNode] = word;
		
		while(cNode != 1) {
			int fNode = cNode/2;
			if(heap[fNode].length() > length) {
				String tmp = heap[fNode];
				heap[fNode] = heap[cNode];
				heap[cNode] = tmp;
				cNode = fNode;
			}
			else if(heap[fNode].length() == length) {
				if(heap[fNode].compareTo(word) == 1) {
					String tmp = heap[fNode];
					heap[fNode] = heap[cNode];
					heap[cNode] = tmp;
				}
				cNode = fNode;
			}
			else
				break;
		}
	}

	public String pop() {
		String top = "";
		top = heap[1];
		heap[1] = heap[size];
		heap[size] = "";
		int tNode = 1;
		size--;
		
		if(size == 0) {
			return top;
		}
		
		while(tNode*2 <= size) {
			int cNode = tNode*2;
			String fNode = heap[cNode];
			String sNode = "";
			if(cNode+1 <= size)
				sNode = heap[cNode+1];
			
			if(fNode.length() > sNode.length()) 
				cNode = cNode + 1;
			else if(fNode.length() == sNode.length()) {
				if(fNode.length() > sNode.length())
					cNode = cNode + 1;
			}
			
			fNode = heap[tNode];
			sNode = heap[cNode];
			
			if(fNode.length() > sNode.length()) {
				String tmp = "";
				tmp = heap[tNode];
				heap[tNode] = heap[cNode];
				heap[cNode] = tmp;
				tNode = cNode;
			}
			else if(fNode.length() == sNode.length()) {
				if(fNode.compareTo(sNode) == 1) {
					String tmp = "";
					tmp = heap[tNode];
					heap[tNode] = heap[cNode];
					heap[cNode] = tmp;
				}
				tNode = cNode;
			}
			else
				break;
		}
		
		return top;
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
