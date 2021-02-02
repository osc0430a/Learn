package CodingTest.D0201;

public class ChangeWord {
	final static String begin1 = "hit";
	final static String begin2 = "hit";
	final static String target1 = "cog";
	final static String target2 = "cog";
	final static String[] words1 = {"hot", "dot", "dog", "lot"
			, "log", "cog"};
	final static String[] words2 = {"hot", "dot", "dog", "lot"
			, "log"};
	final static String[] words3 = {"hot", "cot", "cog"};
	
	static String begin = begin1;
	static String target = target1;
	static String[] words = words3;

	private static int changeWord(String pre, String next
			, String target , int cnt) {
		int answer = 0;
		if(cnt > words.length)
			return 0;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(pre) || words[i].equals(next))
				continue;
			int match = 0;
			for(int j=0; j<words[i].length(); j++) {
				if(words[i].charAt(j) == next.charAt(j))
					match++;
			}
			if(match == 2) {
				if(words[i].equals(target))
					return cnt;
				int tmp = changeWord(next, words[i]
						, target, cnt + 1);
				if(tmp != 0)
					if(answer == 0)
						answer = tmp;
					else if(answer > tmp)
						answer = tmp;
			}
		}
		return answer;
	}
	
	private static int solution() {
		int cnt = 1;
		int answer = changeWord(begin, begin, target, cnt);
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println("BEGIN = " + begin);
		System.out.println("TARGET = " + target);
		System.out.print("WORDS = [ ");
		for(String s: words) {
			System.out.print(s + " ");
		}
		System.out.println("]");
		
		int answer = solution();
		System.out.println("ANSWER = " + answer);
		
	}
	
}
