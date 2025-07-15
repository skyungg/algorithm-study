import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Integer, Integer> hmap = new HashMap<>();
		int maxLen = 0;		// 최대 과일 개수
		int left = 0;
		
		for(int right = 0; right < N; right++) {
			hmap.put(arr[right], hmap.getOrDefault(arr[right], 0) + 1);
			
			while(hmap.size() > 2) {
				hmap.put(arr[left], hmap.get(arr[left])-1);
				
				if(hmap.get(arr[left]) == 0) {
					hmap.remove(arr[left]);
				}
				
				left++;
			}
			
			maxLen = Math.max(maxLen, right - left +1);

		}
		
		System.out.println(maxLen);
		
	}

}
