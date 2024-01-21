import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 testCase
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // for (testCase만큼 반복)
            // 서쪽 사이트 개수 n
            // 동쪽 사이트 개수 m

            // dp 배열 초기화
                // dp[i][0] = 1
                // dp[i][1] = i
                // dp[i][i] = 1

            // for (i=2~m)
                // for (j=1~i)
                    // dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

            // dp[m][n] 출력
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] dp = new int[m + 1][m + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][0] = 1;
                    dp[i][1] = i;
                    dp[i][i] = 1;
                }
            }

            for (int i = 2; i <= m; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

            System.out.println(dp[m][n]);
        }
    }
}