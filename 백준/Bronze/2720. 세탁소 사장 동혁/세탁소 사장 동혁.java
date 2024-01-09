import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] coins = {25, 10, 5, 1};
        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());
            int[] counts = new int[coins.length];
            for (int j = 0; j < coins.length; j++) {
                if (c >= coins[j]) {
                    counts[j] = c / coins[j];
                    c %= coins[j];
                }
            }
            for (int count : counts) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}