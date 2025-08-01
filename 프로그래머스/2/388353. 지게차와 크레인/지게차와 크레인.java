import java.util.*;

/*
아이디어: 그래프 탐색
1. 출고 요청 길이 = 1 ->겉에서만 접근
2. 출고 요청 길이 = 2 -> 그냥 있는거 다 꺼내기
포인트 -> 꺼낼려는 컨테이너 양 옆이 비어 있어도, 겉에서부터 접근 가능할 때만 가능함.
      -> 동시에 꺼내야 함(하나 꺼낸 후 비어서 그 경로로 접근가능해도 불가X)
고민 포인트 -> 존재하는 알파벳을 map에 넣고 그들의 위치를 저장해야 할까 or 매번 탐색할까
*/
class Solution {
    int n, m;
    char [][] map;
    boolean [][] visited;
    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, 1, 0, -1};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;         // 행
        m = storage[0].length();    // 열
        
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++){
            if(requests[i].length() == 1){
                // 겉에서만 접근 가능
                move(requests[i].charAt(0));
            }else{
                // 전부 다 꺼내기
                moveAll(requests[i].charAt(0));
            }
        }
        
        // 정답
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != '0') answer++;
            }
        }
        
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        return answer;
    }
    
    void move(char target){
        Queue<int []> que = new LinkedList<>();     // 비어질 위치
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == target){
                    // 겉에서 접근 가능한지 확인
                    if(bfs(i, j)) que.add(new int []{i, j});
                }
            }
        }
        
        // 옮겨질 컨테이너 위치
        while(!que.isEmpty()){
            int [] point = que.poll();
            map[point[0]][point[1]] = '0';
        }
    }
    
    boolean bfs(int x, int y){
        Queue<int []> que = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];
        que.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!que.isEmpty()){
            int [] p = que.poll();
            
            if(p[0] == 0 || p[1] == 0 || p[0] == n-1 || p[1] == m-1) return true;
            
            for(int i = 0; i < 4; i++){
                int tx = p[0] + dx[i];
                int ty = p[1] + dy[i];
                
                if(tx >= 0 && tx < n && ty >= 0 && ty < m){
                    if(!visited[tx][ty] && map[tx][ty] == '0'){
                        que.add(new int[]{tx, ty});
                        visited[tx][ty] = true;
                    }
                }
            }
        }
        
        return false;
    }
    
    void moveAll(char target){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == target){
                    map[i][j] = '0';
                }
            }
        }
    }
}