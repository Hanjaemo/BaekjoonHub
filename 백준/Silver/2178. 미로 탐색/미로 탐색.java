import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        bfs(1, 1);
        System.out.println(arr[n][m]);
    }

    private static void bfs(int r, int c) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c));
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dRow[i];
                int nc = now.c + dCol[i];
                if (nr <= 0 || nr > arr.length - 1 || nc <= 0 || nc > arr[0].length - 1) {
                    continue;
                }
                if (arr[nr][nc] == 1) {
                    arr[nr][nc] = arr[now.r][now.c] + 1;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }
}

class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}