import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [][] map = new String[n][n];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().split("");
			
		}
		
		int hr = 0;		// 머리 좌표
		int hc = 0;
		// 1. 머리 찾기
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].equals("*")) {
					hr = i;
					hc = j;
					flag = true;
					break;
					
				}
			}
			if(flag) break;
		}
		
		int hx = hr+2;
		int hy = hc+1;
		StringBuilder sb = new StringBuilder();
		sb.append(hx+" "+hy+"\n");		// 심장 위치
		
		int cnt = 0;
		// 왼쪽 팔 (행고정)
		for(int i = hc-1; i >= 0; i--) {
			if(map[hr+1][i].equals("*")) {
				cnt++;
			}else break;
		}
		sb.append(cnt+" ");
		// 오른쪽 팔 (행 고정)
		cnt = 0;
		for(int i = hc+1; i < n; i++) {
			if(map[hr+1][i].equals("*")) {
				cnt++;
			}else break;
		}
		sb.append(cnt+" ");
		
		// 허리 (열 고정)
		int ex = 0;
		int ey = hc;
		cnt = 0;
		for(int i = hr+2; i < n; i++) {
			if(map[i][hc].equals("*")) {
				cnt++;
			}else {
				ex = i;
				break;
			}
		}
		sb.append(cnt+" ");
		// 왼쪽 다리 (열 고정)
		cnt = 0;
		
		for(int i = ex; i < n ;i++) {
			if(map[i][hc-1].equals("*")) {
				cnt++;
			}else break;
		}
		sb.append(cnt+" ");
		
		//오른쪽 다리
		cnt = 0;
		for(int i = ex; i < n ;i++) {
			if(map[i][hc+1].equals("*")) {
				cnt++;
			}else break;
		}
		sb.append(cnt+" ");
		
		System.out.println(sb.toString());
	}

}
