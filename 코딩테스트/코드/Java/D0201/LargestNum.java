package CodingTest.D0201;

public class LargestNum {
	final static String input1 = "1924";
	final static String input2 = "1231234";
	final static String input3 = "4177252841";	
	final static int k1 = 2;
	final static int k2 = 3;
	final static int k3 = 4;
	
	static String in = input3;
	static int n = k3;
	
	private static int calRange(int length, int k) {
		int range = length - k;
		return range;
	}
	
	private static int getMaxIndex(int index, int range, String in) {
		int maxIndex = 0;
		int max = 0;
		for(int i=index; i<=range; i++) {
			int tmp = Integer.parseInt(in.charAt(i) + "");
			if(max < tmp) {
				max = tmp;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		String answer = "";
		int k = in.length() - n;
		
		System.out.println("INPUT = " + in + " K = " + k);
		
		int index = 0;
		int length = in.length();
		for(int i=0; i<k; i++) {
			int range = calRange(length, k - i);
			index = getMaxIndex(index + 1, range, in);
			answer += in.charAt(index);	
			System.out.println("TEMP ANSER = " + answer);
		}
		System.out.println("ANSWER = " + answer);
	}
	
}
