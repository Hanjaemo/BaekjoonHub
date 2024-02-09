import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 1;
        while (b > 0 && (b % 2 == 0 || b % 10 == 1)) {
            if (b == a) {
                break;
            }
            if (b % 10 == 1) {
                b = b / 10;
                count++;
                continue;
            }
            b = b / 2;
            count++;
        }

        if (b == a) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}