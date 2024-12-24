import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, cnt;
        boolean wallBroken;

        public Point(int x, int y, boolean wallBroken, int cnt) {
            this.x = x;
            this.y = y;
            this.wallBroken = wallBroken;
            this.cnt = cnt;
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2]; // 0: 벽을 부수지 않은 상태, 1: 벽을 부순 상태

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, false, 1)); // 시작점
        visited[0][0][0] = true; // 벽을 부수지 않고 방문

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 도착 지점에 도달한 경우
            if (p.x == n - 1 && p.y == m - 1) {
                return p.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위를 벗어나는 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽을 만나지 않은 경우
                if (map[nx][ny] == 0) {
                    if (!p.wallBroken && !visited[nx][ny][0]) { // 벽을 부수지 않고 이동
                        visited[nx][ny][0] = true;
                        queue.add(new Point(nx, ny, false, p.cnt + 1));
                    } else if (p.wallBroken && !visited[nx][ny][1]) { // 벽을 부순 상태로 이동
                        visited[nx][ny][1] = true;
                        queue.add(new Point(nx, ny, true, p.cnt + 1));
                    }
                }
                // 벽인 경우
                else if (map[nx][ny] == 1) {
                    if (!p.wallBroken && !visited[nx][ny][1]) { // 벽을 부수고 이동
                        visited[nx][ny][1] = true;
                        queue.add(new Point(nx, ny, true, p.cnt + 1));
                    }
                }
            }
        }

        // 도달 불가능한 경우
        return -1;
    }
}
