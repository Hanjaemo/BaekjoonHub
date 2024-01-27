import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fee = new int[3];
        for (int i = 0; i < 3; i++) {
            fee[i] = Integer.parseInt(st.nextToken());
        }

        int[] truckCount = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for (int j = from; j < to; j++) {
                truckCount[j]++;
            }
        }

        int answer = 0;
        for (int i : truckCount) {
            if (i == 1) {
                answer += fee[0];
            } else if (i == 2) {
                answer += fee[1] * 2;
            } else if (i == 3) {
                answer += fee[2] * 3;
            }
        }

        System.out.println(answer);
    }
}