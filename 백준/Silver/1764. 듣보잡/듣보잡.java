import java.io.*;
import java.util.*;

/*
 * 아이디어: List 2개 -> 시간초과  or 정렬
 * 			-> set
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		
		Set<String> set = new HashSet<>();
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) result.add(name);
		}
		
		// 정렬
		Collections.sort(result);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()+"\n");
		for(String name: result) sb.append(name+"\n");
		System.out.println(sb.toString());

	}

}
