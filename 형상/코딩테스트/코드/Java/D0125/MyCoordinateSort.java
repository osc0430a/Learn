package CodingTest.D0125;


public class MyCoordinateSort {
	static int n = 5;
	static int[][] input = {{3, 4}, {1, 1}, {1, -1}, {2, 2}, {3, 3}};
	
	int[][] heap;	
	int size = 0;
	int cur = 1;
	
	MyCoordinateSort(int n){		
		heap = new int[n+1][2];
	}
	
	public void add(int[] n) {
		heap[cur][0] = n[0];
		heap[cur][1] = n[1];
		
		int cNode = cur;
		size++;
		cur++;
		
		
		while(cNode != 1) {
			int fNode = cNode/2;
			if(heap[fNode][0] > heap[cNode][0]) {
				int[] tmp = heap[fNode];
				heap[fNode] = heap[cNode];
				heap[cNode] = tmp;
				cNode = fNode;
			}
			else if(heap[fNode][0] == heap[cNode][0]) {
				if(heap[fNode][1] > heap[cNode][1]) {
					int[] tmp = heap[fNode];
					heap[fNode] = heap[cNode];
					heap[cNode] = tmp;
				}
				cNode = fNode;
			}
			else
				break;
		}
	}
	
	public int[] pop() {
		int[] top = new int[2];
		top[0] = heap[1][0];
		top[1] = heap[1][1];
		heap[1][0] = heap[size][0];
		heap[1][1] = heap[size][1];
		heap[size][0] = 100001;
		heap[size][1] = 100001;
		int tNode = 1;
		size--;
		
		if(size == 0) {
			return top;
		}
		
		while(tNode*2 <= size) {
			int cNode = tNode*2;
			int[] fNode = heap[cNode];
			int[] sNode = heap[cNode+1];
			
			if(fNode[0] > sNode[0]) 
				cNode = cNode + 1;
			else if(fNode[0] == sNode[0]) {
				if(fNode[1] > sNode[1])
					cNode = cNode + 1;
			}
			
			fNode = heap[tNode];
			sNode = heap[cNode];
			
			if(fNode[0] > sNode[0]) {
				int[] tmp = new int[2];
				tmp[0] = heap[tNode][0];
				tmp[1] = heap[tNode][1];
				heap[tNode][0] = heap[cNode][0];
				heap[tNode][1] = heap[cNode][1];
				heap[cNode][0] = tmp[0];
				heap[cNode][0] = tmp[0];
				tNode = cNode;
			}
			else if(fNode[0] == sNode[0]) {
				if(fNode[1] > sNode[1]) {
					int[] tmp = new int[2];
					tmp[0] = heap[tNode][0];
					tmp[1] = heap[tNode][1];
					heap[tNode][0] = heap[cNode][0];
					heap[tNode][1] = heap[cNode][1];
					heap[cNode][0] = tmp[0];
					heap[cNode][0] = tmp[0];
				}
				tNode = cNode;
			}
			else
				break;
		}
		
		return top;
	}
	
	public int[] get(int i) {
		return heap[i];
	}
	
	public void printHeap() {
		System.out.print("HEAP = { ");
		for(int i=1; i<n+1; i++) {			
				System.out.print("[" + heap[i][0] + ", " 
			+ heap[i][1] + "] ");
		}
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		MyCoordinateSort hp = new MyCoordinateSort(n);
		
		System.out.print("INPUT = { ");
		for(int[] i:input) {
			System.out.print("[" + i[0] + ", " + i[1] + "] ");
		}
		System.out.println("}");
		
		for(int i=0; i<n; i++) {
			hp.add(input[i]);
		}
		
		hp.printHeap();
		
		System.out.print("ANSWER = { ");
		for(int i=0; i<n; i++) {
			int[] tmp = hp.pop();
			System.out.print("[" + tmp[0] + ", " + tmp[1] + "] ");
		}
		System.out.println("}");		
	}
}
