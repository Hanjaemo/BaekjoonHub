import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 퇴사까지 남은 일수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 상담을 완료하는데 걸리는 기간 배열 t
        int[] t = new int[n + 1];

        // 상담 비용 배열 p
        int[] p = new int[n + 1];

        // for (n번 반복)
            // 정보 입력 받아 t와 p에 각각 저장
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 생성
        int[] dp = new int[n + 2];

        // 최댓값 max
        // for (i=1~n)
            // max = max(max, dp[i])
            // i + t[i] => s
            // if s <= n+1 : dp[s] = max(dp[i]+p[i], dp[s])
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
            int s = i + t[i];
            if (s <= n + 1) {
                dp[s] = Math.max(max + p[i], dp[s]);
            }
        }

        // dp 배열에서 최댓값 출력
        max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}