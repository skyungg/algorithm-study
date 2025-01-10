import java.util.*;

class Solution {
    class Point implements Comparable<Point> {
        int idx;
        int w;

        public Point(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Point p) {
            return this.w - p.w;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Point>> graph = new ArrayList<>();

        // 0. 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int c = path[2];
            graph.get(a).add(new Point(b, c));
            graph.get(b).add(new Point(a, c));
        }

        // 1. 게이트와 산봉우리 집합 생성
        Set<Integer> gateSet = new HashSet<>();
        for (int gate : gates) {
            gateSet.add(gate);
        }

        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }

        // 2. 다익스트라 수행
        int[] intensity = dijkstra(n, graph, gates, summitSet, gateSet);

        // 3. 산봉우리 중 최소 intensity 찾기
        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (intensity[summit] < minIntensity ||
                (intensity[summit] == minIntensity && summit < minSummit)) {
                minSummit = summit;
                minIntensity = intensity[summit];
            }
        }

        return new int[]{minSummit, minIntensity};
    }

    int[] dijkstra(int n, List<List<Point>> graph, int[] gates, Set<Integer> summitSet, Set<Integer> gateSet) {
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int gate : gates) {
            pq.add(new Point(gate, 0)); // 출입구 번호, 가중치
            result[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (p.w > result[p.idx]) continue;

            for (Point neighbor : graph.get(p.idx)) {
                int nextIdx = neighbor.idx;
                int nextW = Math.max(p.w, neighbor.w);

                // 게이트로 돌아가는 경우 제외
                if (gateSet.contains(nextIdx)) continue;

                // 산봉우리에 도달하면 더 이상 탐색하지 않음
                if (summitSet.contains(p.idx)) continue;

                if (nextW < result[nextIdx]) {
                    result[nextIdx] = nextW;
                    pq.add(new Point(nextIdx, nextW));
                }
            }
        }

        return result;
    }
}
