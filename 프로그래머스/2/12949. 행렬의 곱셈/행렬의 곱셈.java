class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;        // 새로운 행 크기
        int k = arr2[0].length;     // 새로운 열 크기
        int m = arr1[0].length;     // arr1의 열 크기
        int[][] answer = new int[n][k];
        int row = 0;
        for(int idx = 0; idx < n; idx++){
            for(int i = 0; i < k; i++){         // arr2의 열크기만큼 반복
                for(int j = 0; j < m; j++){
                    answer[idx][i] += (arr1[idx][j] * arr2[j][i]);
                }
            }
        }

        return answer;
    }
}