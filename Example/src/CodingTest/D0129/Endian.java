package CodingTest.D0129;

public class Endian {
	
	private static String getBinary(int in) {
		String binary = Integer.toBinaryString(in);
		return binary;
	}
	
	private static int endianChange(String binary) {
		String fir, sec, thi, fou;
		fir = binary.substring(0, 8);
		sec = binary.substring(8, 16);
		thi = binary.substring(16, 24);
		fou = binary.substring(24, 32);
	
		printBinary(binary);
		
		binary = fou + thi + sec + fir;
		
		printBinary(binary);		
		int answer = Integer.parseInt(binary, 2);
		
		return answer;
	}
	
	private static void printBinary(String binary) {
		System.out.print("BINARY = ");
		for(int i=0; i<binary.length(); i++) {
			if(i%8 == 0)
				System.out.print(" ");
			System.out.print(binary.charAt(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		final int input = 2018915346;
		System.out.println("INPUT = " + input);
		String binary = getBinary(input);
		
		while(binary.length() < 32) {
			binary = "0" + binary;
		}
				
		int answer = endianChange(binary);
		System.out.println("ANSWER = " + answer);
		
	}

}
