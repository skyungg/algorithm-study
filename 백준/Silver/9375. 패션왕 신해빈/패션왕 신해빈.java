import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> hmap = new HashMap<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				
				hmap.put(type,  hmap.getOrDefault(type, 0)+1);
			}
			
			// 구하기
			int result = 1;
			for(String key : hmap.keySet()) {
				result *= (hmap.get(key)+1);
			}
			
			result -= 1;
			
			sb.append(result+"\n");
		}
		
		System.out.print(sb.toString());

	}

}
