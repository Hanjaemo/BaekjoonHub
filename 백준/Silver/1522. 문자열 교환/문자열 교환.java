import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("");
        if (strings.length <= 3) {
            System.out.println(0);
            return;
        }
        int aCnt = 0;
        for (String string : strings) {
            if (string.equals("a")) {
                aCnt++;
            }
        }

        int n = strings.length;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                if (strings[j % n].equals("b")) {
                    bCnt++;
                }
            }
            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);
    }
}