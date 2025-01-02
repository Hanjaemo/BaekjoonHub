import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] trees = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int[][] dp = new int[T + 1][W + 1];
        for (int t = 1; t <= T; t++) {
            int tree = trees[t];
            // w == 0 인 경우
            if (tree == 1) { // 자두 야미
                dp[t][0] = dp[t - 1][0] + 1;
            } else { // miss
                dp[t][0] = dp[t - 1][0];
            }

            for (int w = 1; w <= W; w++) {
                if (w % 2 == 0) {
                    if (tree == 1) { // 자두 야미
                        dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1]);
                    } else { // miss
                        dp[t][w] = Math.max(dp[t - 1][w - 1] + 1, dp[t - 1][w]);
                    }
                } else {
                    if (tree == 2) { // 자두 야미
                        dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1]);
                    } else { // miss
                        dp[t][w] = Math.max(dp[t - 1][w - 1] + 1, dp[t - 1][w]);
                    }
                }
                answer = Math.max(answer, dp[t][w]);
            }
        }

        System.out.println(answer);
    }
}