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
		
		// ���̵�� : 1��°���� �׳� 3�� �߰�.
		// 2���� ���� ���Ŀ��� 3^n - 3^n/2 ���� 3^n + 3^n/2 ������ �θ��尡
		// �ȴ�. �� �θ� ã�ư��鼭 �ڽĳ�� ����.
		while(true) {
			c += cnt;
			System.out.println("coni = " + c);
			System.out.println("brwon = " + tree);
//			System.out.println(cnt);
			// �ڴϰ� ���� ������� -1
			if(c > 200000) {
				cnt = -1;
				break;
			}
			// 1��° �ڽĳ�� 3�� �߰�.
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
			
			// �θ��� ã�ư��鼭 �ڽĳ�� ����. ������� ������ �������� �ʰ� 
			// �׳� return.
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
		// Ʈ���� Ȱ���ؼ� ������ Ǯ���.
		// Ʈ���� Ȱ���ϸ� [1]��ġ�� ��������.
		// 3n - 1 �� B - 1 3n �� B + 1 3n + 1 �� 2 * B ����.
		// ���Ͱ��� �������� ũ�� Ʈ���� ����鼭 �ڴ� ��ġ�� ��Ī.
		// ����Լ��ε� ���� ������ �ذ��� �� ������ �������� ��������.
		// �޸� ���� Overflow�� �߻��� �� �־� Ʈ���� �� ���ƺ��δ�.
		String[] location = input.split(" ");
		String c_location = location[0];
		String b_location = location[1];
		int answer = 0;
		
		answer = solution(c_location, b_location);
		System.out.println("answer = " + answer);
	}
	
}
