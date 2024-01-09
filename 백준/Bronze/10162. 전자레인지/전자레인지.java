import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = {300, 60, 10};
        int[] counts = new int[3];
        while (t > 0) {
            if (t % 10 != 0) {
                System.out.println(-1);
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (t >= arr[i]) {
                    counts[i] = t / arr[i];
                    t %= arr[i];
                }
            }
        }
        for (int count : counts) {
            System.out.print(count + " ");
        }
    }
}