import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        setGrid(n);
        int answer = split(0, 0, n);
        System.out.println(answer);
    }

    public static void setGrid(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int split(int x, int y, int n) {
        if (n == 1) {
            return grid[x][y];
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(split(x, y, n / 2));
            list.add(split(x, y + n / 2, n / 2));
            list.add(split(x + n / 2, y, n / 2));
            list.add(split(x + n / 2, y + n / 2, n / 2));

            Collections.sort(list);
            return list.get(1);
        }
    }
}
