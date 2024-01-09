import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 배달할 설탕 무게 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (n > 0) {
            // if n이 5의 배수인 경우
                // count += n / 5
                // count 출력
                // 종료
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                return;
            }
            // if n이 3보다 작은 경우
                // -1 출력
                // 종료
            if (n < 3) {
                System.out.println(-1);
                return;
            }
            // n -= 3
            n -= 3;
            // count++
            count++;
        }

        // count 출력
        System.out.println(count);
    }
}