import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10 2
 * 0 3 -2 -4 -9 0 3 7 13 8 -3
 * 0 3 1 -3 -12 -12 -9 -2 11 19 16
 */
public class Main {
    static int n, k;
    static int[] arr, sum;
    static int max = -10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = k; i <= n; i++) {
            int rangeSum = sum[i] - sum[i - k];
            max = Math.max(max, rangeSum);
        }

        System.out.println(max);
    }
}