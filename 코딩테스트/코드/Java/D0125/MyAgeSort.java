package CodingTest.D0125;

public class MyAgeSort {

	public static void main(String[] args) {
		String[] input = {"21 JunKyu", "21 Dohyun", "20 Sungyoung"};		
		int[] index = new int[201];
		String[] answer = new String[input.length];
		
		System.out.print("INPUT = [ ");
		for(int i=0; i<input.length; i++) {
			System.out.print(input[i] + " ");
			int age = Integer.parseInt(input[i].substring(0,2));
			
			index[age]++;			
		}
		System.out.println("]");
		
		int tmp = 0;
		for(int i=1; i<index.length; i++) {
			if(index[i] != 0)
				index[i] += tmp;
			tmp = index[i];
		}
		
		for(int i=input.length - 1; i >=0; i--) {
			int age = Integer.parseInt(input[i].substring(0,2));
			int location = --index[age];
			answer[location] = input[i];			
		}
		
		System.out.print("ANSWER = [ ");
		for(int i=0; i<input.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println("]");
		
	}	
}
