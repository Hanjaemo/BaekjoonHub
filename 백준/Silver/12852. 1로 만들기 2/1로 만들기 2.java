import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] trace = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2]) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3]) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }
        }

        System.out.println(dp[n]);
        dfs(trace, n, new StringBuilder());
    }

    public static void dfs(int[] trace, int node, StringBuilder sb) {
        if (node == 1) {
            System.out.println(sb.append(node).append(" ").toString());
            return;
        }

        sb.append(node).append(" ");
        dfs(trace, trace[node], sb);
    }
}