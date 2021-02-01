package D0125;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {
	final static int[] input = {-1, -2 ,-3 ,-1 ,-2};
	static int max = -4001;
	static int min = 4001;
	static int cnt = 0;
	static int add = 0;
	static int n = 0;
	// 실 숫자 + 4000의 인덱스에 빈도수 저장
	static int[] list = new int[8001];
	
	public static void main(String[] args) {
		ArrayList<Integer> in = new ArrayList<Integer>();
		// 값 넣으면서 계산 O(N)
		for(int i=0; i<input.length; i++) {
			add += input[i];
			in.add(input[i]);
			if(max < input[i])
				max = input[i];
			if(min > input[i])
				min = input[i];
			list[input[i] + 4000]++;
			if(cnt < list[input[i] + 4000]) {
				cnt = list[input[i] + 4000];
				n = 0;
			}
			if(cnt == list[input[i] + 4000])
				n++;
		}
		
		// 값 정렬 머지로 되어있어서 O(nlogn)
		Collections.sort(in);
		
		// 중앙값 계산
		int center = in.get((input.length + 1)/2 - 1);
		// 평균 계산
		double avg = add / (double)input.length;
		// 최빈값 계산
		int most = 0;
		// O(4000) = O(1)
		if(n == 1) {
			for(int i=0; i<list.length; i++) {
				if(list[i] == cnt)
					most = i - 4000;
			}
		}
		else {
			int j=0;
			for(int i=0; i<list.length; i++) {
				if(list[i] == cnt) {
					if(j == 0) {
						j++;
						continue;
					}
					most = i - 4000;
					break;
				}
			}
		}		
		
		System.out.printf("AVG = %.0f\n", avg);
		System.out.println("CENTER = " + center);
		System.out.println("MOST = " + most);
		System.out.println("RANGE = " + (max - min));		
	}
	
}
