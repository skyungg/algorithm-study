import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int [] parent = new int[100001];
	static int [] time = new int[100001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();	// 그래프 탐색
		
		// stack에 거꾸로 담고 pop해서 순서대로
		Stack<Integer> stack = new Stack<>();
		stack.push(k);	// 도착지 먼저
		int idx = k;
		
		while(idx != n) {
			stack.push(parent[idx]);
			idx = parent[idx];
		}
		
		// 정답
		StringBuilder sb = new StringBuilder(time[k]-1+"\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		time[n] = 1;	// 자기 자신 방문 시간은 1
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			if(cur == k) return;	// 목적지 도착
			
			int [] tmp = {cur-1, cur+1, cur*2};
			
			for(int i = 0; i < tmp.length; i++) {
				if(tmp[i] < 0 || tmp[i] > 100000) continue;
				
				if(time[tmp[i]] == 0) {
					// 아직 방문전
					que.add(tmp[i]);
					time[tmp[i]] = time[cur]+1;
					parent[tmp[i]] = cur;
				}
			}
		}
	}
}
