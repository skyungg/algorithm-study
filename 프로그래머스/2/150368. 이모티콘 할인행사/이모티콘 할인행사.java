import java.util.*;

/* 아이디어: 완전탐색
1) 비율의 m개 조합 구하기
2) 1에서 구한 조합으로 users 한 번 돌아서 결과 산출하기
3) 전체 결과 정렬(?) 해서 최댓값 구하기 ->(list or que)
*/
class Solution {
    int [][] users;
    int [] emoticons;
    int n, m;
    int [] rates = {10, 20, 30, 40}; // 비율
    PriorityQueue<int []> que;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        n = users.length;
        m = emoticons.length;
        int[] answer = {};
        
        // 정렬 -> 1.서비스 가입자 수 최대, 2.이모티콘 판매액 최대
        que = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        
        // 이모티콘 m개 할인율 조합 만들기
        dfs(0, new int[m]);
        
        return que.poll();
    }
    
    void dfs(int depth, int [] comb){
        if(depth == m){
            // 이모티콘 비율 완성
            cal(comb);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            comb[depth] = rates[i];
            dfs(depth+1, comb);
        }
    }
    
    void cal(int [] comb){
        int cnt = 0;        // 가입자 수
        int total_price = 0;       // 총 가격
        
        for(int i = 0; i < n; i++){
            int user_price = 0;      // 현재 유저가 지출한 비용
            
            for(int j = 0; j < m; j++){
                int rate = comb[j];
                
                if(rate >= users[i][0]){
                    int sales_price = emoticons[j] * (100-rate) / 100 ; // 세일 가격
                    user_price += sales_price;
                }
            }
            
            if(user_price >= users[i][1]) cnt++;  // 최대 지출 금액 초과
            else total_price += user_price;
        }
        
        que.add(new int[] {cnt, total_price});
    }
}