import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static String[] title;
    static int[] powers;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        title = new String[n];
        powers = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(binarySearch(powers.length, power));
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    static String binarySearch(int len, int key) {
        int pl = 0;
        int pr = len - 1;
        int pc;

        while (pl <= pr) {
            pc = (pl + pr) / 2;
            if (powers[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }
        return title[pl] + "\n";
    }
}
