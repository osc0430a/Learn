package CodingTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{	
	int U;
	int parent;
	ArrayList<Integer> childs = new ArrayList<Integer>();
	
	Node(int U){
		this.U = U;
		this.parent = -1;
	}
}

public class Tree {
	
	final static int[][] input = {{9, 5, 3}, {1, 3}
								, {4, 3}, {5, 4}
								, {5, 6}, {6, 7}
								, {2, 3}, {9, 6}
								, {6, 8}, {5}, {4}, {8}};

	static void cal_subNode(int U, ArrayList<Node> graph) {
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		Queue<Integer> tmp = new LinkedList<Integer>();
		// tmp�� ����Ʈ�� ��Ʈ�� �ڽ� ��� �Ҵ�.
		cnt.add(graph.get(U-1).U);
		for(int i=0; i<graph.get(U-1).childs.size(); i++) {
			if(graph.get(U-1).childs.get(i) 
					== graph.get(U-1).parent)
				continue;
			tmp.add(graph.get(U-1).childs.get(i));
		}
		// tmp���� ����� ���� ������
		while(tmp.size() > 0) {
			for(int i=0; i<tmp.size(); i++) {
				int child = tmp.poll();
				System.out.println(child);
				if(cnt.indexOf(child) == -1) {
					cnt.add(child);
					for(int j=0; j<graph.get(child).childs.size();
							j++) {
						if(graph.get(child).childs.get(j) 
								== graph.get(child).parent)
							continue;
						tmp.add(graph.get(child).childs.get(j));
					}
				}
				System.out.println("tmp = " + tmp);
				System.out.println("cnt = " + cnt);
			}
		}
		System.out.println("answer = " + cnt.size());
	}
	
	static ArrayList<Node> draw(int R, ArrayList<Node> graph){
		for(int i=0; i<graph.get(R).childs.size(); i++) {
			int tmp = graph.get(R).childs.get(i);
			if(graph.get(tmp).parent == -1) {
				graph.get(tmp).parent = R;
				graph = draw(tmp, graph);
			}
		}
		
		return graph;
	}
	
	public static void main(String[] args) {
		// �ϴ� �׷����� �׸��� Ž���� ���鼭 ������ ī��Ʈ�Ѵ�.
		int N = input[0][0];
		int R = input[0][1];
		int Q = input[0][2];
		int[] U = new int[Q]; 
		
		// U �� �Ҵ�.
		for(int i=N; i<input.length; i++) {
			U[i-N] = input[i][0];
		}		
		// Ʈ�� ��� �ʱ�ȭ.
		ArrayList<Node> graph = new ArrayList<Node>();
		for(int i=0; i<N; i++) {
			Node tmp = new Node(i);
			graph.add(tmp);
		}
		// Ʈ�� �׸���
		for(int i=1; i<N; i++) {
			//
			graph.get(input[i][0]-1).childs.add(input[i][1]-1);
			graph.get(input[i][1]-1).childs.add(input[i][0]-1);
		}
		// �θ��� ����
		graph = draw(R-1, graph);
		// Ʈ�� Ž���ؼ� ���� ���
		for(int i=0; i<U.length; i++) {
			cal_subNode(U[i], graph);
		}		
	}
	
	
}
