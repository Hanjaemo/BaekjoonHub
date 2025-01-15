import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] dp = new int[input.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= input.length(); i++) {
            int now = input.charAt(i - 1) - '0';
            if (1 <= now && now <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            if (i == 1) {
                continue;
            }

            int prev = input.charAt(i - 2) - '0';
            if (prev == 0) {
                continue;
            }

            int val = prev * 10 + now;
            if (10 <= val && val <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[input.length()]);
    }
}