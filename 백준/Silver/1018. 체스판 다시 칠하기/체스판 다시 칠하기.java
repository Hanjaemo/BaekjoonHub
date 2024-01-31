import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // 보드의 행렬 row, col
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 입력 받은 정보를 바탕으로 보드 칠하기
        String[][] board = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                board[i][j] = split[j];
            }
        }

        int min = 3000;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                String[][] partBoard = new String[8][8];
                partitionBoard(board, i, j, partBoard);

                count = 0;
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        changeColor(partBoard, r, c);
                    }
                }
                partitionBoard(board, i, j, partBoard);
                count = Math.min(count, 64 - count);
                min = Math.min(min, count);
            }
        }

        // min 출력
        System.out.println(min);
    }

    private static void partitionBoard(String[][] board, int i, int j, String[][] partBoard) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                partBoard[r][c] = board[r + i][c + j];
            }
        }
    }

    private static void changeColor(String[][] partBoard, int r, int c) {
        if (partBoard[r][c].equals("B")) {
            for (int d = 0; d < 4; d++) {
                int nRow = r + dRow[d];
                int nCol = c + dCol[d];
                if (nRow < 0 || nRow >= 8 || nCol < 0 || nCol >= 8) {
                    continue;
                }
                if (partBoard[nRow][nCol].equals("B")) {
                    partBoard[nRow][nCol] = "W";
                    count++;
                }
            }
        } else {
            for (int d = 0; d < 4; d++) {
                int nRow = r + dRow[d];
                int nCol = c + dCol[d];
                if (nRow < 0 || nRow >= 8 || nCol < 0 || nCol >= 8) {
                    continue;
                }
                if (partBoard[nRow][nCol].equals("W")) {
                    partBoard[nRow][nCol] = "B";
                    count++;
                }
            }
        }
    }
}