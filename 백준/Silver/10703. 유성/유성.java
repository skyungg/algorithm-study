import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		char [][] map = new char[R][S];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int limit_row = 0;
		int minDiff = Integer.MAX_VALUE;		// 땅-유성 가장 작은 차이
		
		for(int s = 0; s < S; s++) {
			int start_meteor = -1;	// 가장 큰 start_row값
			int start_ground = R+1;
			
			for(int r = 0; r < R; r++) {
				if(map[r][s] == ('X')) start_meteor = r;
				else if(map[r][s] == ('#')) {
					start_ground = r;
					break;
				}
			}
			
			if(start_meteor == -1) continue;		// 현재 열에서 유성 존재X;
			if(start_ground == R+1) continue;		// 현재 열에 땅 존재X;
			
			minDiff = Math.min(minDiff,  start_ground - start_meteor - 1);
		}
		
		// 끌어 당기기 
		for(int r = R-1; r >= 0; r--) {
			for(int s = 0; s < S; s++) {
				if(map[r][s] == ('X')) {
					if(r+minDiff < R) {
						map[r+minDiff][s] = 'X';
						map[r][s] = '.';
					}
				}
			}
			
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < R; r++) {
			for(int s = 0; s < S; s++) {
				sb.append(map[r][s]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
