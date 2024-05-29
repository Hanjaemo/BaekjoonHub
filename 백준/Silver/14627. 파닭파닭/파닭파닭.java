import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 돌아가며 이분탐색
 * 2. 라면에 넣을 파 구하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[s + 1];

        long sum = 0;
        int max = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int l = 1;
        int r = max;
        long maxLen = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (count(s, arr, m) >= c) {
                l = m + 1;
                maxLen = Math.max(maxLen, m);
            } else {
                r = m - 1;
            }
        }

        System.out.println(sum - c * maxLen);
    }

    public static int count(int s, int[] arr, int m) {
        int count = 0;
        for (int i = 0; i < s; i++) {
            count += arr[i] / m;
        }
        return count;
    }
}