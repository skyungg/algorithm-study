import java.io.*;
import java.util.*;

public class Main {
	static int [] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 인원 수
		int M = Integer.parseInt(st.nextToken());	// 파티 수
		
		arr = new int[N+1];
		for(int i = 1; i <= N; i++) arr[i] = i;		// 초기화
		
		
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();		
		for(int i = 0; i < T; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());	// 현재 파티 인원수
			
			List<Integer> tmp = new ArrayList<>();
			int first = -1;
			for(int j = 0; j < num; j++) {
				int t = Integer.parseInt(st.nextToken());
				tmp.add(t);
				
				if(j == 0) first = t;
				else union(first, t);		// 같은 파티 사람
			}
			list.add(tmp);
		}
		
		Set<Integer> reSet = new HashSet<>();
        for (int s : set) {
        	reSet.add(find(s));
        }
        
		// 결과
		int cnt = 0;
		for(List<Integer> tmpList: list) {
			boolean flag = true;
			
			for(int tp : tmpList) {
				for(int s : reSet) {
					if(find(tp) == find(s)) {		// 같은 그룹
						flag = false;
						break;
					}
				}
				if(!flag) break;
			}
			if(flag) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if(ra != rb) arr[rb] = ra;
	}
	
	static int find(int x) {
		if(arr[x] != x) arr[x] = find(arr[x]);
		
		return arr[x];
	}

}
