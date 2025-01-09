import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int sr = 1; sr <= n; sr++) {
            for (int sc = 1; sc <= m; sc++) {
                for (int i = sr; i <= n; i++) {
                    for (int j = sc; j <= m; j++) {
                        max = Math.max(max, sum[i][j] - sum[sr - 1][j] - sum[i][sc - 1] + sum[sr - 1][sc - 1]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}