import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 (첫번째 원소 기준으로 정렬하기
		Arrays.sort(map, (a, b) -> a[0] - b[0]);
		
		// 가장 높은 기둥의 인덱스 찾기
		int maxHeight = 0;
		int maxIdx = 0;
		for(int i = 0; i < N; i++) {
			if(map[i][1] > maxHeight) {
				maxHeight = map[i][1];		// 값 갱신해주기
				maxIdx = i;
			}
		}
		
		int sum = 0;
		// 왼쪽부터 현재까지 최고 높이 유지하면서 넓이 더하기
		int leftHeight = map[0][1];
		int preLeft = map[0][0];	// 이전 기둥의 X 좌표
		for(int i = 0; i <= maxIdx; i++) {
			if(map[i][1] >= leftHeight) {		// 현재 높이가 이전높이 보다 클 때 -> 갱신
				sum += (map[i][0] - preLeft) * leftHeight;
				leftHeight = map[i][1];
				preLeft = map[i][0];
			}
		}
		
		// 오른쪽부터 현재까지 최고 높이 유지하면서 넓이 더하기
		int rightHeight = map[N-1][1];
		int preRight = map[N-1][0];
		for(int i = N-2; i >= maxIdx; i--) {
			if(map[i][1] >= rightHeight) {
				sum += (preRight - map[i][0]) * rightHeight;
				rightHeight = map[i][1];
				preRight = map[i][0];
			}
		}
		
		sum += maxHeight;
		
		System.out.println(sum);

	}

}
