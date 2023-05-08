import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[100001];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp(n);
    }

    public static void dp(int n) {
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 3;
        dp[7] = 2;
        dp[8] = 4;
        dp[9] = 3;
        dp[10] = 2;


        for (int i = 11; i <= n; i++) {
            dp[i] = dp[i - 5] + 1;
        }

        System.out.println(dp[n]);
    }
}
