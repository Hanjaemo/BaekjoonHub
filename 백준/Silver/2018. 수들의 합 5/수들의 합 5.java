import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 배열 생성 (1~n)
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // sum, count, index 초기화
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        int count = 1;

        // while (endIdx < N)
            // if (sum < n) : endIdx++, sum+=endIdx
            // if (sum > n) : sum-=startIdx, startIdx++
            // if (sum == n) : count++, endIdx++, sum+=endIdx
        while (endIdx < n) {
            if (sum < n) {
                endIdx++;
                sum += endIdx;
                continue;
            }
            if (sum > n) {
                sum -= startIdx;
                startIdx++;
                continue;
            }
            count++;
            endIdx++;
            sum += endIdx;
        }

        // count 출력
        System.out.println(count);
    }
}