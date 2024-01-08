import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 동전 종류 수 n, 목표 금액 k 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 각 동전의 개수를 저장하는 배열 coins 생성
        int[] coins = new int[n];
        // for (n번 반복)
            // 숫자를 입력 받아 coins에 저장
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // k를 위한 동전 개수 cnt = 0
        int cnt = 0;
        // while (k > 0)
            // k보다 작거나 같은 동전 coin = 0
            // for (coins 크기만큼 반복, 내림차순 탐색)
                // if coins[i] <= k :
                    // coin = coins[i]
                    // 탈출
            // cnt += k / coin
            // k %= coin
        while (k > 0) {
            int coin = 0;
            for (int i = coins.length - 1; i >= 0; i--) {
                if (coins[i] <= k) {
                    coin = coins[i];
                    break;
                }
            }
            cnt += k / coin;
            k %= coin;
        }

        // cnt 출력
        System.out.println(cnt);
    }
}