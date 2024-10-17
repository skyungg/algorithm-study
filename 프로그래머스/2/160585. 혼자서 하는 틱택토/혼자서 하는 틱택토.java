import java.util.*;

class Solution {
    static int [][] map;
    
    public int solution(String[] board) {
        int answer = 0;
        map = new int[3][3];
        
        int oCount = 0;
        int xCount = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                char ch = board[i].charAt(j);
                if('O' == ch){
                    map[i][j] = 1;
                    oCount++;
                }else if('X' == ch){
                    map[i][j] = -1;
                    xCount++;
                }
            }
        }
        
        // 선-후공 수 안 맞음
        if(oCount < xCount || oCount > xCount+1) return 0;
        
        boolean oWin = checkTickTackTock(1);
        boolean xWin = checkTickTackTock(-1);
    
        if(oWin && xWin) return 0;  // 둘 다 이긴 상황
        if(oWin && oCount == xCount) return 0;  // 선공이 이겼는데도 계속 게임 진행
        if(xWin && oCount > xCount) return 0; // 후공이 이겼는데도 계속 게임 진행
        
        return 1;
    }
    
    boolean checkTickTackTock(int player){
        // 가로 - 세로
        for(int i = 0; i < 3; i++){
            // 가로
            if(map[i][0] == player && map[i][1] == player && map[i][2] == player) return true;
            
            // 세로
            if(map[0][i] == player && map[1][i] == player && map[2][i] == player) return true;
        }
        
        // 대각선
        if(map[0][0] == player && map[1][1] ==  player && map[2][2] ==  player) return true;
        if(map[0][2] == player && map[1][1] ==  player && map[2][0] ==  player) return true;
        
        return false;
    }
}