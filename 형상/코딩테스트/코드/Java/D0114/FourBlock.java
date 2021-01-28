package CodingTest.D0114;

import java.util.ArrayList;

public class FourBlock {

	final static int[] m = {4, 6};
	final static int[] n = {5, 6};
	final static String[] board1 = {"CCBDE", "AAADE", "AAABF"
									, "CCBBF"};
	final static String[] board2 = {"TTTANT", "RRFACC", "RRRFCC"
									, "TRRRAA", "TTMMMF", "TMMTTJ"};
	
	static class Line{		
		
		int[] value;
		String key;
		
		Line(String key, int[] value){
			this.key = key;
			this.value = value;
		}		
	}
	
	public static char[] sort(char[] l) {
		for(int i=0; i<l.length; i++) {
			if(l[i] == '0') {
				for(int j = i; j > 0; j--) {
					char tmp = l[j];
					l[j] = l[j-1];
					l[j-1] = tmp;					
				}
			}
		}
//		System.out.println(l);
		return l;
	}
	
	public static ArrayList<Line> save(int index, int n
						, int m, char[] t, ArrayList<Line> board){
		if(index == n-1) {
			for(int i=0; i<m; i++) {
				String tmp = board.get(i).key;
				tmp = tmp.substring(0,index) + t[i];
				board.get(i).key = tmp;
			}
		}
		else {
			for(int i=0; i<m; i++) {
				String tmp = board.get(i).key;
				tmp = tmp.substring(0,index)+t[i]
						+tmp.substring(index+1,tmp.length());						
				board.get(i).key = tmp;
			}
		}
		
		return board;
	}
	
	public static ArrayList<Line> pang(int n, int m, ArrayList<Line> board) {
		// Value�� 4�� key�� ���� 0���� ġȯ
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if(board.get(i).value[j] == 4) {
					String tmp = board.get(i).key;
//					System.out.println(tmp);
//					System.out.println(i+" "+j);
					if(j==n-1) {
						tmp = tmp.substring(0,j)+"0";
						board.get(i).value[j] = 0;
					}
					else {
						tmp = tmp.substring(0,j)+"0"
								+tmp.substring(j+1,tmp.length());
						board.get(i).value[j] = 0;
					}
					board.get(i).key = tmp;
//					System.out.println(tmp);
				}
			}
			System.out.println(board.get(i).key);
		}
		System.out.println();
		// 0�� ���� ��ܼ� ����
		// 0�� ã���� 0�� �� ���� �ø��� �������� ��ĭ�� ����.
		for(int i=0; i<n; i++) {
			char[] tmp = new char[m];
			for(int j=0; j<m; j++) {
				tmp[j] = board.get(j).key.charAt(i);
			}
			tmp = sort(tmp);
//			System.out.println(tmp);
			board = save(i, n, m, tmp, board);			
		}

		for (Line l: board)
			System.out.println(l.key);
		System.out.println();
		
		return board;
	}
	
	public static ArrayList<Line> solution(int n, int m
			, ArrayList<Line> board) {
		// ������ ���� Ű�� ���� ������ ������ ����
		// ex) 0,0���� ���� 0,1 1,0 1,1 �˻�
		// �ѹ��� �˻� �� ������ 4�� ������ ����
		// �����ϰ� �ٽ� �˻�
		// ������ �׸��� ������ ����.
		int match = 0;
		
		for (int i=0; i<m-1; i++) {
			for (int j=0; j<n-1; j++) {
				char tmp = board.get(i).key.charAt(j);
				if (tmp == '0')
					continue;
				char rh = board.get(i).key.charAt(j+1);
				char ll = board.get(i+1).key.charAt(j);
				char rl = board.get(i+1).key.charAt(j+1);
				
				if (tmp == rh && tmp == ll && tmp == rl) {
					match++;
					board.get(i).value[j] = 4;
					board.get(i).value[j+1] = 4;
					board.get(i+1).value[j] = 4;
					board.get(i+1).value[j+1] = 4;
				}							
			}
		}
		for (Line l: board) {
			for(int i: l.value){
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
		
		if( match == 0 ) {
			// �Ϸ�� ���� ����
			return board;
		}
		else {
			// ���� �Լ��� ���� ������ �ݺ�.
			board = pang(n, m, board);
			board = solution(n, m, board);
			return board;
		}
	}
	
	public static int count(int n, int m, ArrayList<Line> board) {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board.get(j).key.charAt(i) == '0')
					cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		// ���� ���� m �� n ��ġ���� board
		// Ŭ���� �ν��Ͻ� ����. Ŭ�������� Ű, ������ ����	
		
		ArrayList<Line> board = new ArrayList<Line>();
		Line line = null;
		int answer = 0;
		
		for(String s:board2){
			int[] i = new int[n[1]];
			for(int j=0; j<i.length; j++) {
				i[j] = 0;
			}
			line = new Line(s, i);
//			System.out.println(line.key);
			board.add(line);
		}
		for (Line l: board)
			System.out.println(l.key);
		System.out.println();
		
		board = solution(n[1], m[1], board);
		
		for (Line l: board)
			System.out.println(l.key);
		System.out.println();
		
		answer = count(n[1], m[1], board);
		System.out.println(answer);
		
	}
	
}
