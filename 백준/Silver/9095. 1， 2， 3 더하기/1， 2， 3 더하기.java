import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            count = 0;
            for (int i = 1; i <= 3; i++) {
                dfs(n, i);
            }
            System.out.println(count);
        }
    }

    public static void dfs(int n, int sum) {
        if (sum == n) {
            count++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i <= n) {
                dfs(n, sum + i);
            }
        }
    }
}