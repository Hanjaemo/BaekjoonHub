import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int min = 1;
        int max = arr[n - 1];
        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= m) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}