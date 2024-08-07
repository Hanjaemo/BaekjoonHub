import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int row, col;
    static int[][] map;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeInteriorAir();

        int hour = 0;
        while (remainCheese()) {
            List<Point> exposedCheeses = findExposedCheeses();
            meltExposedCheeses(exposedCheeses);
            exposeInteriorAir();
            hour++;
        }

        System.out.println(hour);

    }

    private static boolean remainCheese() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 내부 공기 체크
    public static void makeInteriorAir() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfsForMakeInteriorAir(i, j, visited);
                }
            }
        }
    }
    private static void bfsForMakeInteriorAir(int r, int c, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;
        map[r][c] = 2;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    map[nr][nc] = 2;
                }
            }
        }
    }

    // 내부 공기 노출 체크
    public static void exposeInteriorAir() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 2) {
                    for (int d = 0; d < 4; d++) {
                        int r = i + dRow[d];
                        int c = j + dCol[d];
                        if (map[r][c] == 0) {
                            bfsForExposeInternalAir(i, j);
                            break;
                        }
                    }
                }
            }
        }
    }
    private static void bfsForExposeInternalAir(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        boolean[][] visited = new boolean[row][col];
        visited[r][c] = true;
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (!visited[nr][nc] && map[nr][nc] == 2) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    map[nr][nc] = 0;
                }
            }
        }
    }

    public static List<Point> findExposedCheeses() {
        List<Point> exposedCheeses = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int r = i + dRow[d];
                        int c = j + dCol[d];
                        if (map[r][c] == 0) {
                            cnt++;
                        }
                    }
                    if (cnt >= 2) {
                        exposedCheeses.add(new Point(i, j));
                    }
                }
            }
        }
        return exposedCheeses;
    }

    private static void meltExposedCheeses(List<Point> exposedCheeses) {
        for (Point exposedCheese : exposedCheeses) {
            map[exposedCheese.r][exposedCheese.c] = 0;
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