import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = n - 1;
        int min = arr[0] + arr[n - 1];
        int[] answer = new int[2];
        while (s < e) {
            int now = arr[s] + arr[e];
            if (Math.abs(now) <= Math.abs(min)) {
                min = now;
                answer[0] = arr[s];
                answer[1] = arr[e];
            }
            if (now < 0) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}