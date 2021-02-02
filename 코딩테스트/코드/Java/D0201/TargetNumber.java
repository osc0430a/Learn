package CodingTest.D0201;

public class TargetNumber {
	final static int[] input = {1, 1, 1, 1, 1};
	final static int target = 3;
	
	

	public static int searchTarget(int now, int index, int target) {
		int tmp = 0;
		if(index == input.length) {
			if(now == target)
				return 1;
			else
				return 0;
		}		
		else {
			tmp += searchTarget(now + input[index], index + 1, target)
				+searchTarget(now - input[index], index + 1, target);
		}
//		System.out.println(tmp);
		return tmp;
	}
	
	private static int solution() {
		int answer = searchTarget(0, 0, target);
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.print("INPUT = [ ");
		for(int i:input) {
			System.out.print(i + " ");
		}
		System.out.println("]");
		System.out.println("TARGET = " + target);
		
		int answer = solution();
		System.out.println("ANSWER = " + answer);
		
	}
	
}
