package CodingTest;

import java.util.ArrayList;

public class Village {
	
	final static int n = 7;
	final static int[] pop = {1000, 3000, 4000, 1000, 2000, 2000
							, 7000};
	final static int[][] edge = 
		{{1, 2}, {2, 3}, {4, 3}, {4, 5}, {6, 2}, {6, 7}};

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
	
	static int cal(int node, int include) {
		// subSet�� ��� ����Լ��� �ݺ� ȣ���� �ִ���
		// ���ƺ��� ���ؼ� �̹� ���� �κ��� ��ŵ�ϱ� ���� ���� ����.
		// answer �������� ����ص� ������ ����.
		
		// ������ ���� �κ����� Ȯ��.
		int tmp = subSet[node][include];
		if(tmp != 0) 
			return tmp;
			
		// ���� ��带 �����ϴ� ���������� ���.
		if(include == 1) {
//			int answer=0;
			// �ڽ� ������ �鷯���� ���ȣ��.
			for(int i=0; i<tree[node].size(); i++) {
				// �̹� ��尡 ���� �ڽ� ���� �� �� ����(�����̶�)
				tmp += cal(tree[node].get(i), 0);
//				answer += cal(tree[node].get(i), 0);
			}
			// ��갪 �����Ͽ� �ݺ���� ��ŵ.
			subSet[node][include] = tmp + pop[node-1];
//			return  answer + w[node-1];
			// ���� ��尪�� �߰�����.
			return  tmp + pop[node-1];
		}
		// �����带 �������� �ʴ� ���������� ���.
		else {
			int temp=0;
			int m1=0;
			int m2=0;			
			// �ڽĳ����� �鷯���� ���ȣ��.
			for(int i=0; i<tree[node].size(); i++) {
				// �ڽĳ�带 �������� �ʴ� ��������.
				m1 = cal(tree[node].get(i), 0);
				// �ڽĳ�带 �����ϴ� ��������.
				m2 = cal(tree[node].get(i), 1);
				if(m1>m2) {
					// ���� �ڽĳ����� ���ȣ�� ������ �� ū������ ���س���
					temp += m1;
				}
				if(m2>m1) {
					// ���� �ڽĳ����� ���ȣ�� ������ �� ū������ ���س���
					temp += m2;
				}
			}
			// �ݺ�ȣ�� ������ ���� �迭.
			subSet[node][include] = temp;
			return temp;
		}
	}
	
	public static void main(String[] args) {
		// ����Ʈ �迭 �ʱ�ȭ
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n + 1; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edge.length; i++) {
			list[edge[i][0]].add(edge[i][1]);
			list[edge[i][1]].add(edge[i][0]);
		}
		for (int i = 0; i < n + 1; i++) {
			subSet[i][0] = 0;
			subSet[i][1] = 0;
		}
		
		draw(1, 1);
		
		int m1 = cal(1, 1);
		int m2 = cal(1, 0);
		
		if(m1 > m2)
			System.out.println("answer = " + m1);
		else
			System.out.println("answer = " + m2);
		
	}
	
}
