import java.io.*;
import java.util.*;

/*
 * (구) 미로 지도 
 * [초기정보]
 * 남쪽을 보고 서있음(0:남, 1:서, 2:북, 3: 동)
 * F: (1, 0), L, R: 방향 전환
 * .: 이동, #: 벽
 * 아이디어: 구현
 * 1. 지도 크기 모름 -> 중간에서 시작하기 (50, 50)
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String [] str = br.readLine().split("");
		
		int [] dx = {1, 0, -1, 0};
		int [] dy = {0, -1, 0, 1};
		int dir = 0;	//  초기 방향 - 남쪽
		int [][] map = new int [101][101];		// 주어진 길의 최댓값 50
		int x = 50;
		int y = 50;
		int maxX = 50;
		int maxY = 50;
		int minX = 50;
		int minY = 50;
		map[x][y] = 1;		// 현재 방문한 위치 
		
		for(int i = 0; i < N; i++) {
			String op = str[i];		//  지시
			if(op.equals("F")) {		// 앞으로 이동
				x += dx[dir];
				y += dy[dir];
				map[x][y] = 1;		// 이동한 자리 방문처리
				
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				
			}else if(op.equals("L")) {	// 왼쪽으로 방향 전환
				dir = (dir+3)%4;
			}else {						// 오른쪽으로 방향 전환
				dir = (dir+1)%4;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				if(map[i][j] == 1)sb.append(".");
				else sb.append("#");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
