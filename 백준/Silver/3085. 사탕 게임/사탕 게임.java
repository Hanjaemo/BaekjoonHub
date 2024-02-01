import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] board;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = split[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(j, i, j + 1, i);
                search();
                swap(j, i, j + 1, i);
            }
        }

        System.out.println(result);
    }

    public static void swap(int r1, int c1, int r2, int c2) {
        String tmp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = tmp;
    }

    public static void search() {
        for (int i = 0; i < board.length; i++) {
            int count = 1;
            for (int j = 0; j < board.length - 1; j++) {
                if (board[i][j].equals(board[i][j + 1])) {
                    count++;
                    result = Math.max(result, count);
                } else {
                    count = 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            int count = 1;
            for (int j = 0; j < board.length - 1; j++) {
                if (board[j][i].equals(board[j + 1][i])) {
                    count++;
                    result = Math.max(result, count);
                } else {
                    count = 1;
                }
            }
        }
    }
}