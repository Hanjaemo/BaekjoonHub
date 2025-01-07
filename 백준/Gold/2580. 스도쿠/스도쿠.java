import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAP_LEN = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[MAP_LEN][MAP_LEN];
        for (int i = 0; i < MAP_LEN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_LEN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, new Point(0, 0));
    }

    public static void dfs(int[][] map, Point now) {
        // 오른쪽 끝에 도달한 경우
        if (now.c == MAP_LEN) {
            dfs(map, new Point(now.r + 1, 0));
            return;
        }

        // 모두 채워진 경우
        if (now.r == MAP_LEN) {
            for (int i = 0; i < MAP_LEN; i++) {
                for (int j = 0; j < MAP_LEN; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        // 숫자 채우기
        if (map[now.r][now.c] == 0) {
            for (int n = 1; n <= MAP_LEN; n++) {
                // 가로 줄에 이미 존재하는 경우 || 세로 줄에 이미 존재하는 경우 || 박스 안에 이미 존재하는 경우
                if (alreadyExists(map, now, n)) {
                    continue;
                }
                map[now.r][now.c] = n;
                dfs(map, new Point(now.r, now.c + 1));
            }
            map[now.r][now.c] = 0;
            return;
        }

        dfs(map, new Point(now.r, now.c + 1));
    }

    private static boolean isMapFull(int[][] map) {
        for (int i = 0; i < MAP_LEN; i++) {
            for (int j = 0; j < MAP_LEN; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean alreadyExists(int[][] map, Point now, int n) {
        return alreadyExistsInHorizontalLine(map, now, n) || alreadyExistsInVerticalLine(map, now, n) || alreadyExistsInBox(map, now, n);
    }

    private static boolean alreadyExistsInHorizontalLine(int[][] map, Point now, int n) {
        for (int i = 0; i < MAP_LEN; i++) {
            if (map[now.r][i] == n) {
                return true;
            }
        }
        return false;
    }

    private static boolean alreadyExistsInVerticalLine(int[][] map, Point now, int n) {
        for (int i = 0; i < MAP_LEN; i++) {
            if (map[i][now.c] == n) {
                return true;
            }
        }
        return false;
    }

    private static boolean alreadyExistsInBox(int[][] map, Point now, int n) {
        int sr = now.r - (now.r % 3);
        int er = sr + 2;
        int sc = now.c - (now.c % 3);
        int ec = sc + 2;
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if (map[i][j] == n) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}