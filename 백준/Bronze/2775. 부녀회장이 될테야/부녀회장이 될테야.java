import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 t
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // for (t번 반복)
            // 층 k
            // 호 n
            // dp 배열 초기화
                // dp[i][1] = 1
                // dp[0][j] = j
            // for (i=1~k)
                // for (j=1~n)
                    // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            // dp[k][n] 출력
        for (int testCase = 0; testCase < t; testCase++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[k + 1][n + 1];
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][1] = 1;
                    dp[0][j] = j;
                }
            }
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}