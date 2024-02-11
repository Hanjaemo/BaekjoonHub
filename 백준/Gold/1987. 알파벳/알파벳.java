import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static char[][] board;
    static boolean[] visited;
    static int[][] scores;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        scores = new int[row][col];
        visited = new boolean[26];
        dfs(0, 0, 1);

        int max = 0;
        for (int[] score : scores) {
            for (int i : score) {
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int r, int c, int depth) {
        scores[r][c] = Math.max(scores[r][c], depth);
        visited[board[r][c] - 'A'] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dRow[d];
            int nc = c + dCol[d];
            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue;
            }
            if (!visited[board[nr][nc] - 'A']) {
                dfs(nr, nc, depth + 1);
            }
        }

        visited[board[r][c] - 'A'] = false;
    }
}