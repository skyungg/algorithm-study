import java.io.*;
import java.util.*;

/*
 * 아이디어 : HASH MAP
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		
		HashMap<Integer, String> idxMap = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			idxMap.put(i+1, str);
			map.put(str, i+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String key = br.readLine();
			char ch = key.charAt(0);
			if(Character.isAlphabetic(ch)) {
				sb.append(map.get(key)+"\n");
			}else sb.append(idxMap.get(Integer.parseInt(key))+"\n");
		}
		
		System.out.println(sb.toString());
	}
	

}
