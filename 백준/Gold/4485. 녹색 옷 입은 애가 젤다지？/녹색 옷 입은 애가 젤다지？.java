import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dist[0][0] = map[0][0];

            dijkstra(dist);
            System.out.printf("Problem %d: %d%n", round++, dist[n - 1][n - 1]);
        }
    }

    public static void dijkstra(int[][] dist) {
        Queue<Point> pq = new PriorityQueue<>(Comparator.comparingInt((Point p) -> map[p.r][p.c]));
        pq.add(new Point(0, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                    continue;
                }
                if (dist[nr][nc] > dist[now.r][now.c] + map[nr][nc]) {
                    dist[nr][nc] = Math.min(dist[nr][nc], dist[now.r][now.c] + map[nr][nc]);
                    pq.add(new Point(nr, nc));
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