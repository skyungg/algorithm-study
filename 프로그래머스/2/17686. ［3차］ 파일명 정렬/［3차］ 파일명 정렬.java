import java.util.*;

class Solution {
    class File{
        String head;
        int number;
        int idx;
        String fileName;
        
        public File(String head, int number, int idx, String fileName){
            this.head = head;
            this.number = number;
            this.idx = idx;
            this.fileName = fileName;
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();
        // File [] fileArr = new File[files.length];
        
        for(int i = 0; i < files.length; i++){
            // 0. 대문자로 통일
            String str = files[i].toUpperCase();
            // 1. head 구하기
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            for(int j = 0; j < str.length(); j++){
                if(Character.isDigit(str.charAt(j))){
                    idx = j;
                    break;
                }
                sb.append(str.charAt(j));
            }
            String head = sb.toString();
            
            // 2. NUMBER 구하기
            StringBuilder sn = new StringBuilder();
            for(int j = idx; j < str.length(); j++){
                if(!Character.isDigit(str.charAt(j))){
                    break;
                }
                sn.append(str.charAt(j));
            }
            
            int number = Integer.parseInt(sn.toString());
            
            // 저장
            list.add(new File(head, number, i, files[i]));
            // fileArr[i] = new File(head, number, i, files[i]);    
        }
        
        // 2.파일명 정리
        Collections.sort(list, (a, b) -> {
            if((a.head).compareTo(b.head) == 0){
                if(a.number == b.number) return a.idx - b.idx;  // (3) idx 오름차순
                else return a.number - b.number;   // (2) number 오름차순
            }else return (a.head).compareTo(b.head);      // (1) head 오름차순
        });
        
        int cnt = 0;
        for(File file : list){
            answer[cnt++] = file.fileName;
        }
        return answer;
    }
}