package D0118;

import java.util.ArrayList;

public class IndependantTree {

	// 문제에서 주어진 입력.
	final static int n = 7;
	final static int[] w = {10, 30, 40, 10, 20, 20, 70};
	final static int[][] edge = 
		{{1, 2}, {2, 3}, {4, 3}, {4, 5}, {6, 2}, {6, 7}};
	
	// 트리의 연결 정보(Edge)를 담은 리스트
	static ArrayList<Integer>[] childs;
	// 트리
	static ArrayList<Integer>[] tree;
	// 재귀 호출시 연산을 최대한 줄이기 위한 배열 아래 사용법이 나옴.
	static int[][] subSet = new int[n+1][2];
	// 독립집합 출력을 위한 배열
	static int[] check = new int[n+1];
	
	static void draw(int p, int n){
		// 트리를 그리는 부분.
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
		// 개념이 복잡하다. subSet의 경우 재귀함수의 반복 호출을 최대한
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
			subSet[node][include] = tmp + w[node-1];
//			return  answer + w[node-1];
			// 현재 노드값을 추가해줌.
			return  tmp + w[node-1];
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
					// 독립집합 출력을 위한 체크배열
					check[tree[node].get(i)] = 0;
				}
				if(m2>m1) {
					// 여러 자식노드들의 재귀호출 값들중 더 큰값들을 더해놓음
					temp += m2;
					// 독립집합 출력을 위한 체크배열
					check[tree[node].get(i)] = 1;
				}
			}
			// 반복호출 방지를 위한 배열.
			subSet[node][include] = temp;
			return temp;
		}
	}

	private static void print(int m1, int m2
			, ArrayList<Integer> answer) {
		// 정답 형식에 맞춰 출력.
		
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

		// 리스트들 초기화
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
		// 연결된 노드 리스트에 정리.
		for(int i=0; i<edge.length; i++) {
			childs[edge[i][0]].add(edge[i][1]);
			childs[edge[i][1]].add(edge[i][0]);
		}
		
		// 트리 그리기.
		draw(1,1);
		
		// 독립집합 최대 크기 계산.
		int m1 = cal(1, 0);
		int m2 = cal(1, 1);
		if(m2>m1)
			check[1] = 1;
		
		// 속한 배열 정리.
		ArrayList<Integer> answer = new ArrayList<Integer>();		
		for(int i=0; i<n+1; i++) {
			if(check[i] == 1)
				answer.add(i);
		}
		// 정답 출력
		print(m1, m2, answer);
		
	}
	
}
