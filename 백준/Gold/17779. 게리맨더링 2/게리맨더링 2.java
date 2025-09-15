/*
 * 아이디어: 구현, 완탐?
 * 1. 시작점과 d1, d2 선정에 꼼수 있음? -> X
 * 	   -> 완탐 돌려서 구한 좌표들로 최솟값 갱신해나가기
 * */

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int [][] map;
	static int total_people = 0;	// 총 인원수
	static int min_diff = Integer.MAX_VALUE;	// 두 지역 간의 최소 차이
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total_people += map[i][j];	// 총 인원 카운트
            }
        }
        
        // 구현 -> 4중 for문 돌려버려~~
        for(int x = 0; x < N; x++) {
        	for(int y = 0; y < N; y++) {
        		for(int d1 = 0; d1 < N; d1++) {
                	for(int d2 = 0; d2 < N; d2++) {
                		if(x + d1 + d2 >= N) continue;				// 제시한 조건 범위 넘어감
                		if (y - d1 < 0 || y + d2 >= N) continue;
                    	
                		solve(x, y, d1, d2);
                    }
                }
            }
        }
        
        System.out.println(min_diff);
        
	}
	
	static void solve(int x, int y, int d1, int d2) {
		boolean [][] visited = new boolean[N][N];	// 방문 배열
		
		// 0. 경계선 표시
		for(int i = 0; i <= d1; i++) {
			visited[x+i][y-i] = true;
			visited[x+d2+i][y+d2-i] = true;
		}
		
		for (int i = 0; i <= d2; i++) {
			visited[x + i][y + i] = true;
			visited[x + d1 + i][y - d1 + i] = true;
        }

        int[] count = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (visited[i][j]) break;
                count[0] += map[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (visited[i][j]) break;
                count[1] += map[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (visited[i][j]) break;
                count[2] += map[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (visited[i][j]) break;
                count[3] += map[i][j];
            }
        }

        // 5 구역 인구수
        count[4] = total_people;

        for (int i = 0; i < 4; i++) {
        	count[4] -= count[i];
        }

        // 정렬
        Arrays.sort(count);

        // 최대 - 최소
        min_diff = Math.min(min_diff, count[4] - count[0]);
	}

}
