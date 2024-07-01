import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int canChange = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        recursive(s, t);

        System.out.println(canChange);
    }

    public static void recursive(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                canChange = 1;
            }
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            recursive(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            String string = new StringBuilder(t).delete(0, 1).reverse().toString();
            recursive(s, string);
        }
    }
}