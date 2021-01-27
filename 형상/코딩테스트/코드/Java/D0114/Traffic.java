package D0114;

class Req {
	int start;
	int finish;
	
	Req(int start, int finish){
		this.start = start;
		this.finish = finish;
	}
}

public class Traffic {

	final static String[] req1 = {"2016-09-15 01:00:04.001 2.0s", 
			"2016-09-15 01:00:07.000 2s"};
	final static String[] req2 = {"2016-09-15 01:00:04.002 2.0s", 
	"2016-09-15 01:00:07.000 2s"};
	final static String[] req3 = { "2016-09-15 20:59:57.421 0.351s"
							, "2016-09-15 20:59:58.233 1.181s"
							, "2016-09-15 20:59:58.299 0.8s"
							, "2016-09-15 20:59:58.688 1.041s"
							, "2016-09-15 20:59:59.591 1.412s"
							, "2016-09-15 21:00:00.464 1.466s"
							, "2016-09-15 21:00:00.741 1.581s"
							, "2016-09-15 21:00:00.748 2.31s"
							, "2016-09-15 21:00:00.966 0.381s"
							, "2016-09-15 21:00:02.066 2.62s" };

	// lines = 로그문자열.
	// 응답 완료시간 S = 2016-09-15 hh:mm:ss.sss.
	// 처리시간 T = 0.1s 0.312s등 소숫점 3째자리.
	// ex) 2016-09-15 03:10:33:020 0.011.
	// 응답 완료시간 오름차순으로 정리되어 있음.
	
	// 요청 처리시간이 3초임으로 시간자리까지는 계산 필요 x.
	// 연, 월, 일 시간 제거후 분, 초만 전부 Double형 초로 변환.
	// 클래스 req배열을 만든뒤 시작시간, 끝시간을 파싱하여 저장.
	// 배열에서 하나꺼내서 시작시간 +1 초 and 끝시간 + 1초 후 시간 계산.
	// 2가지 케이스 동일하게 진행.
	// 시작시간이 그 시간 범위 안에있는 값들을 카운트.
	//	카운트 값 비교후 가장 큰 값을 출력.
	
	// 주의사항 시작시간 = 응답 완료시간 - 처리시간 + 0.001
	//		  1초 계산 = 시작시간(or 끝시간) + 1 - 0.001
	
	static Req parse(String req) {
		// 전부 1000자리 곱해서 계산.
		// 부동 소숫점의 오차 없애기 위해서.
		String[] tmp = req.split(" ");	
		String[] tmp_time = tmp[1].split(":");
		int res_clock 
				= Integer.parseInt(tmp_time[0]) * 1000 * 3600;
		int res_minute 
				= Integer.parseInt(tmp_time[1]) * 1000 * 60;
		int res_second 
			= (int)(Double.parseDouble(tmp_time[2]) * 1000);
		int res_time = res_clock + res_minute + res_second;
		int proc_time = (int)(Double.parseDouble(tmp[2]
									.substring(0, tmp[2].length() - 1))
									* 1000);
		int req_time = res_time - proc_time + 1;
//		System.out.println(res_clock);
//		System.out.println(res_minute);
//		System.out.println(res_second);
//		System.out.println(res_time);
//		System.out.println(proc_time);
//		System.out.println(req_time);
		
		Req r = new Req(req_time, res_time);
		
		return r;
	}
	
	public static int count(Req[] req) {
		int max = 0;
		// 끝시간 and 끝시간+1 범위 안에 있는 작업 찾기
		// 경우 1. 더 먼저 시작된 작업과 비교
		//	시작시간이 빠르면 카운트
		// 경우 2. 더 늦게 시작된 작업과 비교
		//  시작이간이 늦는데 끝시간+1 보다는 작음
		for(int i=0; i<req.length; i++) {
			int tmp=1;
			Req f = req[i];
			int stand = f.finish + 1000 - 1;
			for(int j=i+1; j<req.length; j++) {
				 Req s = req[j];
				 if(s.start <= f.finish) {
					 tmp++;
				 }
				 else {
					 if(s.start <= stand) {
						 tmp++;
					 }
				 }
			}
//			System.out.println(tmp);
			if(tmp>max) {
				max = tmp;
			}
		}
		
		return max;
	}
	
	public static void print(Req[] req) {
		for(Req r:req) {
			int clock = r.start/3600000;
			String c="";
			if(clock < 10)
				c = "0" + clock;
			else
				c = "" + clock;
			r.start = r.start % 3600000;
			int minute = r.start/60000;
			String m="";
			if(minute < 10)
				m = "0" + minute;
			else
				m = "" + minute;
			int second = r.start%60000;
			double s = second/1000.0;
			System.out.println("Req_time = " + (c+":"+m+":"+s));
			clock = r.finish/3600000;
			if(clock < 10)
				c = "0" + clock;
			else
				c = "" + clock;
			r.finish = r.finish % 3600000;
			minute = r.finish/60000;
			if(minute < 10)
				m = "0" + minute;
			else
				m = "" + minute;
			second = r.finish%60000;
			s = second/1000.0;
			System.out.println("Res_time = " + (c+":"+m+":"+s));
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		// 내가 만든 parse함수를 이용하여 문자열을 파싱해서.
		// 요청시간과 응답시간을 Class Req에 저장.
		Req[] req = new Req[req3.length];
		for(int i=0; i<req3.length; i++) {
			req[i] = parse(req3[i]);
		}		
		
		// 내가만든 count 함수를 이용하여 정답 계산
		int answer = count(req);
		
		//단순 확인용 출력문
		print(req);
		
		System.out.println(answer);
		
	}
	
}
