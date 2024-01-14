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

        int appleCount = Integer.parseInt(br.readLine());
        int start = 1;
        int end = m;
        int answer = 0;
        for (int i = 0; i < appleCount; i++) {
            int appleIdx = Integer.parseInt(br.readLine());
            while (start > appleIdx || end < appleIdx) {
                if (start > appleIdx) {
                    start--;
                    end--;
                } else {
                    start++;
                    end++;
                }
                answer++;
            }
        }

        System.out.println(answer);
    }
}