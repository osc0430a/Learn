package D0125;

import java.util.Random;

public class MyHeap {

	int[] heap;
	int size = 0;
	int cur = 1;
	
	MyHeap(int n){		
		heap = new int[n+1];
	}
	
	public void add(int n) {
		heap[cur] = n;
		int cNode = cur;
		size++;
		cur++;
		
		while(cNode != 1) {
			int fNode = cNode/2;
			if(heap[fNode] > heap[cNode]) {
				int tmp = heap[fNode];
				heap[fNode] = heap[cNode];
				heap[cNode] = tmp;
				cNode = fNode;
			}
			else
				break;
		}
	}
	
	public int pop() {
		int top = heap[1];
		heap[1] = heap[size];
		heap[size] = 1001;
		size--;
		int tNode = 1;
		while(tNode*2 <= size) {
			int cNode;
			if(tNode*2+1 > size)
				cNode = tNode*2;
			else {
				cNode = (heap[tNode*2] < heap[tNode*2+1])? 
					tNode*2:tNode*2+1;
			}
			if(heap[cNode] < heap[tNode]) {
				int tmp = heap[cNode];
				heap[cNode] = heap[tNode];
				heap[tNode] = tmp;
				tNode = cNode;
			}
			else
				break;
		}
		
		return top;
	}
	
	public int get(int i) {
		return heap[i];
	}
	
	public void printHeap() {
		System.out.print("[");
		for(int i=1; i<size+1; i++) {
			if(i == size) {
				System.out.print(heap[i]);
				break;
			}
			System.out.print(heap[i] + " ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		int[] input1 = {5, 2, 3, 4, 1};
		int[] input2 = {5, 4, 3, 2, 1};
		
		int[] input = input2;
		int[] test = new int[10000000];
		
		for(int i=0; i<test.length; i++) {
			test[i] = new Random().nextInt();
		}
		
		MyHeap hp = new MyHeap(10000000);
		for(int i=0; i<test.length; i++) {
			hp.add(test[i]);
		}
		for(int i=0; i<test.length; i++) {
			test[i] = hp.pop();
		}
//		for(int i:test) {
//			System.out.print(i + " ");
//		}
		long after = System.currentTimeMillis();
		System.out.println("MyHeapSort");
		System.out.println("Run Time = " + (after - before) + "ms");
	}
	
}
