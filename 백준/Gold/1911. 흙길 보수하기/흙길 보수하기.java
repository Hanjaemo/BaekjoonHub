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
        int l = Integer.parseInt(st.nextToken());

        int[][] pools = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pools[i][0] = Integer.parseInt(st.nextToken());
            pools[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        Arrays.sort(pools, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int answer = 0;
        int range = 0;
        for (int i = 0; i < n; i++) {
            int[] now = pools[i];
            if (now[0] > range) {
                range = now[0];
            }
            while (now[1] >= range) {
                range += l;
                answer++;
            }
        }

        System.out.println(answer);
    }
}