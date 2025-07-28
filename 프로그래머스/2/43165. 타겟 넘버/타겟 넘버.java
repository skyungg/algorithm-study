/*
아이디어: dfs
1) 한 번은 +
2) 한 번은 -
*/
class Solution {
    int count = 0;      // 방법의 수
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return count;
    }
    
    void dfs(int [] numbers, int target, int idx, int sum){
        if(idx == numbers.length){  // 끝까지 다 왔을 때
            if(target == sum) count++;  // target 넘버랑 최종 sum이 같으면 -> 방법의 수 증가
            return; 
        }
        
        // 더하기
        dfs(numbers, target, idx+1, sum+numbers[idx]);
        // 빼기
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}