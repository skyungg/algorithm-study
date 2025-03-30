import java.io.*;
import java.util.*;

/*
 * 아이디어: 수학, 구현
 * */

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Integer.parseInt(br.readLine());
		
		// 1. 자릿수 찾기
		int total_count = 0;	// 누적개수
		int length = 1;	// 자릿수
		while(true) {
			long curLength = 1L << length;	//2^length - == Math.pow(2, length), length 자릿수인 숫자 몇 개나 만들수 있는지
			if(total_count+curLength >= k) break;		// 누적개수 + 현재 자릿수로 만들수 있는 숫자 개수가 k보다 크거나 같다면 -> 여기서 구하면 됨.
			total_count += curLength;		// 아니면, 모자라니까 누적하기
			length++;			// 길이 증가
		}
		
		
		// 2. k번째 수 찾기 -> 길이가 length 인 수 중에 정답이 있음.
		long offset = k - total_count -1;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < length; i++) {
			if(offset%2 == 0) sb.append('4');
			else sb.append('7');
			
			offset /= 2;
			
		}
		
		// 정답은 뒤집기
		System.out.println(sb.reverse().toString());

	}
}
