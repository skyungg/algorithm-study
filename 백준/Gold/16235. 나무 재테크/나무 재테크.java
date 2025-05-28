/*
 * 아이디어 : 구현
 * 
 * */
import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int age;
		
		public Point(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public int compareTo(Point p) {		// 나이 오름차순 정렬
			return this.age - p.age;
		}
	}
	
	static int n, m, k;
	static int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int [][] map;
	static int [][] nutrient;
	static Deque<Point> deque = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());		// 크기
		m = Integer.parseInt(st.nextToken());		// 나무 개수
		k = Integer.parseInt(st.nextToken());		// 시간
		
		map = new int[n][n];		// 현재 양분 상태
		nutrient = new int[n][n]; 	// 추가 할 양분 저장
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				nutrient[i][j] = Integer.parseInt(st.nextToken());	// 겨울에 추가할 양분 저장
				map[i][j] = 5;	// 초기 양분
			}
		}
		
		List<Point> tmpTree = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			
			tmpTree.add(new Point(x, y, age));
		}
		
		// 초기 정렬 -> 나이 오름차순
		Collections.sort(tmpTree);
		deque.addAll(tmpTree);
	
		for(int i = 0; i < k; i++) {
			goSpring();
		}
		
		// 정답 출력
		System.out.print(deque.size());

	}
	
	static void start() {
		// 봄
		goSpring();
	}
	
	static void goSpring() {
		// 1. 양분 먹이기
		Deque<Point> newDeque = new LinkedList<>();
		int [][] dead = new int[n][n];
		
		while(!deque.isEmpty()) {
			Point p = deque.poll();
			
			if(p.age <= map[p.x][p.y]) {
				map[p.x][p.y] -= p.age;
				newDeque.add(new Point(p.x, p.y, p.age+1)); 	// 나이 증가
			}else {
				dead[p.x][p.y] += p.age/2;	// 죽은 나무
			}
		}
		deque = newDeque;
		goSummer(dead);
		
	}
	
	static void goSummer(int [][] dead) {
		// 2. 죽은 나무를 양분으로 저장
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] += dead[i][j];
			}
		}

		goFall();
	}
	
	static void goFall() {
		// 3. 나무 번식하기
		Deque<Point> newDeque = new LinkedList<>();
		
		for(Point p: deque) {
			if(p.age % 5 == 0) {		// 5의 배수일 경우에만 번식
				for(int idx = 0; idx < 8; idx++) {
					int tx = p.x + dx[idx];
					int ty = p.y + dy[idx];
					
					if(checkRange(tx, ty)) {
						newDeque.addFirst(new Point(tx, ty, 1)); 	// 새로운 나무 번식 -> 맨 앞에 추가
					}
				}
			}
		}
		
		while(!deque.isEmpty()) {
			newDeque.addLast(deque.poll()); 	// 새로 번식된 나무 뒤에 기존 나무 삽입
		}
		deque = newDeque;

		// 겨울로 이동
		goWinter();
	}
	
	static void goWinter() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] += nutrient[i][j];
			}
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	

}
