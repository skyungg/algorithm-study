/*
아이디어: PriorityQueue
세부: 방향키를 두자!
기존의 최단거리 알고리즘 + 방향키
방향키가 달라지면 -> 코너 -> 500추가
추가) 
1. 각 방향별 최소 비용 배열
2. 코너 비용: 기존의 도로 비용 + 500

*/
import java.util.*;

class Solution {
    class Point implements Comparable<Point>{
        int x;      // 행
        int y;      // 열
        int cost;      // 비용
        int direction;  // 방향
        
        public Point(int x, int y, int cost, int direction){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
        
        @Override
        public int compareTo(Point p){
            return this.cost - p.cost;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        
        answer = dijkstra(board, 0, 0);
        
        return answer;
    }
    
    int dijkstra(int [][] board, int sx, int sy){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int dx[] = {-1, 0, 1, 0};   // 상, 우, 하, 좌
        int dy[] = {0, 1, 0, -1};
        int n = board.length;
        int total = 0;
        int [][][] minBoard = new int[n][n][4];     // 각 방향별 최소 비용 저장
        // 초기 셋팅
        for(int [][] mb : minBoard){
            for(int [] dir : mb){
                Arrays.fill(dir, Integer.MAX_VALUE);
            }
        }
        
        // 0, 0 위치 셋팅
        for(int i = 0; i < 4; i++){
            pq.add(new Point(0, 0, 0, i));
            minBoard[0][0][i] = 0;
        }
        
        pq.add(new Point(0, 0, 0, 0));
        
        while(!pq.isEmpty()){
            Point p = pq.poll();
            
            if(p.x == n-1 && p.y == n-1){
                total = p.cost;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                int tCost = p.cost;
                if(p.direction == i){
                    tCost += 100;
                }else tCost += 600;
                
                if(isRange(tx, ty, n) && board[tx][ty] == 0){
                    if(minBoard[tx][ty][i] > tCost){
                        minBoard[tx][ty][i] = tCost;
                        pq.add(new Point(tx, ty, tCost, i));
                    }
                }
            }
        }
        
        return total;
    }
    
    boolean isRange(int x, int y, int n){
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
}