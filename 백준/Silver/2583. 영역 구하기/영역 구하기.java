import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int square = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        for (int s = 0; s < square; s++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y <= y2 - 1; y++) {
                for (int x = x1; x <= x2 - 1; x++) {
                    graph[y][x] = 1;
                }
            }
        }

        visited = new boolean[m][n];

        int squareCount = 0;
        List<Integer> result = new ArrayList<>();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && graph[y][x] == 0) {
                    squareCount++;
                    result.add(bfs(x, y));
                }
            }
        }

        System.out.println(squareCount);
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (!visited[ny][nx] && graph[ny][nx] == 0) {
                    queue.add(new Point(nx, ny));
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}