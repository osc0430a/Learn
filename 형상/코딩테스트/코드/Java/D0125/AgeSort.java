package D0125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgeSort {
	final static String[] input = {"21 Junkyu", "21 Dohyun"
			, "20 Sungyoung"}; 
	
	public static void main(String[] args) {
		ArrayList<String> in = new ArrayList<String>();
		
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
		
		System.out.println(in);
	}
	
}
