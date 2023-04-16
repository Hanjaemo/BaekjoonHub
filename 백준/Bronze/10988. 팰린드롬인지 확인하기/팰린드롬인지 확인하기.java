import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(valid(str));
    }

    static int valid(String str) {
        int strLen = str.length();
        for (int i = 0; i < strLen / 2; i++) {
            if (str.charAt(i) == str.charAt(strLen - i - 1)) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }
}