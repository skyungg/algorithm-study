import java.util.*;

class Point{
    long x;
    long y;

    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static long maxX = Long.MIN_VALUE;   // x 최대값
    static long maxY = Long.MIN_VALUE;   // y 최대값
    static long minX = Long.MAX_VALUE;   // x 최소값
    static long minY = Long.MAX_VALUE;   // y 최소값
    ArrayList<Point> list = new ArrayList<>();
    
    public String[] solution(int[][] line) {
        for(int i = 0; i < line.length-1; i++){
            for(int j = i+1; j < line.length; j++){
                calculation(line[i], line[j]);      // 두 직선간의 교점 구하기
            }
        }

        int m = (int)(maxX - minX + 1);    // x길이
        int n = (int)(maxY - minY + 1);    // Y길이

        char[][] map = new char[n][m];
        for(int i = 0 ; i < n; ++i){
            for(int j = 0; j< m; ++j){
                map[i][j] = '.';
            }
        }

        for(int i = 0; i < list.size(); ++i){
            map[(int) (maxY-list.get(i).y)][(int) (list.get(i).x-minX)] = '*';
        }
        
        String[] answer = new String[map.length];
        for(int i = 0; i < answer.length; ++i){
            answer[i] = new String(map[i]);
        }

//        String result[][] = new String[n][m];
//
//        for (String[] res : result) Arrays.fill(res, ".");
//
//        for(int i = 0; i < list.size(); i++){
//            Point p = list.get(i);
//            int x = (int)(maxY - p.y);
//            int y = (int) (p.x - minX);
//            result[x][y] = "*";
//        }
//
//        String[] answer = new String[(int)n];
//        for(int i = 0; i < result.length; i++){
//            String tmp = "";
//            for(int j = 0 ; j < result[i].length; j++){
//                tmp += result[i][j];
//            }
//            answer[i] = tmp;
//        }
        return answer;
    }
    
    boolean isInteger(double num) {
        return num == (long) num;
    }
    
    void calculation(int line1[], int line2[]){
        long a1 = line1[0], b1 = line1[1], c1 = line1[2];
        long a2 = line2[0], b2 = line2[1], c2 = line2[2];

        double pu = b1*c2 - c1*b2;
        double qu = c1*a2 - a1*c2;
        double deno = a1*b2 - b1*a2;

        if(deno != 0){
            double p = pu / deno;
            double q = qu / deno;

            if(isInteger(p) && isInteger(q)){
                long px = (long)p;
                long qy = (long)q;
                list.add(new Point(px, qy));

                maxX = Math.max(maxX, px);
                maxY = Math.max(maxY, qy);

                minX = Math.min(minX, px);
                minY = Math.min(minY, qy);
            }
        }
    }
}