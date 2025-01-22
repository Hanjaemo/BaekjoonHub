import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int now = dp[i];
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    now = Math.max(now, dp[i] + dp[j]);
                }
            }
            dp[i] = now;
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}