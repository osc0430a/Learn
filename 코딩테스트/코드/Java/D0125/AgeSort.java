package CodingTest.D0125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgeSort {
	final static String[] input = {"21 Dohyun", "21 Junkyu" 
			, "20 Sungyoung"}; 
	
	public static void main(String[] args) {
		// 카운팅 소트를 사용할 시 평소대로 나이를 기준으로 index배열을만든 뒤
		// 인풋배열을 역순으로 탐색하여 정렬하면 문제가 해결된다.
		ArrayList<String> in = new ArrayList<String>();
		String tmp = "";
		System.out.print("INPUT = [");
		for(String s:input) {
			tmp += s + ", ";
		}
		tmp = tmp.substring(0,tmp.length()-2);
		System.out.println(tmp + "]");		
		
		for(int i=0; i<input.length; i++) {
			in.add(input[i]);
		}
		
		Collections.sort(in, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] s1, s2;
				s1 = o1.split(" ");
				s2 = o2.split(" ");
				if(s1[0].equals(s2[0]))
					return 0;
				else
					return o1.compareTo(o2);
			}			
		});
		
		System.out.print("ANSWER = ");
		System.out.println(in);
	}
	
}
