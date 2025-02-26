import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		char [] str = br.readLine().toCharArray();
		
		int [] minCount = new int[4];	// 조건
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			minCount[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] curCount = new int[4];	// 현재 개수
		
		// 첫 문자열 확인
		for(int i = 0; i < p; i++) {
			if(str[i] == 'A') curCount[0]++;
			else if(str[i] == 'C') curCount[1]++;
			else if(str[i] == 'G') curCount[2]++;
			else if(str[i] == 'T') curCount[3]++;
		}
		
		int result = 0;
		if(checkNum(minCount, curCount)) {
			result++;
		}
		
		for(int i = p; i < s; i++) {
			// 새문자 추가하기
			if(str[i] == 'A') curCount[0]++;
			else if(str[i] == 'C') curCount[1]++;
			else if(str[i] == 'G') curCount[2]++;
			else if(str[i] == 'T') curCount[3]++;
			
			// 이전문자 제거하기
			if(str[i-p] == 'A') curCount[0]--;
			else if(str[i-p] == 'C') curCount[1]--;
			else if(str[i-p] == 'G') curCount[2]--;
			else if(str[i-p] == 'T') curCount[3]--;
			
			if(checkNum(minCount, curCount)) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	private static boolean checkNum(int [] minCount, int [] curCount) {
		for(int i = 0; i < 4; i++) {
			if(curCount[i] < minCount[i]) {
				return false;
			}
		}
		return true;
	}

}
