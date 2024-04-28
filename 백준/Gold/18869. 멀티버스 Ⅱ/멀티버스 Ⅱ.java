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

        int[][] planets = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                planets[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ranks = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] copied = Arrays.copyOf(planets[i], planets[i].length);
            Arrays.sort(copied);

            for (int j = 0; j < planets[i].length; j++) {
                int low = 0;
                int high = copied.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (copied[mid] < planets[i][j]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                ranks[i][j] = low;
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] a = ranks[i];
                int[] b = ranks[j];
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (a[k] == b[k]) {
                        cnt++;
                    }
                }
                if (cnt == n) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}