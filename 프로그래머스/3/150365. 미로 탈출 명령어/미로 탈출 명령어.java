class Solution {
    private static final int[] row = {1, 0, 0, -1};
    private static final int[] col = {0, -1, 1, 0};
    private String answer = "impossible";
    private int r;
    private int c;
    private int n;
    private int m;
    private int k;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.r = r;
        this.c = c;
        this.n = n;
        this.m = m;
        this.k = k;

        if (getManhattanDist(x, y) > k) { // (1)
            return answer;
        }
        dfs(0, x, y, "");
        return answer;
    }

    private void dfs(int moveDist, int x, int y, String command) {
        if (!answer.equals("impossible")) return; // (2)
        if (k - moveDist < getManhattanDist(x, y)) return; // (3)
        if ((k - moveDist - getManhattanDist(x, y)) % 2 != 0) return; // (4)

        if (moveDist == k) { // (5)
            answer = command;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + row[i];
            int ny = y + col[i];
            char newCommand = getCommand(i);
            if (isOutOfRange(nx, ny)) {
                continue;
            }
            dfs(moveDist + 1, nx, ny, command + newCommand);
        }
    }

    private int getManhattanDist(int x, int y) { // (6)
        return Math.abs(r - x) + Math.abs(c - y);
    }

    private char getCommand(int i) { // (7)
        return switch (i) {
            case 0 -> 'd';
            case 1 -> 'l';
            case 2 -> 'r';
            default -> 'u';
        };
    }

    private boolean isOutOfRange(int x, int y) {
        return x < 1 || y < 1 || x > n || y > m;
    }
}