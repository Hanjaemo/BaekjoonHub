import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int gap = 2; gap <= n - 1; gap++) {
            for (int start = 1; start <= n - gap; start++) {
                int end = start + gap;
                if (arr[start] == arr[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}