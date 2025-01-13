
/*
 * 변형된 테트로미노만큼 돌리기
 * 1)2개
 * 2)1개
 * 3)8개
 * 4)4개
 * 5)4개
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][][] dir = {{{0,1}, {0,2}, {0,3}}, // 1자 모양 가로
	            {{1,0}, {2,0}, {3,0}}, // 세로
	            {{0,1}, {1,0}, {1,1}}, // ㅁ 자 모양
	            {{1,0}, {2,0}, {2,-1}}, // ㄴ자 모양
	            { {1,0}, {2,0}, {2,1}},
	            { {0,-1}, {0,-2}, {1,0}},
	            { {0,1}, {0,2}, {1,0}},
	            {{0,1}, {1,1}, {2,1}},
	            { {0,-1}, {1,-1}, {2,-1}},
	            {{0,-1}, {0,-2}, {-1,0}},
	            { {0,1}, {0,2}, {-1,0}},
	            {{1,0}, {1,1}, {2,1}}, // 네번째 모양
	            {{0,1}, {-1,1}, {-1,2}},
	            {{1,0}, {1,-1}, {2,-1}},
	            { {0,1}, {1,1}, {1,2}},
	            {{0,1}, {0,2}, {1,1}},  // ㅗ
	            {{1,0}, {2,0}, {1,1}},  // ㅏ
	            {{0,1}, {0,2}, {-1,1}}, // ㅜ
	            {{1,0}, {2,0}, {1,-1}}  // ㅓ
	    };
		    
		int maxSum = 0;
		// 테트로미노의 최대 합 구하기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int d = 0; d < dir.length; d++) {
					int curSum = arr[i][j];
					boolean flag = true;
					for(int k = 0; k < 3; k++) {
						int tx = i + dir[d][k][0];
						int ty = j + dir[d][k][1];
						
						if(isRange(tx, ty)) {
							curSum += arr[tx][ty];
						}else {
							flag = false;
							break;	
						}
						
					}
					
					if(flag) {
//						curSum += arr[i][j];
						maxSum = Math.max(maxSum, curSum);
					}
				}
			}
		}
		
		System.out.println(maxSum);
	}
	
	static boolean isRange(int i, int j) {
		if(i >= 0 && i < n && j >= 0 && j < m) return true;
		
		return false;
	}

}
