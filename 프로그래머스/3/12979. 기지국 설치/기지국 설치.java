class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int s=0;
        int left =1;
        while(true){
        if(s < stations.length && left >= stations[s] - w){
            left = stations[s]+w+1;
            s++;            
        }
        else{     
            left=left+w+w+1;
            answer++;
        }
        if(left> n){
            break;
        }
    }

        return answer;
    }
}