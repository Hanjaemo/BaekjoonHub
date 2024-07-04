import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }

        Arrays.sort(inputs, (a, b) -> b.length() - a.length());

        int maxLen = inputs[0].length();
        char[][] chars = new char[n][maxLen];
        for (int i = 0; i < n; i++) {
            String input = inputs[i];
            int idx = maxLen - input.length();
            int idxOfInput = 0;
            for (int j = 0; j < idx; j++) {
                chars[i][j] = '.';
            }
            for (int j = idx; j < maxLen; j++) {
                chars[i][j] = input.charAt(idxOfInput);
                idxOfInput++;
            }
        }

//        for (char[] aChar : chars) {
//            for (char c : aChar) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }

        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);

        int weight = 1;
        for (int i = maxLen - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                char ch = chars[j][i];
                if (ch == '.') {
                    continue;
                }
                arr[ch - 'A'] += weight;
            }
            weight *= 10;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;
        int num = 9;
        for (Integer integer : arr) {
            if (integer == 0) {
                break;
            }
            answer += integer * num;
            num--;
            if (num < 0) {
                break;
            }
        }

        System.out.println(answer);
    }
}