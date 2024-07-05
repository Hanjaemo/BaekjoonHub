import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dp;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(new Point(i, j)));
            }
        }

        System.out.println(max);
    }

    public static int dfs(Point now) {
        if (dp[now.r][now.c] > 0) {
            return dp[now.r][now.c];
        }

        dp[now.r][now.c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = now.r + dRow[d];
            int nc = now.c + dCol[d];
            if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                continue;
            }
            if (map[nr][nc] > map[now.r][now.c]) {
                dp[now.r][now.c] = Math.max(dp[now.r][now.c], dfs(new Point(nr, nc)) + 1);
            }
        }

        return dp[now.r][now.c];
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}