import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int testCase, h, w, count;
    private static boolean[][] grid;
    private static boolean[][] visited;
    private static int[] dCol = {-1, 0, 1, 0};
    private static int[] dRow = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());
        for (int n = 0; n < testCase; n++) {
            count = 0;
            input();
            solve();
            System.out.println(count);
        }
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        grid = new boolean[h + 1][w + 1];
        visited = new boolean[h + 1][w + 1];

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                grid[i][j] = (str.charAt(j) == '#');
            }
        }
    }

    public static void solve() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
    }

    public static void dfs(int col, int row) {
        visited[col][row] = true;

        for (int i = 0; i < 4; i++) {
            int nCol = col + dCol[i];
            int nRow = row + dRow[i];

            if (nCol < 0 || nRow < 0 || nCol >= h || nRow >= w) {
                continue;
            }

            if (grid[nCol][nRow] && !visited[nCol][nRow]) {
                visited[nCol][nRow] = true;
                dfs(nCol, nRow);
            }
        }

    }
}
