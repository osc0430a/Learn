package CodingTest.D0208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RoadtoSchool {
	final static int m = 4;
	final static int n = 3;
	final static int[][] puddles = {{2, 1}, {2, 3}, {2, 2}};
	static ArrayList<int[]> puds = new ArrayList<int[]>();

	private static int solution(int x, int y) {
		int answer = 0;
		
		if(x == m || y == n)
			return 0;
		if(x == m - 1 && y == n - 1)
			return 1;
		boolean blocked = false;
		
		for(int i=0; i<puds.size(); i++) {
			int pudX = puds.get(i)[0] - 1;
			int pudY = puds.get(i)[1] - 1;
			if(x == pudX && y == pudY) {
				blocked = true;
				break;
			}
			if(pudX > x)
				break;
		}
		
		if(blocked)
			return 0;
		answer += solution(x+1, y);
		answer += solution(x, y+1);
		
		return answer;
	}
	
	public static void main(String[] args) {
		for(int i=0; i<puddles.length; i++) {
			puds.add(puddles[i]);
		}
		Collections.sort(puds, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
			
		});	
		System.out.println("INPUT = " + m + " " + n);
		System.out.print("PUDDLES = [");
		for(int[] p:puds) {
			System.out.print(" [ ");
			System.out.print(p[0] + ", " + p[1]);
			System.out.print(" ]");
		}
		System.out.println(" ]");
		
		int answer = solution(0, 0);
		System.out.println("ANSER = " + answer);
	}
}
