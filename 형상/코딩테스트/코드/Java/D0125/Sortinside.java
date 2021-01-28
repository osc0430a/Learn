package CodingTest.D0125;

public class Sortinside {

	public static void main(String[] args) {
		long before = System.currentTimeMillis(); 
		int input = 2143;
		//         1000000000보다 작거나 같은 자연수
		System.out.println("INPUT = " + input);
		int length = ("" + input).length();
		MyHeap hp = new MyHeap(length);		
		
		for(int i=0; i<length; i++) {
			int n = input % 10;
			input = input / 10;
			hp.add(n);
		}
		System.out.print("ANSWER = ");
		for(int i = 0; i<length; i++) {
			System.out.print(hp.pop());
		}
		long after = System.currentTimeMillis();
		System.out.println();
		System.out.println("Runtime = " + (after - before) + "ms");
	}
	
}
