import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        recursion(row, col, (int) Math.pow(2, n));
        System.out.println(count);
    }

    public static void recursion(int r, int c, int len) {
        if (len == 1) {
            return;
        }

        int half = len / 2;
        if (r < half && c < half) {
            recursion(r, c, half);
        } else if (r < half && c >= half) {
            count += (len * len) / 4;
            recursion(r, c - half, half);
        } else if (r >= half && c < half) {
            count += (len * len) / 4 * 2;
            recursion(r - half, c, half);
        } else {
            count += (len * len) / 4 * 3;
            recursion(r - half, c - half, half);
        }
    }
}