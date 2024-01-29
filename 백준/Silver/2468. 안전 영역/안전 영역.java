import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int n;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 2차원 배열의 행과 열 개수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 2차원 배열 arr 초기화
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // arr의 최댓값 maxHeight
        int maxHeight = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        // 최대 안전 지역 개수 maxCount = 0
        // for (r=1~maxHeight)
            // 안전 지대 개수 count = 0
            // 방문 기록 배열 visited
            // for (i=1~n)
                // for (j=1~n)
                    // if arr[i][j] > 0 && !visited[i][j]
                        // dfs()
                        // count++
            // maxCount = max(maxCount, count)
        int maxCount = 0;
        for (int height = 0; height <= maxHeight; height++) {
            int count = 0;
            visited = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > height && !visited[i][j]) {
                        count += dfs(i, j, height);
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        // maxCount 출력
        System.out.println(maxCount);
    }

    public static int dfs(int row, int col, int height) {
        // 방문 처리
        visited[row][col] = true;

        // for (4번 반복)
            // curRow = cur + dRow[d]
            // curCol = cur + dCol[d]
            // if 0 미만 또는 n 초과인 경우 : continue
            // if arr[curRow][curCol] > height && !visited[curRow][curCol]
                // dfs(curRow, curCol)
        for (int d = 0; d < 4; d++) {
            int curRow = row + dRow[d];
            int curCol = col + dCol[d];
            if (curRow < 1 || curRow > n || curCol < 1 || curCol > n) {
                continue;
            }
            if (arr[curRow][curCol] > height && !visited[curRow][curCol]) {
                dfs(curRow, curCol, height);
            }
        }

        return 1;
    }
}