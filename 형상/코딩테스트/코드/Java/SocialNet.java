package CodingTest;

import java.util.ArrayList;

public class SocialNet {
	
	final static int n = 8;
	final static int[][] edge = {{1, 2}, {1, 3}, {1, 4}, {2, 5}
							, {2, 6}, {4, 7}, {4, 8}};
	
	// 연결관계를 저장한 리스트
	static ArrayList<Integer>[] list = new ArrayList[n+1];
	// 트리
	static ArrayList<Integer>[] tree = new ArrayList[n+1];
	// 반복수행을 막기 위한 배열
	static int[][] subSet = new int[n+1][2];

	static void draw(int p, int n){
		// 트리를 그리는 부분.
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
		// 트리기 때문에 본인이 얼리 어댑터면 자식은 얼리어댑더 자유
		// 본인이 얼리어댑터가 아니면 자식은 무조건 얼리어댑터
		
		// 반복 수행을 막기 위한 부분.
		if(subSet[node][early] != -1)
			return subSet[node][early];
		
		// 얼리 어답터일 경우 자식은 얼리 어답터여도 되고 아니어도 된다.
		if(early == 1) {
			int tmp = 0;
			int m1 = 0;
			int m2 = 0;
			
			// 자식 노드가 얼리어답터일 경우 아닐경우 나눠 최소값들 더함
			for(int i=0; i<tree[node].size(); i++) {
				m1 = cal(tree[node].get(i), 0);
				m2 = cal(tree[node].get(i), 1);
				
				if(m1<m2) 
					tmp += m1;
				else 
					tmp += m2;
			}
			// 본인값 더해서 반복수행 막고 리턴.
			subSet[node][early] = tmp + 1;
			return tmp + 1;
		}
		// 얼리 어답터가 아닐경우 자식은 무조건 얼리 어댑터.
		else {
			int m1 = 0;
			// 자식 노드가 얼리어답터가 아닐 경우 값 더함.
			for(int i=0; i<tree[node].size(); i++) {
				m1 += cal(tree[node].get(i), 1);
			}
			// 본인 안들어가니 본인 값 빼고 저장.
			subSet[node][early] = m1;
			return m1;
		}
	}
	
	public static void main(String[] args) {
		// 리스트 배열 초기화
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
