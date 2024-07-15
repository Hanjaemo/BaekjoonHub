import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] map;
    static boolean[][] cleaned;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        cleaned = new boolean[row][col];
        st = new StringTokenizer(br.readLine());
        int robotRow = Integer.parseInt(st.nextToken());
        int robotCol = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Point now = new Point(robotRow, robotCol);
        int nowDir = robotDir;
        int answer = 0;
        while (true) {
            if (!cleaned[now.r][now.c]) {
                clean(now.r, now.c);
                answer++;
            }
            if (hasEmptyAndNotCleanedAnyoneForAround(now.r, now.c)) {
                nowDir = rotate(nowDir);
                if (isEmptyAndNotCleaned(now.r + dRow[nowDir], now.c + dCol[nowDir])) {
                    now = goForward(nowDir, now.r, now.c);
                }
            } else {
                if (canGoBack(nowDir, now.r, now.c)) {
                    now = goBack(nowDir, now.r, now.c);
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    // d = 0:북, 1:동, 2:남, 3:서

    // 1. if 현재 칸 = 0 & f : 청소
    public static void clean(int r, int c) {
        cleaned[r][c] = true;
    }

    // 주변 4칸 확인
    public static boolean hasEmptyAndNotCleanedAnyoneForAround(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dRow[d];
            int nc = c + dCol[d];
            if (isOutOfRange(nr, nc)) {
                continue;
            }
            if (isEmptyAndNotCleaned(nr, nc)) {
                return true;
            }
        }
        return false;
    }

    // 2. if 주변 4칸 모두 1 | 0&t : (가능한 경우) 한칸 후진
    public static boolean canGoBack(int d, int r, int c) {
        if (d == 2) {
            return map[r + dRow[0]][c + dCol[0]] == 0;
        }
        if (d == 3) {
            return map[r + dRow[1]][c + dCol[1]] == 0;
        }
        return map[r + dRow[d + 2]][c + dCol[d + 2]] == 0;
    }

    public static Point goBack(int d, int r, int c) {
        if (d == 2) {
            return new Point(r + dRow[0], c + dCol[0]);
        }
        if (d == 3) {
            return new Point(r + dRow[1], c + dCol[1]);
        }
        return new Point(r + dRow[d + 2], c + dCol[d + 2]);
    }

    // 3. if 주변 4칸 중 하나라도 0 & f : 반시계 90 회전 후 if 앞쪽 칸 = 0 & f : 한칸 전진
    public static int rotate(int d) {
        if (d == 0) {
            return 3;
        }
        return d - 1;
    }

    public static Point goForward(int d, int r, int c) {
        return new Point(r + dRow[d], c + dCol[d]);
    }

    public static boolean isEmptyAndNotCleaned(int r, int c) {
        return map[r][c] == 0 && !cleaned[r][c];
    }

    public static boolean isOutOfRange(int r, int c) {
        return r < 0 || r >= row || c < 0 || c >= col;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}