import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static List<Point> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            boolean isContinue = false;
            boolean[][] visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        int sum = open(board, visited, new Point(r, c));
                        if (points.size() > 1) {
                            move(board, sum);
                            isContinue = true;
                        }
                    }
                }
            }

            if (!isContinue) {
                System.out.println(day);
                return;
            }

            day++;
        }
    }

    // 국경선 open && 연
    public static int open(int[][] board, boolean[][] visited, Point point) {
        int sum = 0;

        Queue<Point> queue = new LinkedList<>();
        points = new ArrayList<>();
        visited[point.r][point.c] = true;
        queue.add(point);
        points.add(point);
        sum += board[point.r][point.c];

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }
                if (!visited[nr][nc]) {
                    int diff = Math.abs(board[now.r][now.c] - board[nr][nc]);
                    if (diff >= L && diff <= R) {
                        Point adjPoint = new Point(nr, nc);
                        visited[nr][nc] = true;
                        queue.add(adjPoint);
                        points.add(adjPoint);
                        sum += board[nr][nc];
                    }
                }
            }
        }

        return sum;
    }

    // 인구 이동
    public static void move(int[][] board, int sum) {
        int population = sum / points.size();
        for (Point point : points) {
            board[point.r][point.c] = population;
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