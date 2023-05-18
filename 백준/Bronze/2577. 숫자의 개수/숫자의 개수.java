import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int a, b, c;
    private static final int NUMBERS_SIZE = 10;

    public static void main(String[] args) throws IOException {
        int[] result = new int[NUMBERS_SIZE];

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        int mul = a * b * c;
        String str = String.valueOf(mul);

        for (int i = 0; i < String.valueOf(mul).length(); i++) {
            for (int j = 0; j < NUMBERS_SIZE; j++) {
                if (Integer.parseInt(String.valueOf(str.charAt(i))) == j) {
                    result[j] += 1;
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}