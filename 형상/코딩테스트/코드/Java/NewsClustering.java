package CodingTest;
import java.util.ArrayList;

public class NewsClustering {

	final static String[] input1 = {"FRANCE", "handshake"
	                         , "aa1+aa2" 
	                         , "E=M*C^2"};
	final static String[] input2 = {"french", "shake hands"
							 , "AAAA12", "e=m*c^2"};
	
	public static ArrayList<String> formatString(String in) {
		//문자열 판단.
		ArrayList<String> fs = new ArrayList<String>();
		//	특수문자, 숫자확인.
		for (int i = 0; i < in.length() - 1 ; i++) {
			if(Character.isLetter(in.charAt(i))
					&&Character.isLetter(in.charAt(i+1)) ) {
				fs.add("" + in.charAt(i) + in.charAt(i+1));
			}
		}
		//		없으면 배열에 저장.
		//		있으면 버림.
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
		// 방법1. 양쪽 리스트에서 같은게 있으면 하나넣고 하나버림
		// 방법2. 리스트를 맵에 넣는다. 기본 Value값은 1
		//		 맵에 넣어 보면서 중복되는 키는 벨류값 +1
		//		 다른 리스트를 맵에 넣는다.
		//		 맵에 넣어 보면서 중복되는 키는 벨류값 +0.1
		//		 결과 리스트에 맵의 키값을 넣는다
		//		 	정수부분 or 실수부분만 존재할 경우 그 갯수만큼 
		//			넣고 -1 or -0.1
		//			정수부와 실수부가 모두 존재할 경우
		//		 	정수부분과 소숫점 아래 부분을 나눠 한쪽은 -1 한쪽은 -0.1
		//		 	한쪽이 0이되면 나머지를 계속 집어넣음
		
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
		
		//문자열 2개 소문자로.
		double inter;
		double uni;
		double answer = 0;
		String in1 = input1[3].toLowerCase();
		String in2 = input2[3].toLowerCase();
//		System.out.println("in1 = " + in1);
//		System.out.println("in2 = " + in2);	
		
		//2단어씩 쪼개서 String 배열로 반환.
		ArrayList<String> first = formatString(in1);
		ArrayList<String> second = formatString(in2);
		System.out.println(first);
		System.out.println(second);
		
		//교집합 개수 계산.
		inter = interSection(first, second);
//		System.out.println(inter);
		
		//합집합 개수 계산.
		uni = union(first, second);
//		System.out.println(uni);
		
		//자카드 유사도 계산.
		answer = inter/uni;
		if(uni == 0)
			System.out.println("Divied By Zero");
			answer = 1;
		System.out.println((int)(answer*65536));
		
	}
	
}
