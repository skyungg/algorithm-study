import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			HashMap<Character, List<Integer>> map = new HashMap<>();
			for(int i = 0; i < w.length(); i++) {
				char ch = w.charAt(i);
				map.putIfAbsent(ch, new ArrayList<Integer>());
				map.get(ch).add(i);		// 현재 문재에 해당하는 인덱스를 value로 저장
				
			}
			
			int minLen = Integer.MAX_VALUE;
			int maxLen = Integer.MIN_VALUE;
			
			for(Map.Entry<Character, List<Integer>> hmap: map.entrySet()) {
				List<Integer> list = hmap.getValue();
				if(list.size() < k) continue;	// 해당 글자는 k번 미만 등장
				
				for(int i = 0; i <= list.size()-k; i++) {
					int length = list.get(i + k - 1) - list.get(i) + 1;
					minLen = Math.min(minLen, length);
					maxLen = Math.max(maxLen,  length);
				}
				
			}
			
			if(minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
				sb.append("-1\n");
			}else {
				sb.append(minLen +" "+maxLen+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
