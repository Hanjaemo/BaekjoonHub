import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long min = 0;
        long max = arr[k - 1] + 1;
        while (min < max) {
            long m = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += arr[i] / m;
            }
            if (cnt < n) {
                max = m;
            } else {
                min = m + 1;
            }
        }

        System.out.println(min - 1);
    }
}