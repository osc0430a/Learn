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
//		// 1��Ʈ�� �������� k�� �а� ��ȣ �����ϸ� k�ڸ��� 0 ������ �� 1
//		// �׻��¿��� AND�����ϸ� k�ڸ��� 0���� �ٲ�
//		answer[6] = "&~<<";
		System.out.printf("ANSWER(7) = %s%s%s\n", oper[2]
				, oper[1], oper[5]);
//		// 1��Ʈ�� �������� k�� �а� XOR���ָ� ��Ʈ�� �ٲ�
//		answer[7] = "^<<";
		System.out.printf("ANSWER(8) = %s%s\n", oper[4], oper[5]);
//		// 1��Ʈ�� 1�̾�� 2�� ������ -1 �ؼ� and�غ���
//		// ��Ʈ�� 1�� �� ��� �Ʒ� ��Ʈ�� 1�� �򸮸鼭 and����� 0
//		// 2�� �̻��� ��� ���� ���ʿ� �ִ� ��Ʈ�� 1�� �����־ and����� >0
//		answer[8] = "&";
		System.out.printf("ANSWER(9) = %s\n",  oper[2]);
//		// �ٸ� ��Ʈ���� XOR�� �̰� �ű⼭ 1�� ����
//		// ���� ��Ʈ�� 1�� �� ��� �Ʒ� ��Ʈ�� 1�� �򸮸鼭 and����� 0
//		// 2�� �̻��� ��� ���� ���ʿ� �ִ� ��Ʈ�� 1�� �����־ and����� >0
//		answer[9] = "^&";
		System.out.printf("ANSWER(10) = %s%s\n", oper[4], oper[2]);
		
	}
}
