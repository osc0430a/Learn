package Programmers;

import java.util.ArrayList;

public class Heap03 {	
	ArrayList<Integer> hp = new ArrayList<Integer>();
	int max = 0;
	
	private void add(int v) {
		hp.add(v);
		if(v > max)
			max = v;
		int now = hp.size() - 1;
		int parent = (now - 1) / 2;
		
		while(parent >= 0) {
			int p = hp.get(parent);
			int s = hp.get(now);
			
			if(p > s) {
				hp.set(parent, s);
				hp.set(now, p);
				now = parent;
				parent = (now - 1) / 2;
			}
			else
				break;
		}
	}
	
	private int popMin() {
		if(hp.size() == 0)
			return 0;
		if(hp.size() == 1) {
			int min = hp.get(0);
			hp.remove(0);
			return min;
		}
		
		int min = hp.get(0);
		hp.set(0, hp.get(hp.size()-1));
		hp.remove(hp.size()-1);
		
		int now = 0;
		int leftSon = now * 2 + 1;
		int rightSon = now * 2 + 2;
		while(leftSon < hp.size()) {
			int l = hp.get(leftSon);
			int r = 999999999;
			if(rightSon < hp.size())
				r = hp.get(rightSon);
			int p = hp.get(now);
			if(l < r){
				if(l < p) {
					hp.set(now, l);
					hp.set(leftSon, p);
					now = leftSon;
					leftSon = now * 2;
					rightSon = now * 2 + 1;
				}
				else
					break;
			}
			else {
				if(r < p) {
					hp.set(now, r);
					hp.set(rightSon, p);
					now = rightSon;
					leftSon = now * 2;
					rightSon = now * 2 + 1;
				}
				else
					break;
			}
		}
		
		return min;
	}
	
	private int popMax() {
		if(hp.size() == 0)
			return 0;
		if(hp.size() == 1) {
			int tmpMax = hp.get(0);
			hp.remove(0);
			return tmpMax;
		}
		int cnt = 0;
		int tmpMax = max;
		max = 0;
		int index = hp.indexOf(tmpMax);
		hp.remove(index);
		int i = 0;
		
		while(index - cnt >= 0) {
			cnt += (int)Math.pow(2, i++);
		}
//		int depth = i;
		int start = cnt - (int)Math.pow(2, i - 1);
		int finish = 0;
		
		if(cnt > hp.size())
			finish = hp.size();
		else
			finish = cnt;
		
		for(i=start; i<finish; i++) {
			int tmp = hp.get(i);
			if(tmp > max)
				max = tmp;
		}
		
		return tmpMax;
	}
	
	public static void main(String[] args) {
		Heap03 h = new Heap03();
		h.add(-45);
		h.add(653);
		h.popMax();
		h.add(-642);
		h.add(45);
		h.add(97);
		h.popMax();
		h.popMin();
		h.add(333);
		
		int[] answer = new int[2];
		answer[0] = h.popMax();
		answer[1] = h.popMin();
		System.out.println("ANSWER = [" + answer[0] + ", " + answer[1] + "]");
	}

}
