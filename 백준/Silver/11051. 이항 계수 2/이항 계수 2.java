import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // n, k 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // dp 배열 생성
        int[][] dp = new int[n + 1][n + 1];

        // dp 배열 초기화
            // dp[i][0] = 1
            // dp[i][1] = i
            // dp[i][i] = 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        // 점화식 사용해서 dp 배열 채우기
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
            }
        }

        // dp[n][k] 출력
        System.out.println(dp[n][k]);
    }
}