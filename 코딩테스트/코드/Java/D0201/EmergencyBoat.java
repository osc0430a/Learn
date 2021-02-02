package CodingTest.D0201;

import java.util.ArrayList;
import java.util.Collections;

public class EmergencyBoat {
	final static int[] input1 = {70, 50, 80, 50};
	final static int[] input2 = {70, 80, 50};
	final static int limit = 100;
	static int[] input = input2;
	
	public static void main(String[] args) {
		ArrayList<Integer> in = new ArrayList<Integer>();		
		ArrayList<Integer> rescue = new ArrayList<Integer>();		
		int boat = 0;
		
		for(int i: input) {
			in.add(i);
		}
		System.out.println("INPUT = " + in);
		
		Collections.sort(in, Collections.reverseOrder());
		
		for(int i=0; i<in.size(); i++) {
			int weight = 0;
			if(rescue.size() == in.size())
				break;
			if(rescue.contains(i))
				continue;
			boat++;
			for(int j=i; j<in.size(); j++) {
				int person = j;
				int next_weight = in.get(j);
				// 더 탈 수 있으면 태우고 구조 목록에 추가.
				if(weight + next_weight <= limit) {
					weight += next_weight;
					System.out.print(person + "is Rescued ");
					rescue.add(person);
				}
			}
			System.out.println();
		}
		
		System.out.println("ASNWER = " + boat);
	}
	
}
