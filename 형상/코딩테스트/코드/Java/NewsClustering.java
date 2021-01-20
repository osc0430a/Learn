package CodingTest;
import java.util.ArrayList;

public class NewsClustering {

	final static String[] input1 = {"FRANCE", "handshake"
	                         , "aa1+aa2" 
	                         , "E=M*C^2"};
	final static String[] input2 = {"french", "shake hands"
							 , "AAAA12", "e=m*c^2"};
	
	public static ArrayList<String> formatString(String in) {
		//���ڿ� �Ǵ�.
		ArrayList<String> fs = new ArrayList<String>();
		//	Ư������, ����Ȯ��.
		for (int i = 0; i < in.length() - 1 ; i++) {
			if(Character.isLetter(in.charAt(i))
					&&Character.isLetter(in.charAt(i+1)) ) {
				fs.add("" + in.charAt(i) + in.charAt(i+1));
			}
		}
		//		������ �迭�� ����.
		//		������ ����.
		return fs;
	}
	
	public static int interSection(ArrayList<String> f 
									, ArrayList<String> s) {
		int cnt = 0;
		
		ArrayList<String> inter = new ArrayList<String>();
		
		for (String i:f) {
			if(s.contains(i)) {
				inter.add(i);
				cnt++;
			}
		}
		
		System.out.println(inter);
		
		return cnt;
	}
	
	public static int union(ArrayList<String> f 
							 , ArrayList<String> s) {
		// ���1. ���� ����Ʈ���� ������ ������ �ϳ��ְ� �ϳ�����
		// ���2. ����Ʈ�� �ʿ� �ִ´�. �⺻ Value���� 1
		//		 �ʿ� �־� ���鼭 �ߺ��Ǵ� Ű�� ������ +1
		//		 �ٸ� ����Ʈ�� �ʿ� �ִ´�.
		//		 �ʿ� �־� ���鼭 �ߺ��Ǵ� Ű�� ������ +0.1
		//		 ��� ����Ʈ�� ���� Ű���� �ִ´�
		//		 	�����κ� or �Ǽ��κи� ������ ��� �� ������ŭ 
		//			�ְ� -1 or -0.1
		//			�����ο� �Ǽ��ΰ� ��� ������ ���
		//		 	�����κа� �Ҽ��� �Ʒ� �κ��� ���� ������ -1 ������ -0.1
		//		 	������ 0�̵Ǹ� �������� ��� �������
		
		ArrayList<String> us = new ArrayList<String>();
		
		for(String i:f) {
			if(s.contains(i)) {
				us.add(i);
				s.remove(i);
			}
			else
				us.add(i);
		}
		us.addAll(s);
		System.out.println(us);
		
		return us.size();
	}
	
	public static void main(String[] args) {
		
		//���ڿ� 2�� �ҹ��ڷ�.
		double inter;
		double uni;
		double answer = 0;
		String in1 = input1[3].toLowerCase();
		String in2 = input2[3].toLowerCase();
//		System.out.println("in1 = " + in1);
//		System.out.println("in2 = " + in2);	
		
		//2�ܾ �ɰ��� String �迭�� ��ȯ.
		ArrayList<String> first = formatString(in1);
		ArrayList<String> second = formatString(in2);
		System.out.println(first);
		System.out.println(second);
		
		//������ ���� ���.
		inter = interSection(first, second);
//		System.out.println(inter);
		
		//������ ���� ���.
		uni = union(first, second);
//		System.out.println(uni);
		
		//��ī�� ���絵 ���.
		answer = inter/uni;
		if(uni == 0)
			System.out.println("Divied By Zero");
			answer = 1;
		System.out.println((int)(answer*65536));
		
	}
	
}
