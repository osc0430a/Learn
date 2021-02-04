package CodingTest.D0125;

public class MyStatistics {

	public static void main(String[] args) {
		final int[] n = {5, 1, 5};
		final int[][] input = {{1, 3, 8, -2, 2}
		, {4000}, {-1, -2, -3, -1, -2}};
		int max = -4001;
		
		int min = 4001;
		int sum = 0;
		int cnt = 0;
		int flg = 0;
		int[] list = new int[8001];
		int[] in = input[2];		
		MyHeap hp = new MyHeap(n[2]);
		
		for(int i=0; i<in.length; i++) {
			sum += in[i];
			hp.add(in[i]);
			if(max < in[i])
				max = in[i];
			if(min > in[i])
				min = in[i];
			list[in[i] + 4000]++;
			if(cnt < list[in[i] + 4000]) {
				cnt = list[in[i] + 4000];
				flg = 0;
			}
			if(cnt == list[in[i] + 4000])
				flg++;
		}
		
		double avg = (double)sum / in.length;
		int center = 0;
		for(int i=0; i<(in.length + 1) / 2; i++) {
			center = hp.pop();
		}
		int range = max - min;
		int most = 0;
		
		if(flg == 1) {
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
