import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int cntOfPoints = Integer.parseInt(st.nextToken());
            int[][] map = new int[row][col];
            for (int i = 0; i < cntOfPoints; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(map, visited, i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer = 0;
        }
    }

    public static void bfs(int[][] map, boolean[][] visited, int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}