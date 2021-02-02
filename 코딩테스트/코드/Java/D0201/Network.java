package CodingTest.D0201;

public class Network {
	final static int n1 = 3;
	final static int n2 = 3;
	final static int n3 = 5;
	final static int[][] input1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	final static int[][] input2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
	final static int[][] input3 = {{1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}
	, {0, 1, 1, 0, 0}, {0, 0, 0 , 1, 0}, {0, 0, 0, 0, 1}};
	
	static int n = n3;
	static int[][] in = input3;
	
	private static void connect(int cnt, int pre
			, int next, int[] net) {
		for(int i=0; i<in[next].length; i++) {
			if(in[next][i] != 0) {
				net[next] = cnt;
				if(i != next && i != pre) {
					connect(cnt, next, i, net);
				}
			}
		}
	}
	
	private static int solution() {
		int[] network = new int[n];
		int cnt = 1;
		
		for(int i=0; i<in.length; i++) {
			if(network[i] != 0) 
				continue;
			connect(cnt, i, i, network);
			cnt++;
		}
		
		System.out.print("NETWORK = [ ");
		for(int i: network) {
			System.out.print(i + " ");
		}
		System.out.println("]");
		
		return cnt - 1;
	}
	
	public static void main(String[] args) {
		
		System.out.print("INPUT = ");
		for(int i=0; i<in.length; i++) {
			System.out.print("[ ");
			for(int j=0; j<in[i].length; j++) {
				System.out.print(in[i][j] + " ");
			}
			System.out.print("] ");
		}
		System.out.println();
		
		int answer = solution();
		
		System.out.println("ASNWER = " + answer);
	}
	
}
