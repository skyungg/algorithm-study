import java.util.*;

public class Solution {
    static class Point{
        int sx = 0;
        int sy = 0;
        int ex = 0;
        int ey = 0;

        public Point(int sx, int sy, int ex, int ey){
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
    }

    static int cx, cy;
    static List<Point> list;
    public static int solution(String dirs) {
        int answer = 0;
        int sx = 0;
        int sy = 0;

        list = new ArrayList<>();

        int tx = 0;
        int ty = 0;
        for(int i = 0; i < dirs.length(); i++){
            Character dir = dirs.charAt(i);
            if(!checkRange(dir, sx, sy)) continue;       // 범위 밖

            tx = sx;
            ty = sy;
            sx = cx;
            sy = cy;

            if(list.isEmpty()){
                list.add(new Point(tx, ty, cx, cy));
            }else{
                if(isContained(tx, ty)) continue;       // 이미 포함
                else{
                    list.add(new Point(tx, ty, cx, cy));
                }
            }
        }
        answer = list.size();

        return answer;
    }

    static boolean checkRange(Character dir, int sx, int sy){
        int x = 0;
        int y = 0;
        if(dir.equals('U')){
            x = sx + 1;
            y = sy;
        }else if(dir.equals('D')){
            x = sx - 1;
            y = sy;
        }else if(dir.equals('L')){
            x = sx;
            y = sy - 1;
        }else if(dir.equals('R')){
            x = sx;
            y = sy + 1;
        }

        if(x < -5 || x > 5 || y < -5 || y > 5) return false;

        cx = x;
        cy = y;

        return true;
    }

    static boolean isContained(int sx, int sy){
        boolean flag = false;
        for(int i = 0; i < list.size(); i++){
            if((list.get(i).sx == sx) && (list.get(i).sy == sy)){
                if((list.get(i).ex == cx) && (list.get(i).ey == cy)){
                    flag = true;
                    break;
                }
            }
            if((list.get(i).ex == sx) && (list.get(i).ey == sy)){
                if((list.get(i).sx == cx) && (list.get(i).sy == cy)){
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }

    public static void main(String [] args){
        String str = "ULURRDLLU";
        System.out.println(solution(str));

    }
}
