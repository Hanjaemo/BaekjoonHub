import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitForMinus = input.split("-");
        for (int i = 0; i < splitForMinus.length; i++) {
            String[] splitForPlus = splitForMinus[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < splitForPlus.length; j++) {
                sum += Integer.parseInt(splitForPlus[j]);
            }
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}