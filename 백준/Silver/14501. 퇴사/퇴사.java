import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n + 1];
        int[] incomes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            incomes[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        for (int i = n; i >= 1; i--) {
            if (i + times[i] > n + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + times[i]] + incomes[i]);
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}