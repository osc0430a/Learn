package CodingTest.D0201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Camera {
	final static int[][] input = {{-20, 15}, {-14, -5}, {-18, -13}
						, {-5, -3}, {16, 17}};
	
	public static void main(String[] args) {
		ArrayList<int[]> in = new ArrayList<int[]>();
		ArrayList<Integer> onCamera = new ArrayList<Integer>();
		ArrayList<Integer> point = new ArrayList<Integer>();
		int answer = 0;
		
		System.out.print("INPUT = [ ");
		for(int[] i:input) {
			System.out.print("[" + i[0] + " " + i[1] 
					+ "] ");
			in.add(i);
		}
		System.out.println("]");
		
		Collections.sort(in, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
//		System.out.print("INPUT = [ ");
//		for(int[] i: in) {
//			System.out.print("[" + i[0] + " " + i[1] 
//					+ "] ");
//		}
//		System.out.println("]");
		
		for(int i=0; i<input.length; i++) {
			int cameraLocation = in.get(i)[1];
			if(onCamera.contains(i))
				continue;
			answer += 1;
			point.add(cameraLocation);
			for(int j=i; j<input.length; j++) {
				if(cameraLocation >= in.get(j)[0]) {
					if(!onCamera.contains(j)) {
						onCamera.add(j);
					}
				}
			}
		}
		System.out.println("CAMERA POINT = " + point);
		System.out.println("ANSWER = " + answer);
	}
	
}
