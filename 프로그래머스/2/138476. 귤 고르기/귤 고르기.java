import java.util.*;

class Solution {
    static class Point{
        int count;
        int num;

        public Point(int count, int num){
            this.count = count;
            this.num = num;
        }
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Point> list = new ArrayList<>();
        int n = tangerine.length;

        for(int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = 0; j < list.size(); j++){
                Point p = list.get(j);
                if(p.num == tangerine[i]){
                    p.count++;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list.add(new Point(1, tangerine[i]));

            }
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.count - o1.count;
            }
        });

        int idx = 0;
        while(k > 0){
            k = k - list.get(idx).count;
            idx++;
            answer++;
        }

        return answer;
    }
}