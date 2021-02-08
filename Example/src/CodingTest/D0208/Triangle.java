package CodingTest.D0208;

public class Triangle {
	final static int[][] input = {{7}, {3, 8}, {8, 1 ,0}
								, {2, 7 ,4 ,4}, {4, 5, 2, 6, 5}
								,{1, 2, 3, 4, 5, 6}};
	
	private static int calSum(int sum, int x, int y) {
		int left = 0;
		int right = 0;
		int answer = 0;
		if(y == input.length)
			return sum;
		sum += input[y][x];
		left = calSum(sum, x, y+1);
		right = calSum(sum, x+1, y+1);
		
		answer = Math.max(left, right);
		
		return answer;		
	}
	
	private static int solution() {
		int answer = calSum(0, 0, 0);
		
				
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.print("INPUT = [");
		for(int i=0; i<input.length; i++) {
			int[] tmp = input[i];
			System.out.print(" [ ");
			for(int j=0; j<tmp.length; j++) {
				System.out.print(tmp[j] + " ");
			}
			System.out.print("]");
		}
		System.out.println();
	
		int answer = solution();
		System.out.println("ANSWER = " + answer);
	}
	
}
