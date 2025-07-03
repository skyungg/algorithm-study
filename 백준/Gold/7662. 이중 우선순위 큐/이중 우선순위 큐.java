import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			HashMap<Long, Integer> map = new HashMap<>();
			
			PriorityQueue<Long> minPq = new PriorityQueue<>();
			PriorityQueue<Long> maxPq = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				Long n = Long.parseLong(st.nextToken());
				
				if(op.equals("I")) {
					minPq.add(n);
					maxPq.add(n);
					if(map.containsKey(n)) map.put(n,  (map.get(n))+1);
					else map.put(n, 1);
					
				}else {
					if(n > 0) { // 최댓값 삭제
						while(!maxPq.isEmpty()) {
							long target = maxPq.poll();
							if(map.get(target) > 0) {
								map.put(target, map.get(target)-1);
								break;
							}
						}
					}else if(n < 0) {	// 최솟값 삭제
						while(!minPq.isEmpty()) {
							long target = minPq.poll();
							if(map.get(target) > 0) {
								map.put(target, map.get(target)-1);
								break;
							}
						}
					}
					
				}
			}
			
			long minNum = check(minPq, map);
			long maxNum = check(maxPq, map);;

			if(minNum == Long.MAX_VALUE || maxNum == Long.MAX_VALUE) {
				sb.append("EMPTY"+"\n");
			}else {
				sb.append(maxNum +" "+ minNum+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static long check(PriorityQueue<Long> pq, HashMap<Long, Integer> hmap) {
		while(!pq.isEmpty()) {
			long res = pq.poll();
			
			if(hmap.getOrDefault(res, 0) > 0) {
				return res;
			}
		}
		
		return Long.MAX_VALUE;
	}

}
