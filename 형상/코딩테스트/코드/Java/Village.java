package CodingTest;

import java.util.ArrayList;

public class Village {
	
	final static int n = 7;
	final static int[] pop = {1000, 3000, 4000, 1000, 2000, 2000
							, 7000};
	final static int[][] edge = 
		{{1, 2}, {2, 3}, {4, 3}, {4, 5}, {6, 2}, {6, 7}};

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
	
	static int cal(int node, int include) {
		// subSet의 경우 재귀함수의 반복 호출을 최대한
		// 막아보기 위해서 이미 계산된 부분은 스킵하기 위해 만든 집합.
		// answer 버전으로 사용해도 문제가 없다.
		
		// 이전에 계산된 부분인지 확인.
		int tmp = subSet[node][include];
		if(tmp != 0) 
			return tmp;
			
		// 현재 노드를 포함하는 독립집합인 경우.
		if(include == 1) {
//			int answer=0;
			// 자식 노드들을 들러가며 재귀호출.
			for(int i=0; i<tree[node].size(); i++) {
				// 이번 노드가 들어가면 자식 노드는 들어갈 수 없음(독립이라)
				tmp += cal(tree[node].get(i), 0);
//				answer += cal(tree[node].get(i), 0);
			}
			// 계산값 저장하여 반복계산 스킵.
			subSet[node][include] = tmp + pop[node-1];
//			return  answer + w[node-1];
			// 현재 노드값을 추가해줌.
			return  tmp + pop[node-1];
		}
		// 현재노드를 포함하지 않는 독립집합인 경우.
		else {
			int temp=0;
			int m1=0;
			int m2=0;			
			// 자식노드들을 들러가며 재귀호출.
			for(int i=0; i<tree[node].size(); i++) {
				// 자식노드를 포함하지 않는 독립집합.
				m1 = cal(tree[node].get(i), 0);
				// 자식노드를 포함하는 독립집합.
				m2 = cal(tree[node].get(i), 1);
				if(m1>m2) {
					// 여러 자식노드들의 재귀호출 값들중 더 큰값들을 더해놓음
					temp += m1;
				}
				if(m2>m1) {
					// 여러 자식노드들의 재귀호출 값들중 더 큰값들을 더해놓음
					temp += m2;
				}
			}
			// 반복호출 방지를 위한 배열.
			subSet[node][include] = temp;
			return temp;
		}
	}
	
	public static void main(String[] args) {
		// 리스트 배열 초기화
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
