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

		for(int r = 0; r < 15; r++) {
			for(int c = 1; c < 15; c++) {
                if(r==0){                // 0층 호수 초기 셋팅 
                    room[r][c] = c;
                    continue;
                }
                
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
