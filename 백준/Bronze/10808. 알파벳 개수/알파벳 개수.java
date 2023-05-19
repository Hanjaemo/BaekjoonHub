import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s;
    private static final int ALPHABET_COUNT = 26;
    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                                      'h', 'i', 'j', 'k', 'l', 'm', 'n',
                                      'o', 'p', 'q', 'r', 's', 't', 'u',
                                      'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        int[] result = new int[ALPHABET_COUNT];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < ALPHABET_COUNT; j++) {
                if (s.charAt(i) == alphabet[j]) {
                    result[j] += 1;
                }
            }
        }
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}