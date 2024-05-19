import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] ranks = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ranks, (o1, o2) -> o1[0] - o2[0]);

            int answer = 1;
            int minB = ranks[0][1];
            for (int i = 1; i < n; i++) {
                if (ranks[i][1] < minB) {
                    minB = ranks[i][1];
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}