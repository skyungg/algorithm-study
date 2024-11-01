class Solution {
    int[][] arr;
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        this.arr = arr;
        int n = arr.length; // 길이
        
        getQuad(0, n, 0, n);
        
        return answer;
    }
    
    void getQuad(int sx, int ex, int sy, int ey){
        // 최후, 1*1 크기의 쿼드 도착
        if(ex - sx == 1 && ey - ex == 1){
            if(arr[sx][sy] == 0) answer[0] += 1;
            else answer[1] += 1;
            return;
        }
        
        int cur_num = arr[sx][sy];
        boolean flag = true;
        
        for(int i = sx; i < ex; i++){
            for(int j = sy; j < ey; j++){
                if(arr[i][j] != cur_num){
                    flag = false;
                    break;
                }
            }
        }
        
        if(!flag){
            int midX = (sx+ex) / 2;
            int midY = (sy+ey) / 2;
            
            getQuad(sx, midX, sy, midY);
            getQuad(midX, ex, sy, midY);
            getQuad(sx, midX, midY, ey);
            getQuad(midX, ex, midY, ey);  
        }else{
            if(arr[sx][sy] == 0){
                answer[0] += 1;
            }
            else{
                answer[1] += 1;
            }
        }
    }
}
