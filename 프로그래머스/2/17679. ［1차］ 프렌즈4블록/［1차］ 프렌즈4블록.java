import java.util.*;

class Solution {
    int [] dx = {0, 0, 1, 1};
    int [] dy = {0, 1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        int total_score = 0;    // 전체 점수
        int cur_score = 1;      // 현재 탐색에서의 점수
        
        String[][] map = new String[m][n];
        for(int i = 0; i < m; i++){
            String [] tmp = board[i].split("");
            map[i] = tmp;
        }
        
        while(true){
            boolean [][] visited = new boolean[m][n];
            int count = 0;
            
            // 1. 2*2 블록 찾기
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    if(map[i][j].equals(" ")) continue;
                    if(map[i][j].equals(map[i][j+1]) && map[i][j].equals(map[i+1][j])
                    && map[i][j].equals(map[i+1][j+1])){   // 4개가 다 같을 경우
                        for(int k = 0; k < 4; k++){
                            if(!visited[i+dx[k]][j+dy[k]]){
                                visited[i+dx[k]][j+dy[k]] = true;
                                count++;
                            }
                        }
                    }
                }
            }
            
            if(count == 0) break;   // 더이상 지울 블록 존재 X
            
            total_score += count;
            
            // 2. 블록 제거
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        map[i][j] = " ";
                    }
                }
            }
            
            // 2. 블록 내리기
            for(int j = 0; j < n; j++){
                for(int i = m-1; i >= 0; i--){
                    if(map[i][j].equals(" ")){
                        int k = i-1;
                        
                        while(k >= 0 && map[k][j].equals(" ")) k--;
                        if(k >= 0){
                            map[i][j] = map[k][j];
                            map[k][j] = " ";
                        }
                    }
                }
            }
            
        }
        
        return total_score;
    }
    
    
}