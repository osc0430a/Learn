package D0125;

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
		
		for(int i=0; i<input.length; i++) {
			if(in.indexOf(input[i]) != -1)
				continue;
			in.add(input[i]);
		}
		
		System.out.println(in);

		Collections.sort(in, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		});
		
		System.out.println(in);
	}
	
}
