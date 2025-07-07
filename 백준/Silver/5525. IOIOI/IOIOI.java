import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int result = 0;
		int cnt = 0;
		
		for(int i = 1; i < M-1; i++) {
			if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I'){
				cnt++;
				
				if(cnt == N) {
					result++;
					cnt--;
					
				}
				i++;
			}else cnt = 0;
		}
		
		System.out.print(result);

	}

}
