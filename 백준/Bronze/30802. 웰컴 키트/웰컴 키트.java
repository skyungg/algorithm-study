import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 참가자 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[6];
		for(int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());		// 사이즈별 신청자 수
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());		// 정수 티셔츠
		int P = Integer.parseInt(st.nextToken());		// 펜의 묶음수
		
		StringBuilder sb = new StringBuilder();
		// 1. 티셔츠 묶음 최소 수 구하기
		int tshirt = 0;
		for(int i = 0; i < 6; i++) {
			if(arr[i] > T) {
				tshirt += (arr[i] / T);
				if(arr[i]%T != 0) tshirt++;		
			}else if(arr[i] > 0) tshirt++;
		}
		
		sb.append(tshirt+"\n");
		
		// 2. 펜의 묶음 수 
		int quo = N/P;
		int mod = N%P;
		sb.append(quo+" "+mod);
		
		// 정답 출력 
		System.out.println(sb);
		
		
		
	}

}
