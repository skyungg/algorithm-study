import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] str = br.readLine().split(""); 	// 첫 번째 문자
		HashMap<String, Integer> hmap = new HashMap<>();
		for(int i = 0; i < str.length; i++) {
			hmap.put(str[i], hmap.getOrDefault(str[i], 0)+1);
		}
		
		int result = 0;
		for(int i = 0; i < n-1; i++) {
			String [] tmp = br.readLine().split("");
			HashMap<String, Integer> tmpMap = new HashMap<>();
			for(int j = 0; j < tmp.length; j++) {
				tmpMap.put(tmp[j], tmpMap.getOrDefault(tmp[j], 0)+1);
			}
			
			Set<String> keySet = new HashSet<>();
			keySet.addAll(hmap.keySet());
			keySet.addAll(tmpMap.keySet());
			
			int totalDiff = 0;
			for(String key : keySet) {
				int hmapCnt = hmap.getOrDefault(key, 0);
				int tmapCnt = tmpMap.getOrDefault(key, 0);
				totalDiff += Math.abs(hmapCnt - tmapCnt);
			}
			
			int len1 = str.length;
			int len2 = tmp.length;
			int strDiff = Math.abs(len1 - len2);
			
			if(totalDiff == 0) result++;
			else if(totalDiff == 1 && strDiff == 1) result++;
			else if(totalDiff == 2 && strDiff == 0) result++;
		}
		
		System.out.println(result);

	}

}
