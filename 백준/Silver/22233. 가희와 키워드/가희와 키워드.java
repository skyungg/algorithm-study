import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			set.add(word);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = N; // 남은 키워드 수
        
		for(int i = 0; i < M; i++) {
			String [] arr = br.readLine().split(",");
			for(int j = 0; j < arr.length; j++) {
				if(set.contains(arr[j])) {
					set.remove(arr[j]);
					cnt--;
				};
			}
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
