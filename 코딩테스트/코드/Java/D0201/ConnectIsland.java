package CodingTest.D0201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ConnectIsland {
	final static int n = 4;
	final static int[][] cost = {{0, 1 ,1}, {0, 2, 2}, {1, 2, 5}
					, {1, 3, 1}, {2, 3, 8}};

	public static void main(String[] args) {
		ArrayList<int[]> costs = new ArrayList<int[]>();
		ArrayList<Integer> con = new ArrayList<Integer>();
		ArrayList<Integer> show = new ArrayList<Integer>();
		
		int answer = 0;
		
		System.out.print("INPUT = [ ");
		for(int i=0; i<n; i++) {
			System.out.print("[" + cost[i][0] + " " + cost[i][1] 
					+ " " + cost[i][2] + "] ");
			costs.add(cost[i]);
		}
		System.out.println("]");
		
		Collections.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}			
		});
		
		for(int i=0; i<costs.size(); i++) {
			int f_island = costs.get(i)[0];
			int s_island = costs.get(i)[1];
			int build_cost = costs.get(i)[2];
			
			if(!con.contains(f_island)) {
				con.add(f_island);
				if(!con.contains(s_island)) {
					con.add(s_island);
				}
				show.add(build_cost);
				answer += build_cost;
			}
			else if(!con.contains(s_island)) {
				con.add(s_island);
				show.add(build_cost);
				answer += build_cost;
			}
		}
		
		System.out.println("BRIDGE COSTS = " + show);
		System.out.println("ANSWER = " + answer);
		
	}
	
}
