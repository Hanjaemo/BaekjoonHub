import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 섬 채우기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 구분하기
        int islandNumber = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    setIslandNumber(i, j, islandNumber);
                    islandNumber++;
                }
            }
        }

        // 최단 경로 구하기 (BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void setIslandNumber(int i, int j, int islandNumber) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited= new boolean[n][n];
        queue.add(new Pair(i, j, 0));
        visited[i][j] = true;
        map[i][j] = islandNumber;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc, 0));
                    map[nr][nc] = islandNumber;
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new Pair(r, c, 0));
        visited[r][c] = true;
        int num = map[r][c];

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] != num) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        queue.add(new Pair(nr, nc, now.d + 1));
                    } else {
                        answer = Math.min(answer, now.d);
                        return;
                    }
                }
            }
        }
    }
}

class Pair {
    int r, c, d;

    public Pair(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}