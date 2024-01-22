import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 팩토리얼 배열 (각 자릿수에서 만들 수 있는 경우의 수) f
    static long[] f;
    // 방문 기록 배열 visited
    static boolean[] visited;
    // 순열 배열 p
    static int[] p;

    public static void main(String[] args) throws IOException {
        // n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // f 초기화
        f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }

        // visited, p 초기화
        visited = new boolean[n + 1];
        p = new int[n + 1];

        // 소문제 번호 q
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        // if q == 1
            // first(n, k)
        // else
            // p에 순열 저장
            // second(n)
        if (q == 1) {
            first(n, Long.parseLong(st.nextToken()));
        } else {
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            second(n);
        }
    }

    private static void first(int n, long k) { // k: 내가 찾을 순열의 순서
        for (int i = 1; i <= n; i++) {
            long cnt = 1; // 앞에서 확정되지 않은 숫자들 중 몇 번째 숫자를 사용해야 할지 정하는 변수
            for (int j = 1; j <= n; j++) {
                if (visited[j]) { // j가 이미 사용한 숫자면 넘기기
                    continue;
                }
                if (k <= cnt * f[n - i]) { // 찾을 순열의 순서가 (cnt*해당 자리 순열 수)보다 작거나 같다면
                    k -= (cnt - 1) * f[n - i]; // k 업데이트
                    p[i] = j; // p[i] = j
                    visited[j] = true; // j를 사용한 숫자로 체크
                    break;
                }
                cnt++; // 조건문을 만족하지 않으면 cnt는 계속 증가
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(p[i] + " ");
        }
    }

    private static void second(int n) {
        long k = 1; // 순열의 순서 저장 변수 k
        for (int i = 1; i <= n; i++) {
            long cnt = 0; // 앞에서 확정되지 않은 숫자들 중 몇 번째 숫자를 사용해야 할지 정하는 변수
            for (int j = 1; j < p[i]; j++) { // j는 p[i]보다 클 수 없음
                if (!visited[j]) { // j가 사용 숫자가 아니라면 cnt 증가
                    cnt++;
                }
            }
            k += cnt * f[n - i]; // k 업데이트
            visited[p[i]] = true; // 순열에 저장된 숫자를 사용 숫자로 체크
        }

        System.out.println(k);
    }
}