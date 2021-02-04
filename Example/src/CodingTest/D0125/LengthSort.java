package CodingTest.D0125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LengthSort {
	static String[] input = {"but", "i", "wont"
	, "hesitate", "no", "more", "no", "more", "it"
	, "cannot", "wait", "im", "yours"};
	
	public static void main(String[] argds) {
		ArrayList<String> in = new ArrayList<String>();
		String tmp = "";
		System.out.print("INPUT = [");
		for(String s:input) {
			tmp += s + ", ";
		}
		tmp = tmp.substring(0,tmp.length()-2);
		System.out.println(tmp + "]");
		
		for(int i=0; i<input.length; i++) {
			if(in.indexOf(input[i]) != -1)
				continue;
			in.add(input[i]);
		}

		Collections.sort(in, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		});
		
		System.out.print("ANSWER = ");
		System.out.println(in);
	}
	
}
