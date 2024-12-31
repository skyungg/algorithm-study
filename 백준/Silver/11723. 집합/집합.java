import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int res = 0;	// 비트 마스킹 숫자
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("add")){
				int n = Integer.parseInt(st.nextToken());
				res |= (1 <<(n-1));	// 1을 왼쪽으로 (n-1)만큼 이동 -> res와 or 연산
				
			}else if(op.equals("remove")){
				int n = Integer.parseInt(st.nextToken());
				res &= ~(1 <<(n-1));	// 1을 왼쪽으로 (n-1)만큼 이동 -> 해당 위치 제외하고 모두 1로 만들기 -> and 연산
				
			}else if(op.equals("check")){
				int n = Integer.parseInt(st.nextToken());
				if ((res & (1 << (n - 1))) > 0) {		// n번째만 1만들기 -> 반전으로 n번째 0 나머지 1 -> and연산(특정위치 0)
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
				
			}else if(op.equals("toggle")){
				int n = Integer.parseInt(st.nextToken());
				 res ^= (1 << (n - 1));		// n번째만 1 나머지  0 -> xor 연산으로 해당 위치만 비트 반전
				
			}else if(op.equals("all")){	
				res = (1 << 20) - 1;		// 모든 비트 1로 설정
			}else if(op.equals("empty")){
				res = 0;
			}
		}
		System.out.println(sb.toString());
	}

}
