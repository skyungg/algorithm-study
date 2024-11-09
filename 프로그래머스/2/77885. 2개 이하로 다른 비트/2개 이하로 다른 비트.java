class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            
            if(num%2 == 0){ // 현재 수가 짝수 -> 다음 수가 정답
                answer[i] = num+1;
            }else{
                String bin_num = Long.toBinaryString(num);
                
                if(!bin_num.contains("0")){  // 모두 0으로 이루어진 경우
                    bin_num = "10" + bin_num.substring(1);  // 앞에 10으로 시작 + 기존 앞자리 삭제
                }else{      // 1,0 으로 이루어진 경우
                    int lastIndex = bin_num.lastIndexOf("0");   // 가장 오른쪽에 있는 1의 인덱스
                    bin_num = bin_num.substring(0, lastIndex) + "10" + bin_num.substring(lastIndex + 2);
                }
                answer[i] = Long.parseLong(bin_num, 2);
            }
        }
        return answer;
    }
}