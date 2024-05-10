import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col, k;
    static String[][] map;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = split[j];
            }
        }

        visited = new boolean[row][col];
        visited[row - 1][0] = true;

        dfs(row - 1, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int r, int c, int depth) {
        if (r == 0 && c == col - 1) {
            if (depth == k) {
                answer++;
            }
            return;
        }
        if (fail(r, c)) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dRow[d];
            int nc = c + dCol[d];
            if (nr < 0 || nr >= row || nc < 0 || nc >= col || map[nr][nc].equals("T")) {
                continue;
            }
            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, depth + 1);
                visited[nr][nc] = false;
            }
        }
    }

    public static boolean fail(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dRow[d];
            int nc = c + dCol[d];
            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue;
            }
            if (!visited[nr][nc]) {
                return false;
            }
        }
        return true;
    }
}