import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int creator = 1; creator <= n; creator++) {
            int m = creator;
            String toString = String.valueOf(creator);
            for (int i = 0; i < toString.length(); i++) {
                m += Integer.parseInt(String.valueOf(toString.charAt(i)));
            }
            if (m == n) {
                System.out.println(creator);
                return;
            }
        }

        System.out.println(0);
    }
}