/*
 * 아이디어: priorityQueue
 * 구현
 * 1. 입력 받은 수 0 or 자연수 판별
 * 2. 0일경우, isEmpty() 확인 후, 비어있으면 0, 아니면 poll()
 * 3. 자연수일 경우, add()
 * 4. 0일경우마다 sb에 저장
 * 5. sb 출력
 * */
import java.io.*;
import java.util.*;

public class Main {
	private static class Point implements Comparable<Point>{
		int num;
		
		public Point(int num) {
			this.num = num;
		}
		
		public int compareTo(Point p) {
			return p.num - this.num;
		}
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int curNum = Integer.parseInt(br.readLine());
			
			if(curNum == 0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll().num+"\n");
			}else {
				pq.add(new Point(curNum));
			}
		}
		
		System.out.println(sb.toString());

	}

}
