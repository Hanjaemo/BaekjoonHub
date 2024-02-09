import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 testCase
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼 반복
        for (int t = 0; t < testCase; t++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            game(w, k);
        }
    }

    public static void game(String w, int k) {
        int minLen = 10001;
        int maxLen = 0;
        // for (i=0~w길이-1)
            // count = 0
            // for (j=i~w길이-1)
                // if i번째 문자 == j번째 문자 : count++
                // if count == k
                    // minLen = min(minLen, j-i+1)
                    // maxLen = min(maxLen, j-i+1)
                    // 탈출
        for (int i = 0; i < w.length(); i++) {
            int count = 0;
            for (int j = i; j < w.length(); j++) {
                if (w.charAt(i) == w.charAt(j)) {
                    count++;
                }
                if (count == k) {
                    minLen = Math.min(minLen, j - i + 1);
                    maxLen = Math.max(maxLen, j - i + 1);
                    break;
                }
            }
        }

        if (minLen == 10001 || maxLen == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minLen + " " + maxLen);
        }
    }
}