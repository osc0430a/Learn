package CodingTest.D0201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FindDecimal {
	
	private static void addNumList(ArrayList<Integer> list
			, String num, String in, boolean add) {
		if(in.length() == 0 && num != "") {
			if(!list.contains(Integer.parseInt(num)))
				list.add(Integer.parseInt(num));
		}
		else {
			if(add == true) {
				for(int i=0; i<in.length(); i++) {
					addNumList(list, num + in.charAt(i)
					, in.substring(0, i) 
						+ in.substring(i+1, in.length())
					, true);
					addNumList(list, num + in.charAt(i)
					, in.substring(0, i) 
						+ in.substring(i+1, in.length())
					, false);
				}
			}
			else {
				for(int i=0; i<in.length(); i++) {
					addNumList(list, num
					, in.substring(0, i) 
						+ in.substring(i+1, in.length())
					, true);
					addNumList(list, num
					, in.substring(0, i) 
						+ in.substring(i+1, in.length())
					, false);
				}
			}
		}
		
	}
	
	private static ArrayList<Integer> getNumList(String in){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String tmp = "";		
		
		addNumList(list, tmp, in, true);
		addNumList(list, tmp, in, false);
		
		return list;
	}
	
	private static ArrayList<Integer> 
		solution(ArrayList<Integer> list){
		ArrayList<Integer> answer = new ArrayList<Integer>();
				
		for(int i=0; i<list.size(); i++) {
			int tmp = list.get(i);
			for(int j=2; j<tmp/2; j++) {
				if(tmp%j == 0)
					break;
				if(j+1 == tmp/2)
					answer.add(tmp);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String input1 = "17";
		String input2 = "011";
		String input3 = "9989999";
		
		String in = input3;
		System.out.println("INPUT = " + in);
		
		ArrayList<Integer> list = getNumList(in);
		Collections.sort(list);
		System.out.println("Can Make NUM = " + list);
		ArrayList<Integer> answer = solution(list);
		Collections.sort(list);
		System.out.println("Answer list = " + answer);
		System.out.println("Answer = " + answer.size());
	}
}
