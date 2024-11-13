import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int [][] distance = new int[N+1][N+1];
        
        for(int i = 1; i <= N; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);    // 모든 값 -> 최댓값
            distance[i][i] = 0; // 자기 자신은 0
        }
        
        for(int [] r : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            distance[a][b] = Math.min(distance[a][b], c);
            distance[b][a] = Math.min(distance[b][a], c);
        }
        
        // 플로이드 와샬
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(distance[1][i] <= K) answer++;
        }

        return answer;
    }
}