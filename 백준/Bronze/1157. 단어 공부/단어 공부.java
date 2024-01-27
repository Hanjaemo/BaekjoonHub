import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        int[] arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 65]++;
        }

        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }

        int count = 0;
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (max == arr[i]) {
                count++;
                answer = i;
            }
        }

        if (count == 1) {
            System.out.println((char) (answer + 'A'));
        } else {
            System.out.println("?");
        }
    }
}