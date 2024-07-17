import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int totalAmount = Integer.parseInt(br.readLine());

        int l = 0;
        int r = max;
        while (l <= r) {
            int m = (l + r) / 2;
            long sum = 0;
            for (int i : arr) {
                if (i > m) {
                    sum += m;
                } else {
                    sum += i;
                }
            }
            if (sum <= totalAmount) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println(r);
    }
}