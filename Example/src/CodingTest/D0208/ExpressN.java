package CodingTest.D0208;

import java.util.ArrayList;

public class ExpressN {
	final static int N1 = 5;
	final static int N2 = 2;
	final static int N3 = 9;
	
	final static int input1 = 12;
	final static int input2 = 11;
	final static int input3 = 8;
	
	static int n = N3;
	static int input = input3;
	
	private static int solution(int n) {
		ArrayList<Integer> result;
		ArrayList<ArrayList<Integer>> combination
							= new ArrayList<ArrayList<Integer>>();		
		int digit = 0;
		for(int i=1; i<9; i++) {
			result = new ArrayList<Integer>();
			digit = digit*10 + n;
			result.add(digit);
			
			for(int j=0; j<i/2; j++) {
				ArrayList<Integer> subCombi1 = combination.get(j);
				ArrayList<Integer> subCombi2 
										= combination.get(i-j-2);
				for(int k=0; k<subCombi1.size(); k++) {
					int tmp1 = subCombi1.get(k);
					for(int l=0; l<subCombi2.size(); l++) {
						int tmp2 = subCombi2.get(l);
						result.add(tmp1 + tmp2);
						result.add(tmp1 - tmp2);
						result.add(tmp2 - tmp1);						
						result.add(tmp1 * tmp2);
						if(tmp1 !=0)
							result.add(tmp2 / tmp1);						
						if(tmp2 !=0)
							result.add(tmp1 / tmp2);						
					}					
				}
			}
			System.out.println("STEP" + i +" = " + result);
			if(result.contains(input))
				return i;
			combination.add(result);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int answer = 0;
		System.out.println("N = " + n);
		System.out.println("INPUT = " + input);
		
		answer = solution(n);
		System.out.println("ANSWER = " + answer);
	}
	
}
