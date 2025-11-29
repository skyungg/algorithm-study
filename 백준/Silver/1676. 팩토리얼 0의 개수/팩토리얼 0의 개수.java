import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1.팩토리얼 구하기
		int count = 0;
		
		for(int i = 5; i <= N; i*=5) {
			count += N/i;
		}

		System.out.println(count);

	}

}
