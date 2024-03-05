import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int length;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dCol = {2, 1, -2, -1, 2, 1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());

            map = new int[length][length];
            visited = new boolean[length][length];

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            bfs(sr, sc, er, ec);
            System.out.println(map[er][ec]);
        }
    }

    public static void bfs(int sr, int sc, int er, int ec) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (now.r == er && now.c == ec) {
                return;
            }
            for (int d = 0; d < 8; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= length || nc < 0 || nc >= length) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                    map[nr][nc] = map[now.r][now.c] + 1;
                }
            }
        }
    }
}

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}