package CodingTest.D0201;

import java.util.ArrayList;
import java.util.Stack;

public class TrablePass {
	final static String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}
	, {"JFK", "HND"}};
	final static String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}
	, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
	static String[][] input = tickets2;
	
	private static Stack<String> solution(ArrayList<?> tickets
			, String next, Stack<String> route){
		// ���� ����ǥ ����Ʈ���� �ϳ� ������ �� �� �ִ��� Ȯ��
		// �� �� ������ ���� ���� �� �� ����ǥ ������ �Ѱ���.
		// �ݺ��ؼ� ����ǥ ����Ʈ�� �� �� ��쿡�� �������� �ؿ� ���� ��ȯ.
		Stack<String> tmp = null;
		Stack<String> answer = null;
//		
		for(int i = 0; i<tickets.size(); i++) {
			tmp = null;
			String[] ticket = (String[])tickets.get(i);
			if(ticket[0].equals(next)){
				ArrayList<?> tmp_ticket = (ArrayList<?>)tickets.clone();
				Stack<String> tmp_route = (Stack<String>)route.clone();
				tmp_route.add(ticket[0]);
				tmp_ticket.remove(i);
				if(tmp_ticket.size() == 0) {
					tmp_route.add(ticket[1]);
					tmp = tmp_route;
				}
				else {
					tmp = solution(tmp_ticket, ticket[1], tmp_route);
				}
				if(tmp != null && tmp.size() == input.length + 1) {
					for(int j=1; j<tmp.size(); j++) {
						if(answer == null) {
							answer = tmp;
							break;
						}
						if(tmp.get(j).compareTo(answer.get(j)) 
								== 0) {
							continue;
						}
						else if(tmp.get(j).compareTo(answer.get(j)) 
								< 0 ){
							answer = tmp;
						}
						else {
							break;
						}
					}
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		ArrayList<String[]> ticket = new ArrayList<String[]>();
		System.out.print("INPUT = [ ");
		for(String[] s: input) {
			System.out.print("[" + s[0] + " " + s[1] + "] ");
			ticket.add(s);
		}
		System.out.println("]");
		String start = "ICN";
		Stack<String> route = new Stack<String>();
		Stack<String> answer = solution(ticket, start, route);
		
		System.out.println("ANSWER = " + answer);
	}
	
}
