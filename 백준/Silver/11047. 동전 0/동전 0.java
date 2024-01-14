import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 동전 수 n, 목표 금액 k
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전의 종류 배열 coins
        int[] coins = new int[n];
        // for (n번 반복)
            // coins에 입력 받은 동전 종류 저장
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 필요 동전 개수 count = 0
        int count = 0;

        // while (k > 0)
            // coins를 탐색하여 k보다 작거나 같은 값 선택
            // count += k / 선택한 동전
            // k %= 선택한 동전
        while (k > 0) {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (k >= coins[i]) {
                    count += k / coins[i];
                    k %= coins[i];
                    break;
                }
            }
        }

        System.out.println(count);
    }
}