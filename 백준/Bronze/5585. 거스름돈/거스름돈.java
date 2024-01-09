import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 지불할 돈 price 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price;

        int[] arr = {500, 100, 50, 10, 5, 1};
        int count = 0;
        while (change > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (change >= arr[i]) {
                    count += change / arr[i];
                    change %= arr[i];
                    break;
                }
            }
        }

        System.out.println(count);
    }
}