import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        int max = -1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int dr = -row; dr < row; dr++) {
                    for (int dc = -col; dc < col; dc++) {
                        if (dr == 0 && dc == 0) {
                            continue;
                        }
                        int num = 0;
                        int nRow = r;
                        int nCol = c;
                        while (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col) {
                            num = 10 * num + arr[nRow][nCol];
                            if (isPerfectSquareNumber(num)) {
                                max = Math.max(max, num);
                            }
                            nRow += dr;
                            nCol += dc;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isPerfectSquareNumber(int num) {
        int sqrt = (int) Math.sqrt(num);
        return Math.pow(sqrt, 2) == num;
    }
}