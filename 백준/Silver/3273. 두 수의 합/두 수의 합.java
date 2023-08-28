import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int count = 0;
        int a = 0;
        int b = arr.length - 1;
        while (a < b) {
            if (arr[a] + arr[b] == x) {
                count++;
                a++;
                b--;
            } else {
                if (arr[a] + arr[b] < x) {
                    a++;
                } else {
                    b--;
                }
            }
        }

        System.out.println(count);
    }
}