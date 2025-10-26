import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split("");
		
		int N = arr.length;
		int total_a = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i].equals("a")) total_a++;
		}
		
		int min_cnt = total_a;		// 최악의 경우, a의 총 개수만큼 바꿔야하니까 초기값으로 설정
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			
			for(int j = i; j < i+total_a; j++) {
				if(arr[j%N].equals("b")) cnt++;
			}
			min_cnt = Math.min(min_cnt, cnt);
			
		}
		
		System.out.println(min_cnt);

	}

}
