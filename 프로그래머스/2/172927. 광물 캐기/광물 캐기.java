import java.util.*;

public class Solution {
    
    static class Mineral{
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone){
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    static int[][] score;
    static List<Mineral> list;

    
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        score = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int totalPicks  = Arrays.stream(picks).sum();
        
        list = new ArrayList<>();
        // 광물 5개씩 묶기
        for(int i = 0; i < minerals.length; i+=5){
            if(totalPicks == 0) break;
            int dia = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i; j < i+5; j++){
                if(j == minerals.length) break;
                
                String mineral = minerals[j];
                int val = 0;
                if(mineral.equals("iron")){
                    val = 1;
                }else if(mineral.equals("stone")){
                    val = 2;
                }
                
                dia += score[0][val];
                iron += score[1][val];
                stone += score[2][val];
            }
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }
        
        

        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
        for(Mineral m : list){
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;
            
            if(picks[0] > 0){
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0){
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0){
                answer += stone;
                picks[2]--;
                continue;
            }
        }

        

        return answer;
    }
}