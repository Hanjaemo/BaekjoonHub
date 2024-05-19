import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 9;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs();
    }

    public static void dfs() {
        Point point = findZeroPoint();

        if (point.r == -1) {
            printMap();
            System.exit(0);
        }

        for (int i = 1; i <= 9; i++) {
            if (valid(point.r, point.c, i)) {
                map[point.r][point.c] = i;
                dfs();
                map[point.r][point.c] = 0;
            }
        }
    }

    public static Point findZeroPoint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }

    public static void printMap() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public static boolean valid(int row, int col, int num) {
        return validRow(row, num) && validCol(col, num) && validArea(row, col, num);
    }

    private static boolean validRow(int row, int num) {
        for (int i = 0; i < N; i++) {
            if (map[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean validCol(int col, int num) {
        for (int i = 0; i < N; i++) {
            if (map[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean validArea(int row, int col, int num) {
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}