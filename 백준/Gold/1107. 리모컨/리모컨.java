import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] disable;
        if (m > 0) {
            disable = br.readLine().split(" ");
        } else {
            disable = new String[0];
        }

        int answer = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);
            if (containsDisable(num, disable)) {
                continue;
            } else {
                answer = Math.min(answer, Math.abs(n - i) + num.length());
            }
        }

        System.out.println(answer);
    }

    public static boolean containsDisable(String s, String[] disable) {
        for (String x : disable) {
            if (s.contains(x)) {
                return true;
            }
        }
        return false;
    }
}