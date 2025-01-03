import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = removeLastChar(t);
            } else {
                t = reverse(removeLastChar(t));
            }
        }

        System.out.println(t.equals(s) ? 1 : 0);
    }

    private static String reverse(String t) {
        String[] split = t.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
        }
        t = sb.toString();
        return t;
    }

    private static String removeLastChar(String t) {
        String[] split = t.split("");
        split[t.length() - 1] = "";
        StringBuilder sb = new StringBuilder();
        for (String value : split) {
            sb.append(value);
        }
        t = sb.toString();
        return t;
    }
}