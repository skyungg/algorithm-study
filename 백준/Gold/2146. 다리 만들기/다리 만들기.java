import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};	// 사방탐색
    private static int[] dy = {0, -1, 0, 1};
    private static int landNum = 2; // 섬 마킹 시작 번호
    private static int minCount;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        minCount = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) { // 섬 별 마킹 전
                    marked(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {	// 섬일 경우 최단거리 구하러 가기
                    visited = new boolean[N][N]; // 방문 배열 재사용위해 초기화
                    bfs(i, j);
                }
            }
        }
        System.out.println(minCount);
    }

    // 각 섬별로 마킹해주기(2부터 시작)
    private static void marked(int r, int c) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(r, c, 0));
        
        visited[r][c] = true;
        map[r][c] = landNum;
        
        while (!que.isEmpty()) {
            Point point = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = point.r + dx[i];
                int nc = point.c + dy[i];
                
                // 범위 내에 존재 + 아직 방문 전 + 육지 -> 마킹
                if ((nr >= 0 && nr < N && nc >= 0 && nc < N) && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    map[nr][nc] = landNum;
                    que.offer(new Point(nr, nc, 0));
                }
            }
        }
        landNum++;	// 한 섬 끝날때마다 섬 번호 증가
    }

    private static void bfs(int r, int c) {
        Queue<Point> que = new LinkedList<Point>();
        que.offer(new Point(r, c, 0));
        
        int curNum = map[r][c];// 현재 마킹된 섬의 번호
        visited[r][c] = true;
        
        while (!que.isEmpty()) {
            Point point = que.poll();
            for (int i = 0; i < 4; i++) {
            	
                int nr = point.r + dx[i];
                int nc = point.c + dy[i];
                
                // 범위 내에 존재 + 방문 전 + 현재 출발한 섬이 아닌경우(바다 or 다른 섬)
                if ((nr >= 0 && nr < N && nc >= 0 && nc < N) 
                		&& !visited[nr][nc] && map[nr][nc] != curNum) { 
                	
                    visited[nr][nc] = true;
                    
                    if (map[nr][nc] == 0) { // 바다인 경우 -> que에 넣기(바다는 지나갈거니까)
                        que.offer(new Point(nr, nc, point.count + 1));
                    } else { // 다른 섬 만났을 경우 -> 지금까지 count와 최소 다리 길이 비교해서 갱신
                        minCount = Math.min(minCount, point.count);
                    }
                }
            }
        }
    }

    static class Point {
        int r;
        int c;
        int count;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.count = cnt;
        }
    }

}
