class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int point = 1;      // 현재 위치
        int coverage = 2 * w + 1;   // 기지국 영향 범위
        
        // 전처리
        for(int station : stations){
            int start = station - w;    // 기지국 시작 영향권 위치
            int end = station + w;  // 기지국 마지막 영향권 위치
            
            if(point  < start){
                int empty = start - point;    // 포함 되지 않는 영역 수
                answer += (empty+coverage-1)/coverage;
            }
            
            point = end + 1;    // 위치 갱신 -> 현재 영향권의 마지막 위치 +1인 위치
        }
        
        // 남은 거 처리
        if(point <= n){
            int empty = n - point +1;
            answer += (empty+coverage-1)/coverage;
        }

        return answer;
    }
}