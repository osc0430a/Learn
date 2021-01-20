package CodingTest;

import java.util.ArrayList;

public class SocialNet {
	
	final static int n = 8;
	final static int[][] edge = {{1, 2}, {1, 3}, {1, 4}, {2, 5}
							, {2, 6}, {4, 7}, {4, 8}};
	
	// ������踦 ������ ����Ʈ
	static ArrayList<Integer>[] list = new ArrayList[n+1];
	// Ʈ��
	static ArrayList<Integer>[] tree = new ArrayList[n+1];
	// �ݺ������� ���� ���� �迭
	static int[][] subSet = new int[n+1][2];

	static void draw(int p, int n){
		// Ʈ���� �׸��� �κ�.
		for(int i=0; i<list[n].size(); i++) {
			if(list[n].get(i) == p) {
				continue;
			}
			else {
				tree[n].add(list[n].get(i));
				draw(n, list[n].get(i));
			}
		}
	}
	
	static int cal(int node, int early) {
		// Ʈ���� ������ ������ �� ����͸� �ڽ��� �󸮾��� ����
		// ������ �󸮾���Ͱ� �ƴϸ� �ڽ��� ������ �󸮾����
		
		// �ݺ� ������ ���� ���� �κ�.
		if(subSet[node][early] != -1)
			return subSet[node][early];
		
		// �� ������� ��� �ڽ��� �� ����Ϳ��� �ǰ� �ƴϾ �ȴ�.
		if(early == 1) {
			int tmp = 0;
			int m1 = 0;
			int m2 = 0;
			
			// �ڽ� ��尡 �󸮾������ ��� �ƴҰ�� ���� �ּҰ��� ����
			for(int i=0; i<tree[node].size(); i++) {
				m1 = cal(tree[node].get(i), 0);
				m2 = cal(tree[node].get(i), 1);
				
				if(m1<m2) 
					tmp += m1;
				else 
					tmp += m2;
			}
			// ���ΰ� ���ؼ� �ݺ����� ���� ����.
			subSet[node][early] = tmp + 1;
			return tmp + 1;
		}
		// �� ����Ͱ� �ƴҰ�� �ڽ��� ������ �� �����.
		else {
			int m1 = 0;
			// �ڽ� ��尡 �󸮾���Ͱ� �ƴ� ��� �� ����.
			for(int i=0; i<tree[node].size(); i++) {
				m1 += cal(tree[node].get(i), 1);
			}
			// ���� �ȵ��� ���� �� ���� ����.
			subSet[node][early] = m1;
			return m1;
		}
	}
	
	public static void main(String[] args) {
		// ����Ʈ �迭 �ʱ�ȭ
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<n+1; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<edge.length; i++) {
			list[edge[i][0]].add(edge[i][1]);
			list[edge[i][1]].add(edge[i][0]);
		}
		for(int i=0; i<n+1; i++) {
			subSet[i][0] = -1;
			subSet[i][1] = -1;
		}
		
		draw(1, 1);
		
		int m1 = cal(1, 1);
		int m2 = cal(1, 0);
		
		if(m1<m2)
			System.out.println("answer = " + m1);
		else
			System.out.println("answer = " + m1);
		
	}
	
}
