import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        long k = Long.parseLong(br.readLine());

        System.out.println(thueMorse(k));
    }

    static long findLen(long x) {
        long len = 1;
        while (len < x) {
            len *= 2;
        }
        return len / 2;
    }

    static long thueMorse(long x) {
        if (x == 1) return 0;
        long len = findLen(x);
        return 1 - thueMorse(x - len);
    }
}
