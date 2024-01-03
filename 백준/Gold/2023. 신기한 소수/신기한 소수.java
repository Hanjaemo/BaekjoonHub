import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        // 자릿수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // dfs(2, 1)
        dfs(2, 1);

        // dfs(3, 1)
        dfs(3, 1);

        // dfs(5, 1)
        dfs(5, 1);

        // dfs(7, 1)
        dfs(7, 1);
    }

    private static void dfs(int number, int digit) {
        // if digit == n
            // if isPrime(number) : 출력
            // 탐색 종료
        if (digit == n) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        // for (i=0~9)
            // if i는 짝수 : 종료
            // if isPrime(i)
                // dfs(number*10+i, digit+1)
        for (int i = 0; i <= 9; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(number * 10 + i)) {
                dfs(number * 10 + i, digit + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}