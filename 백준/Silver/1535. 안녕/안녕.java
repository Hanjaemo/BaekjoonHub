import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] hp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        int[] happy = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int maxHp = 100;
        int[][] dp = new int[n + 1][maxHp + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxHp; j++) {
                if (hp[i] < j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - hp[i]] + happy[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][maxHp]);
    }
}