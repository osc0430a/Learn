package CodingTest;

import java.util.ArrayList;

public class Catch_Me {
	
	final static String input = "11 2";
	
	static int solution(String c_location, String b_location) {
		int c = Integer.parseInt(c_location);
		int b = Integer.parseInt(b_location);
		ArrayList<Integer> tree = new ArrayList<Integer>();
		tree.add(0);
		tree.add(b);
		int cnt = 1;
		
		// 1 / 2 3 4 / 5 6 7 8 9 10 11 12 13 / 14 15 16 17 18 19 
		// 20 21 22 23 24 25 26 27 28 29 30 .. 40
		
		// 아이디어 : 1번째에는 그냥 3개 추가.
		// 2번쨰 바퀴 이후에는 3^n - 3^n/2 부터 3^n + 3^n/2 까지가 부모노드가
		// 된다. 각 부모 찾아가면서 자식노드 생성.
		while(true) {
			c += cnt;
			System.out.println("coni = " + c);
			System.out.println("brwon = " + tree);
//			System.out.println(cnt);
			// 코니가 범위 벗어났으면 -1
			if(c > 200000) {
				cnt = -1;
				break;
			}
			// 1번째 자식노드 3개 추가.
			if(cnt == 1) {
				tree.add(tree.get(1) - 1);
				tree.add(tree.get(1) + 1);
				tree.add(tree.get(1) * 2);
				cnt++;
				continue;
			}
			
			// n = 3^cnt, m = 3^cnt/2
			int n = 1;
			int m = 0;
			
			for(int i=1; i<cnt; i++) {
				n *= 3;
			}
			m = n/2;			
			
			// 부모노드 찾아가면서 자식노드 생성. 결과값이 나오면 저장하지 않고 
			// 그냥 return.
			for(int i=n-m; i<=n+m; i++) {
				if(tree.get(i) - 1 == c) {
					System.out.println("Catch at " + c);
					return cnt;
				}
				tree.add(tree.get(i) - 1);
				if(tree.get(i) + 1 == c) {
					System.out.println("Catch at " + c);
					return cnt;
				}
				tree.add(tree.get(i) + 1);
				if(tree.get(i) * 2 == c) {
					System.out.println("Catch at " + c);
					return cnt;
				}
				tree.add(tree.get(i) * 2);				
			}
			cnt++;			
		}
		
		return cnt;		
	}
	
	public static void main(String[] args) {		
		// 트리를 활용해서 문제를 풀어본다.
		// 트리를 활용하면 [1]위치가 시작지점.
		// 3n - 1 에 B - 1 3n 에 B + 1 3n + 1 에 2 * B 저장.
		// 위와같이 범위안의 크기 트리를 만들면서 코니 위치와 매칭.
		// 재귀함수로도 위의 문제를 해결할 수 있으나 가지수가 많아지면.
		// 메모리 스택 Overflow가 발생할 수 있어 트리가 더 좋아보인다.
		String[] location = input.split(" ");
		String c_location = location[0];
		String b_location = location[1];
		int answer = 0;
		
		answer = solution(c_location, b_location);
		System.out.println("answer = " + answer);
	}
	
}
