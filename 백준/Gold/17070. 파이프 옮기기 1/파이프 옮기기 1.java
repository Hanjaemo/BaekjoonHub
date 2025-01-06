import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] home = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(home, new Point(1, 1), new Point(1, 2));

        System.out.println(cnt);
    }

    // 완전탐색
    public static void solve(int[][] home, Point a, Point b) {
        // 벗어날 경우 return
        if (isOutOfRange(b)) {
            return;
        }

        // 벽 긁었을 경우 return
        if (isScratched(home, a, b)) {
            return;
        }

        // 목적지 도달 시 cnt++, return
        if (b.r == N && b.c == N) {
            cnt++;
            return;
        }

        if (isHorizontal(a, b)) {
            solve(home, new Point(a.r, a.c + 1), new Point(b.r, b.c + 1));
            solve(home, new Point(a.r, a.c + 1), new Point(b.r + 1, b.c + 1));
        } else if (isVertical(a, b)) {
            solve(home, new Point(a.r + 1, a.c), new Point(b.r + 1, b.c));
            solve(home, new Point(a.r + 1, a.c), new Point(b.r + 1, b.c + 1));
        } else if (isDiagonal(a, b)) {
            solve(home, new Point(a.r + 1, a.c + 1), new Point(b.r + 1, b.c + 1));
            solve(home, new Point(a.r + 1, a.c + 1), new Point(b.r, b.c + 1));
            solve(home, new Point(a.r + 1, a.c + 1), new Point(b.r + 1, b.c));
        }
    }

    private static boolean isScratched(int[][] home, Point a, Point b) {
        if (isHorizontal(a, b) || isVertical(a, b)) {
            return home[a.r][a.c] == 1 || home[b.r][b.c] == 1;
        }
        if (isDiagonal(a, b)) {
            return home[a.r][a.c] == 1 || home[b.r][b.c] == 1 || home[a.r + 1][a.c] == 1 || home[a.r][a.c + 1] == 1;
        }
        return false;
    }

    // 가로인 경우
    public static boolean isHorizontal(Point a, Point b) {
        return a.r == b.r && (b.c - a.c == 1);
    }

    // 세로인 경우
    public static boolean isVertical(Point a, Point b) {
        return a.c == b.c && (b.r - a.r == 1);
    }

    // 대각선인 경우
    public static boolean isDiagonal(Point a, Point b) {
        return (b.r - a.r == 1) && (b.c - a.c == 1);
    }

    // 벗어난 경우
    public static boolean isOutOfRange(Point b) {
        return b.r < 1 || b.r > N || b.c < 1 || b.c > N;
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}