import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String [] tmp = br.readLine().split(" ");
			map.put(tmp[0], tmp[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String address = br.readLine();
			sb.append(map.get(address)+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
