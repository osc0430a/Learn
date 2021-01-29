package CodingTest.D0129;

public class Endian {

	public static void main(String[] args) {
		final int input = 2018915346;
		System.out.println("INPUT = " + input);
		String binary = Integer.toBinaryString(input);
		
		while(binary.length() != 32) {
			binary = "0" + binary;
		}
		
		System.out.print("BINARY = ");
		String fir, sec, thi, fou;
		fir = binary.substring(0, 8);
		sec = binary.substring(8, 16);
		thi = binary.substring(16, 24);
		fou = binary.substring(24, 32);
		
		for(int i=0; i<binary.length(); i++) {
			if(i%8 == 0)
				System.out.print(" ");
			System.out.print(binary.charAt(i));
		}
		System.out.println();
		
		binary = fou + thi + sec + fir;
		
		int answer = Integer.parseInt(binary, 2);
		System.out.println("ANSWER = " + answer);
		
	}

}
