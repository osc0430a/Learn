
package CodingTest.D0208;

public interface Pilfer {
	final static int[] money1 = {5, 2, 3, 1, 1, 5, 6};
	final static int[] money2 = {1, 2, 3, 1};
	static int[] money = money2;
	static int[] check = new int[money.length];
	
	private static int calMoney(int sum, int now, boolean steal) {
		int stealNext = 0;
		int notStealNext = 0;
		if(now == money.length)
			return sum;
		if(steal) {
			sum += money[now];
			notStealNext = calMoney(sum, now+1, false);
		}
		else {
			stealNext = calMoney(sum, now+1, true);
			notStealNext = calMoney(sum, now+1, false);
		}
		if(stealNext > notStealNext) {
			if(now +1 < check.length)
				check[now+1] = 1;
			return stealNext;
		}
		if(now +1 < check.length)
			check[now+1] = 0;
		return notStealNext;
	}
	
	private static int solution() {
		int stealFirst = calMoney(0, 0, true);
		int notStealFirst = calMoney(0, 0, false);
		
		if(stealFirst > notStealFirst) {
			check[0] = 1;
			return stealFirst;
		}
		return notStealFirst;
	}

	public static void main(String[] args) {
		System.out.print("INPUT = ");
		for(int i:money) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int answer = solution();
		
		System.out.print("STEAL = [ ");
		for(int i=0; i<check.length; i++) {
			if(check[i] == 1)
				System.out.print(i + " ");
		}
		System.out.println("]");
		
		System.out.println("ANSWER = " + answer);
	}	
}
