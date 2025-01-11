/*
 * [초기 아이디어] -> 틀림
 1. List<Point> 로 리스트 type에 좌표 객체 저장하기
 2. for문 돌려서 방문하기
 3. visited 배열 false 있으면 탈락
 
 
 -> 나이트는 L자로 이동 -> 이게 포인트!!!
 -> 1. 모든 순서들이 L자 이동
 -> 2. 처음 위치 <-> 마지막 위치 도 L자 이동
 -> 1, 2 조건 모두 만족할 때 올바른 나이트이동
 */
import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Point> list = new ArrayList<>();
		boolean [][] visited = new boolean[6][6];
		
		for(int i = 0; i < 36; i++) {
			String str = br.readLine();
			int x = str.charAt(0) - 'A';		// 인덱스 0부터 시작
			int y = str.charAt(1) - '1';
			
			list.add(new Point(x, y));
		}
		
		// 1. 모든 순서들이 'L'자 이동
		for(int i = 0; i < 36; i++) {
			Point cur = list.get(i);
			
			if(visited[cur.x][cur.y]) {		// 이미 방문
				System.out.println("Invalid");
				return;
			}
			
			visited[cur.x][cur.y] = true;
			
			// 이전 위치 -> 현재 위치 나이트 이동 판단
			if(i > 0) {
				Point prePoint = list.get(i-1);
				int row = Math.abs(prePoint.x - cur.x);
				int col = Math.abs(prePoint.y - cur.y);
					
				if(row == 2 && col == 1) {			// 'L'자 이동 만족 X
					continue;
				}else if(row == 1 && col == 2) {
					continue;
				}else {
					System.out.println("Invalid");	
					return;
				}
			}	
		}
		
		// 2. 첫 번째 위치 <-> 마지막 위치 'L'자 이동 가능
		Point startPoint = list.get(0);
		Point endPoint = list.get(35);
		int row = Math.abs(startPoint.x - endPoint.x);
		int col = Math.abs(startPoint.y - endPoint.y);
		if(row == 2 && col == 1) {			// 'L'자 이동 만족 X
			System.out.println("Valid");
		}else if(row == 1 && col == 2) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");	
		}
	}

}
