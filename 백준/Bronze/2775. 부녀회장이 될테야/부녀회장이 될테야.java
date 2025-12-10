import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n, k;
		
		StringBuilder sb = new StringBuilder();
		
		// dp 로 구현
		int [][] room = new int[15][15];	// 최댓값 14
		
		for(int c = 1; c < 15; c++) {		// 0층 모든 호수 인원 채우기
			room[0][c] = c;
		}
		
		for(int r= 1; r < 15; r++) room[r][1] = 1;	// 모든 층의 1호 인원수는 1
		
		
		for(int r = 1; r < 15; r++) {
			for(int c = 2; c < 15; c++) {
				room[r][c] = room[r-1][c] + room[r][c-1];
			}
		}
		
		for(int t = 0; t < T; t++) {
			k = Integer.parseInt(br.readLine());	// 행
			n = Integer.parseInt(br.readLine());	// 열
			
			sb.append(room[k][n]+"\n");
			
		}

		System.out.println(sb);
		
	}

}
