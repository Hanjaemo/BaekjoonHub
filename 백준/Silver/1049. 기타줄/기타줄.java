import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int minPackage = arr[0][0];
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int minEach = arr[0][1];

        if (n < 6) {
            System.out.println(Math.min(n * minPackage, n * minEach));
        } else {
            int a = n * minEach;
            int b = n / 6 * minPackage + minPackage;
            int c = n / 6 * minPackage + n % 6 * minEach;
            int answer = Math.min(a, Math.min(b, c));
            System.out.println(answer);
        }
    }
}