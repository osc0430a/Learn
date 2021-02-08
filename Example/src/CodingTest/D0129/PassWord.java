package CodingTest.D0129;

public class PassWord {

	private static int calLowMatch(int in) {
		int bit = Integer.bitCount(in);
		int lowMatch = 0;
		int tmp = in;
		
		while(tmp > 0) {
			tmp -= 1;
			int tmpBit = Integer.bitCount(tmp);
			if(tmpBit == bit) {
				lowMatch = tmp;
				break;
			}
		}
		
		return lowMatch;
	}
	
	private static int calHighMatch(int in) {
		int bit = Integer.bitCount(in);
		int highMatch = 0;
		int tmp = in;
		
		// �ִ� �Է°� 108 = 0b 0110 1100 
		// �׷��ٸ� ���� ���� 1�� �� = 0b 0011 1111 or 0101 1111
		// 127 = 0b 0111 1111�� ��� �� Ŀ�� ����
		while(tmp < 127) {
			tmp += 1;
			int tmpBit = Integer.bitCount(tmp);
			if(tmpBit == bit) {
				highMatch = tmp;
				break;
			}
		}
		
		return highMatch;
	}
	
	public static void main(String[] args) {
		int[] input = {43, 7};
		int in = input[0];
		System.out.println("INPUT = " + in);
		int highMatch = 0;
		int lowMatch = 0;
		int bit = Integer.bitCount(in);
		System.out.println("The Nuber of One-bit = " + bit);
		
		lowMatch = calLowMatch(in);
		highMatch = calHighMatch(in);
		
		System.out.println("Low Match Number = " + lowMatch);
		System.out.println("High Match Number = " + highMatch);
	}
	
}