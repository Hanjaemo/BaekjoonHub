import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i = 1;
        int apocalypseNumber = 0;
        while (n > 0) {
            if (String.valueOf(i).contains("666")) {
                apocalypseNumber = i;
                n--;
            }
            i++;
        }
        System.out.println(apocalypseNumber);
    }
}