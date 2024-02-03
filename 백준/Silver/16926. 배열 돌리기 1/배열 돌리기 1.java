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
        int rotation = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lineCount = Math.min(row, col) / 2;
        for (int r = 0; r < rotation; r++) {
            for (int i = 0; i < lineCount; i++) {
                int tmp = arr[i][i];
                for (int j = i + 1; j <= col - 1 - i; j++) {
                    arr[i][j - 1] = arr[i][j];
                }
                for (int j = i + 1; j <= row - 1 - i; j++) {
                    arr[j - 1][col - 1 - i] = arr[j][col - 1 - i];
                }
                for (int j = col - 1 - i; j >= i + 1; j--) {
                    arr[row - 1 - i][j] = arr[row - 1 - i][j - 1];
                }
                for (int j = row - 1 - i; j >= i + 1; j--) {
                    arr[j][i] = arr[j - 1][i];
                }
                arr[i + 1][i] = tmp;
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}