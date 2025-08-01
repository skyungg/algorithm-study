import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int r;
		int c;
		int m;
		int s;
		int d;
		
		public Point(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N;
	static int [] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int [] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int [] coArr = {0, 2, 4, 6};
	static int [] sinArr = {1, 3, 5, 7};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		HashMap<String, List<Point>> hmap = new HashMap<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			String key = r + "," + c;
			if(hmap.containsKey(key)) {
				hmap.get(key).add(new Point(r, c, m, s, d));
			}else {
				List<Point> list = new ArrayList<>();
				list.add(new Point(r, c, m, s, d));
				hmap.put(key, list);
			}
//			hmap.put(key, hmap.getOrDefault(key, new ArrayList<>()).add(new Point(r, c, m, s, d)));
		}
		
		
		
		for(int k = 0; k < K; k++) {
			HashMap<String, List<Point>> newMap = new HashMap<>();
			
			for(String key : hmap.keySet()) {
//				List<Point> tmp = hmap.get(key);
				
				for(int i = 0; i < hmap.get(key).size(); i++) {
					Point p = hmap.get(key).get(i);
					// map은 연결되어 있으니까 범위 체크 대신 
					int tx = (p.r + dx[p.d]*p.s)%N;
					int ty = (p.c + dy[p.d]*p.s)%N;
					
					if(tx < 0) tx += N;
					if(ty < 0) ty += N;
					
					String newKey = tx+","+ty;

					if(newMap.containsKey(newKey)) {
						newMap.get(newKey).add(new Point(tx, ty, p.m, p.s, p.d));
					}else {
						List<Point> list = new ArrayList<>();
						list.add(new Point(tx, ty, p.m, p.s, p.d));
						newMap.put(newKey, list);
					}
					
//					newMap.getOrDefault(k, new ArrayList<>()).add(new Point(tx, ty, p.m, p.s, p.d));
				}
			}
			
			// 겹치는 파이어볼 해결하기
			Iterator<String> it = newMap.keySet().iterator();
			
			while(it.hasNext()){
				String nKey = it.next();
				
				String [] keys = nKey.split(",");
				int x = Integer.parseInt(keys[0]);
				int y = Integer.parseInt(keys[1]);
				
				if(newMap.get(nKey).size() > 1) {
					// 한 위치에 2개 이상 있을 경우에만
					List<Point> tmpList = newMap.get(nKey);
					boolean oddFlag = false;		// 홀수
					boolean evenFlag = false;		// 짝수
					int mSum = 0;		// 질량 합
					int sSum = 0;		// 속력 합
					
					for(int i = 0; i < tmpList.size(); i++) {
						Point p = tmpList.get(i);
						mSum += p.m;
						sSum += p.s;
						
						if(p.d%2 == 0) evenFlag = true;
						else oddFlag = true;
					}
					// 방향 정리
					mSum /= 5;
					if(mSum == 0) {
						// 기존 파이어볼 삭제하기
						it.remove();
						continue;
					}
					sSum /= tmpList.size();
					newMap.get(nKey).clear();	// 현재 위치에 있는 정보 지우기
					List<Point> newList = new ArrayList<>();
					if((oddFlag && !evenFlag) || (!oddFlag && evenFlag)) {
						// 0, 2, 4, 7
						for(int j = 0; j < 4; j++) {
							newList.add(new Point(x, y, mSum, sSum, coArr[j]));
						}
					}else {
						// 1, 3, 5, 7
						for(int j = 0; j < 4; j++) {
							newList.add(new Point(x, y, mSum, sSum, sinArr[j]));
						}
					}
					newMap.put(nKey, newList);
				}
			}
			// newMap -> hmap
			hmap = newMap;
		}
		
		// 정답
		
		int result = 0;
		for(String key : hmap.keySet()) {
			for(int i = 0; i < hmap.get(key).size(); i++) {
				result += hmap.get(key).get(i).m;
			}
		}
		
		System.out.println(result);
		
	}
}
