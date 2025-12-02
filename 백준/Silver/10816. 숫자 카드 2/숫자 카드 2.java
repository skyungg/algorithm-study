import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			long num = Long.parseLong(st.nextToken());
			
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			long num = Long.parseLong(st.nextToken());
			if(map.containsKey(num)) {
				sb.append(map.get(num)+" ");				
			}else {
				sb.append("0 ");
			}
		}
		
		// 정답 출력 
		System.out.println(sb);
		

	}

}
