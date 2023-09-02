import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        init(n, m, map);
        bfs(map);

        System.out.println(map[n - 1][m - 1]);
    }

    private static void init(int n, int m, int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Pair(j, i));
                    return;
                }
            }
        }
    }

    private static void bfs(int[][] map) {
        while (!queue.isEmpty()) {
            Pair polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];
                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    queue.offer(new Pair(nx, ny));
                    map[ny][nx] = map[polled.y][polled.x] + 1;
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}