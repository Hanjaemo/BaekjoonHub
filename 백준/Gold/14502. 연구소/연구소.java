import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] map;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i=0;i<row;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        System.out.println(max);
    }

    public static void solve() {
        wall(0);
    }

    public static void wall(int cnt) {
        if (cnt == 3) {
            virus();
            return;
        }

        for (int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void virus() {
        int[][] copyMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            copyMap[i] = map[i].clone();
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 2) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(r, c));

                    while (!queue.isEmpty()) {
                        Pair now = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = now.r + dRow[d];
                            int nc = now.c + dCol[d];
                            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                                continue;
                            }
                            if (copyMap[nr][nc] == 0) {
                                copyMap[nr][nc] = 2;
                                queue.add(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
        }
        max = Math.max(max, countSafetyZone(copyMap));
    }

    private static int countSafetyZone(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}