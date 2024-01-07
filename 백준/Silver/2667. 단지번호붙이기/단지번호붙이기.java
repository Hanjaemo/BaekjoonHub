import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    // 지도 크기 n
    static int n;
    // 2차원 배열 arr
    static int[][] arr;
    // 방문 2차원 배열 visited
    static boolean[][] visited;
    // dRow, dCol
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};
    // 각 단지내 집의 수 count
    static int count;
    // 총 단지 수 result
    static int result;

    public static void main(String[] args) throws IOException {
        // n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // arr, visited 초기화
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        visited = new boolean[n][n];

        // for (i=0~n-1)
            // for (j=0~n-1)
                // if 값이 1인 좌표 && 방문하지 않은 좌표 : count++, dfs(i, j)
        List<Integer> homeCounts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    result++;
                    count = 0;
                    dfs(i, j);
                    homeCounts.add(count);
                }
            }
        }

        // 결과 출력
        System.out.println(result);
        // 각 단지내 집의 수 오름차순 정렬 및 출력
        Collections.sort(homeCounts);
        for (Integer homeCount : homeCounts) {
            System.out.println(homeCount);
        }
    }

    private static void dfs(int row, int col) {
        // if 이미 방문한 좌표 : 종료
        if (visited[row][col]) {
            return;
        }

        // 방문 처리
        visited[row][col] = true;
        // count++
        count++;

        // for (상하좌우 탐색)
            // if 유효한 좌표 :
            // if 방문X && 값이 1인 좌표 : dfs
        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow < 0 || nCol < 0 || nRow >= n || nCol >= n) {
                continue;
            }
            if (!visited[nRow][nCol] && arr[nRow][nCol] == 1) {
                dfs(nRow, nCol);
            }
        }
    }
}