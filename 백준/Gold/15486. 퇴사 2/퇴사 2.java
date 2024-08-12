import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
            if (i + arr[0][i] <= n + 1) {
                dp[i + arr[0][i]] = Math.max(dp[i + arr[0][i]], max + arr[1][i]);
            }
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}