import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[31][40001];
        solve(arr, dp, 0, 0);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            System.out.print(dp[n][Integer.parseInt(st.nextToken())] ? "Y " : "N ");
        }
    }

    public static void solve(int[] arr, boolean[][] dp, int idx, int weight) {
        if (dp[idx][weight]) {
            return;
        }
        dp[idx][weight] = true;
        if (idx == arr.length) {
            return;
        }

        solve(arr, dp, idx + 1, weight); // 그대로
        solve(arr, dp, idx + 1, weight + arr[idx]); // 추 +1
        solve(arr, dp, idx + 1, Math.abs(weight-arr[idx])); // 구슬 쪽에 추 +1
    }
}