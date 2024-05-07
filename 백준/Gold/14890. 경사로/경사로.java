import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (row(map, l, i)) {
                answer++;
            }
            if (column(map, l, i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean row(int[][] map, int l, int row) {
        boolean[] isSetUp = new boolean[map.length];
        for (int c = 0; c < map.length - 1; c++) {
            int diff = map[row][c] - map[row][c + 1];
            if (diff < -1 || diff > 1) {
                return false;
            }
            if (diff == -1) {
                for (int i = 0; i < l; i++) {
                    if (c - i < 0 || isSetUp[c - i]) {
                        return false;
                    }
                    if (map[row][c] != map[row][c - i]) {
                        return false;
                    }
                    isSetUp[c - i] = true;
                }
            }
            if (diff == 1) {
                for (int i = 1; i <= l; i++) {
                    if (c + i >= map.length || isSetUp[c + i]) {
                        return false;
                    }
                    if (map[row][c] - 1 != map[row][c + i]) {
                        return false;
                    }
                    isSetUp[c + i] = true;
                }
            }
        }
        return true;
    }

    public static boolean column(int[][] map, int l, int col) {
        boolean[] isSetUp = new boolean[map.length];
        for (int r = 0; r < map.length - 1; r++) {
            int diff = map[r][col] - map[r + 1][col];
            if (diff < -1 || diff > 1) {
                return false;
            }
            if (diff == -1) {
                for (int i = 0; i < l; i++) {
                    if (r - i < 0 || isSetUp[r - i]) {
                        return false;
                    }
                    if (map[r][col] != map[r - i][col]) {
                        return false;
                    }
                    isSetUp[r - i] = true;
                }
            }
            if (diff == 1) {
                for (int i = 1; i <= l; i++) {
                    if (r + i >= map.length || isSetUp[r + i]) {
                        return false;
                    }
                    if (map[r][col] - 1 != map[r + i][col]) {
                        return false;
                    }
                    isSetUp[r + i] = true;
                }
            }
        }
        return true;
    }
}