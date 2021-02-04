package CodingTest.D0201;

import java.util.ArrayList;

public class Exam {

	private static int[] getFirstAnswer(int n) {
		int[] answer = new int[n];
		for(int i=0; i<n; i++) {
			answer[i] = i+1;
		}
		return answer;
	}
	
	private static int[] getSecondAnswer(int n) {
		int[] answer = new int[n];
		int[] cycle = {1, 3, 4, 5};
		int[] tmp = new int[n/2];
		for(int i=0; i<n/2; i++) {
			int index = i%4;
			tmp[i] = cycle[index];
		}
		for(int i=0; i<n; i++) {
			if(i%2 == 0)
				answer[i] = 2;
			else
				answer[i] = tmp[i/2];
		}
		
		return answer;
	}
	
	private static int[] getThirdAnswer(int n) {
		int[] answer = new int[n];
		int[] cycle = {3, 1, 2, 4, 5};
		int cnt = -1;
		for(int i=0; i<n; i++) {
			if(i%2 == 0)
				cnt++;
			int index = cnt % 5;
			answer[i] = cycle[index];
		}
		return answer;
	}
	
	private static ArrayList<Integer> solution(int[] in
			, int[] f, int[] s, int[] t) {
		ArrayList<Integer> answer = new ArrayList<>();
		int f_score = 0;
		int s_score = 0;
		int t_score = 0;
		
		for(int i=0; i<in.length; i++) {
			if(in[i] == f[i])
				f_score++;
			if(in[i] == s[i])
				s_score++;
			if(in[i] == t[i])
				t_score++;
		}
		
		int tmp = Math.max(f_score, Math.max(s_score, t_score));
		if(tmp == f_score)
			answer.add(1);
		if(tmp == s_score)
			answer.add(2);
		if(tmp == t_score)
			answer.add(3);
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] input1 = {1, 2, 3, 4, 5};
		int[] input2 = {1, 3, 2, 4, 2};
		int[] in = input1;
		
		System.out.print("INPUT = ");
		for(int i:in) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] f_answer = getFirstAnswer(in.length); 
		System.out.print("First Answer = ");
		for(int i:f_answer) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] s_answer = getSecondAnswer(in.length); 
		System.out.print("Second Answer = ");
		for(int i:s_answer) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] t_answer = getThirdAnswer(in.length); 
		System.out.print("Third Answer = ");
		for(int i:t_answer) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		ArrayList<Integer> answer 
			= solution(in, f_answer, s_answer, t_answer);
		System.out.println("ANSWER = " + answer);
		
	}
	
}
