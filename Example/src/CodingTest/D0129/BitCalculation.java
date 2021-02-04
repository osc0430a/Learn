package CodingTest.D0129;

public class BitCalculation {
	
	public static void main(String[] args) {		
		String[] oper = {"?", "~", "&", "|", "^", "<<", ">>"};
		System.out.printf("ANSWER(1) = %s\n",  oper[2]);
		System.out.printf("ANSWER(2) = %s%s\n",  oper[1], oper[2]);
		System.out.printf("ANSWER(3) = %s\n", oper[5]);
		System.out.printf("ANSWER(4) = %s%s%s\n", oper[6]
				, oper[2], oper[5]);
		System.out.printf("ANSWER(5) = %s%s%s\n", oper[4]
				, oper[4], oper[4]);
		System.out.printf("ANSWER(6) = %s%s\n", oper[6], oper[2]);
//		// 1비트를 왼쪽으로 k번 밀고 부호 반전하면 k자리만 0 나머진 다 1
//		// 그상태에서 AND연산하면 k자리만 0으로 바뀜
//		answer[6] = "&~<<";
		System.out.printf("ANSWER(7) = %s%s%s\n", oper[2]
				, oper[1], oper[5]);
//		// 1비트를 왼쪽으로 k번 밀고 XOR해주면 비트가 바뀜
//		answer[7] = "^<<";
		System.out.printf("ANSWER(8) = %s%s\n", oper[4], oper[5]);
//		// 1비트만 1이어야 2의 제곱수 -1 해서 and해보면
//		// 비트가 1개 일 경우 아래 비트가 1로 깔리면서 and연산시 0
//		// 2개 이상일 경우 가장 왼쪽에 있는 비트가 1로 남아있어서 and연산시 >0
//		answer[8] = "&";
		System.out.printf("ANSWER(9) = %s\n",  oper[2]);
//		// 다른 비트들을 XOR로 뽑고 거기서 1을 빼면
//		// 같은 비트가 1개 일 경우 아래 비트가 1로 깔리면서 and연산시 0
//		// 2개 이상일 경우 가장 왼쪽에 있는 비트가 1로 남아있어서 and연산시 >0
//		answer[9] = "^&";
		System.out.printf("ANSWER(10) = %s%s\n", oper[4], oper[2]);
		
	}
}
