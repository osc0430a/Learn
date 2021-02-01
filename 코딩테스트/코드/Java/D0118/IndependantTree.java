package D0118;

import java.util.ArrayList;

public class IndependantTree {

	// �������� �־��� �Է�.
	final static int n = 7;
	final static int[] w = {10, 30, 40, 10, 20, 20, 70};
	final static int[][] edge = 
		{{1, 2}, {2, 3}, {4, 3}, {4, 5}, {6, 2}, {6, 7}};
	
	// Ʈ���� ���� ����(Edge)�� ���� ����Ʈ
	static ArrayList<Integer>[] childs;
	// Ʈ��
	static ArrayList<Integer>[] tree;
	// ��� ȣ��� ������ �ִ��� ���̱� ���� �迭 �Ʒ� ������ ����.
	static int[][] subSet = new int[n+1][2];
	// �������� ����� ���� �迭
	static int[] check = new int[n+1];
	
	static void draw(int p, int n){
		// Ʈ���� �׸��� �κ�.
		for(int i=0; i<childs[n].size(); i++) {
			if(childs[n].get(i) == p) {
				continue;
			}
			else {
				tree[n].add(childs[n].get(i));
				draw(n, childs[n].get(i));
			}
		}
	}
	
	static int cal(int node, int include) {
		// ������ �����ϴ�. subSet�� ��� ����Լ��� �ݺ� ȣ���� �ִ���
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
			subSet[node][include] = tmp + w[node-1];
//			return  answer + w[node-1];
			// ���� ��尪�� �߰�����.
			return  tmp + w[node-1];
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
					// �������� ����� ���� üũ�迭
					check[tree[node].get(i)] = 0;
				}
				if(m2>m1) {
					// ���� �ڽĳ����� ���ȣ�� ������ �� ū������ ���س���
					temp += m2;
					// �������� ����� ���� üũ�迭
					check[tree[node].get(i)] = 1;
				}
			}
			// �ݺ�ȣ�� ������ ���� �迭.
			subSet[node][include] = temp;
			return temp;
		}
	}

	private static void print(int m1, int m2
			, ArrayList<Integer> answer) {
		// ���� ���Ŀ� ���� ���.
		
		if(m1 > m2) {
			System.out.println(m1);
			System.out.println(answer);
		}
		else {
			System.out.println(m2);
			System.out.println(answer);
		}
		
	}
	
	public static void main(String[] args) {
		
		tree = new ArrayList[n+1];
		childs = new ArrayList[n+1];

		// ����Ʈ�� �ʱ�ȭ
		for(int i=0; i<n+1; i++) {
			tree[i] = new ArrayList<Integer>();
		}		
		for(int i=0; i<n+1; i++) {
			childs[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<n+1; i++) {
			subSet[i][0] = 0;
			subSet[i][1] = 0;
		}
		for(int i=0; i<n+1; i++) {
			check[i] = 0;
		}
		// ����� ��� ����Ʈ�� ����.
		for(int i=0; i<edge.length; i++) {
			childs[edge[i][0]].add(edge[i][1]);
			childs[edge[i][1]].add(edge[i][0]);
		}
		
		// Ʈ�� �׸���.
		draw(1,1);
		
		// �������� �ִ� ũ�� ���.
		int m1 = cal(1, 0);
		int m2 = cal(1, 1);
		if(m2>m1)
			check[1] = 1;
		
		// ���� �迭 ����.
		ArrayList<Integer> answer = new ArrayList<Integer>();		
		for(int i=0; i<n+1; i++) {
			if(check[i] == 1)
				answer.add(i);
		}
		// ���� ���
		print(m1, m2, answer);
		
	}
	
}
