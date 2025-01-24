/*
 (구)모든 정점 중, 두 정점 사이의 거리가 가장 긴 거리
 아이디어: PQ?
 1. 정점 : (이어진 정점, 값) <- 이렇게 저장하기
 2. 타고타고 가서 구하기
 */

import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int num;
		int w;
		
		public Point(int num, int w) {
			this.num = num;
			this.w = w;
		}
	}
	
	static int v;
	static ArrayList<ArrayList<Point>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < v; i++) {
			String [] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);	// 기준정점
			for(int j = 1; j < tmp.length; j+=2) {
				if(j == tmp.length-1) break;

				int a = Integer.parseInt(tmp[j]);		// 연결되는 정점
				int b = Integer.parseInt(tmp[j+1]);		// 정점 사이의 거리
				list.get(n).add(new Point(a, b));
			}
		}
		
		
		Point startPoint = bfs(1);		// 1번 정점에서 가장 먼 정점 찾기
		Point result = bfs(startPoint.num);	// start에서 가장 먼 정점까지의 거리
		
		System.out.println(result.w);	// 정답 출력
	}
	
	static Point bfs(int start) {
		Queue<Point> que = new LinkedList<>();
		boolean [] visited = new boolean[v+1];
		int [] distance = new int[v+1];		// 정점 사이의 거리

		int result = 0;			// 정점 간의 거리
		int tmpNum = start;		// 가장 먼 정점 번호
		que.add(new Point(start, 0));
		visited[start] = true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(Point nextP : list.get(p.num)) {
				if(!visited[nextP.num]) {
					visited[nextP.num] = true;
					distance[nextP.num] = distance[p.num]+nextP.w;
					
					if(distance[nextP.num] > result) {
						result = distance[nextP.num];
						tmpNum = nextP.num;			// 가장 먼 정점으로 업데이트
					}
					
					que.add(nextP);
				}
			}
		}

		return new Point(tmpNum, result);
		
	}

}
