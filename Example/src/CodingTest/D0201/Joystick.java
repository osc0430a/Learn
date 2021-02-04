package CodingTest.D0201;

public class Joystick {
	final static String input1 = "JEROEN";
	final static String input2 = "JAN";
	final static String input3 = "JAZ";
	final static String input4 = "JAZA";
	final static String input5 = "BBBAAAAAAABB";
	
	static String in = input5;

	// 9 4 9 12 4 13 = 34 38 51
	// ABCDEFGHIJKLMNOPQRSTUVWXYZ
	
	private static int calAlpha(char c) {
		char a = 'A';
		char z = 'Z';
		int up = c - a;
		int down = z - c + 1;
		if(up < down)
			return up;
		return -1 * down;
	}
	
	private static int calLocation(int index
									, String tmp, String in) {
		int mRight = 0;
		int mLeft = 0;
		
		while(true) {
			int location = index + mRight;
			if(location >= in.length())
				location -= in.length();
			if(in.charAt(location) 
					!= tmp.charAt(location)) {
				break;
			}
			mRight++;
		}
		
		while(true) {
			int location = index - mLeft;
			if(location < 0)
				location += in.length();
			if(in.charAt(location) != tmp.charAt(location)) {
				break;
			}
			mLeft++;
		}
		
//		System.out.println("mRight = " + mRight);
//		System.out.println("mLeft = " + mLeft);
		
		if(mRight <= mLeft)
			return mRight;
		return -1 * mLeft;
	}
	
	public static void main(String[] args) {
		int answer = 0;
		int nonA = 0;
		String tmp = "";
		System.out.println("INPUT = " + in);

		for(int i=0; i<in.length(); i++) {
			tmp += "A";
		}
		
		System.out.println("NOW = " + tmp);		
		int index = 0;
		while(!in.equals(tmp)) {
			int moveLocation = calLocation(index, tmp, in);
			index += moveLocation;
			if(index < 0)
				index += in.length();
			if(index >= in.length())
				index -= in.length();
			
			char alpha = in.charAt(index);
			int moveAlpha = calAlpha(alpha);
			alpha = (char) ('A' + moveAlpha);
			if(alpha < 'A')
				alpha += 'Z' - 'A' + 1;
			if(alpha > 'Z')
				alpha -= 'Z' - 'A';
			if(index + 1 < tmp.length())
				tmp = tmp.substring(0,index) + alpha 
						+ tmp.substring(index+1, in.length());
			else
				tmp = tmp.substring(0,index) + alpha;
			
			if(moveLocation < 0)
				moveLocation *= -1;
			if(moveAlpha < 0)
				moveAlpha *= -1;
			answer += moveLocation;
			answer += moveAlpha;
			System.out.println("NOW = " + tmp);		
		}
		System.out.println("ANSWER = " + answer);
	}
	
}
