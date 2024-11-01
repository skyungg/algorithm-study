import java.util.*;

class Solution {
    public int[] solution(int n) {
        int [][] map = new int[n][n];
        int limit_num = 0;
        for(int i = 1; i < n; i++){
            limit_num += i;
        }
        limit_num = n*n - limit_num;    // 제한 숫자
        int [] answer = new int[limit_num];
        int cur_num = 1;    // 현재 숫자
        
        int [] dx = {1, 0, -1};   // cycle 증감
        int [] dy = {0, 1, -1};
        
        int cx = 0; // 현재 좌표
        int cy = 0;
        int direction = 0;  // 현재 방향
        
        while(cur_num <= limit_num){
            map[cx][cy] = cur_num++;    // 1. 우선 채워넣기
            
            int nx = cx + dx[direction];
            int ny = cy + dy[direction];
            
            // 2. 좌표 변환 후 체크
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0){
                // 2.1 방향 전환 필요
                direction = (direction+1) % 3;
                nx = cx + dx[direction];
                ny = cy + dy[direction];
            }
            
            // 3. 위치 갱신
            cx = nx;
            cy = ny;
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                answer[count++] = map[i][j];
            }
        }
        
        return answer;
    }
}