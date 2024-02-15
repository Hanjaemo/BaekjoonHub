import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] board;
    static int[] dRow = {-1, 0, 1, 0}; // 북동남서 순서
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int moveCount = Integer.parseInt(st.nextToken());

        board = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = {1, 2, 3, 4, 5, 6};

        int direction = 1; // 이동 방향
        int nr = 1;
        int nc = 1;
        int score = 0;
        for (int k = 0; k < moveCount; k++) {
            // 주사위 이동
            int nextR = nr + dRow[direction];
            int nextC = nc + dCol[direction];
            if (nextR <= 0 || nextR > row || nextC <= 0 || nextC > col) {
                if (direction == 0 || direction == 1) {
                    direction += 2;
                } else {
                    direction -= 2;
                }
            }
            nr += dRow[direction];
            nc += dCol[direction];

            int tmp;
            switch (direction) {
                case 0: // 북
                    tmp = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = dice[0];
                    dice[0] = tmp;
                    break;
                case 1: // 동
                    tmp = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = dice[0];
                    dice[0] = tmp;
                    break;
                case 2: // 남
                    tmp = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = dice[0];
                    dice[0] = tmp;
                    break;
                case 3: // 서
                    tmp = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = tmp;
                    break;
            }

            // 점수 획득
            int count = bfs(nr, nc, board[nr][nc]);
            score += count * board[nr][nc];

            // 이동 방향 결정
            int a = dice[5];
            int b = board[nr][nc];

            if (a > b) {
                if (direction == 3) {
                    direction = 0;
                } else {
                    direction++;
                }
            } else if (a < b) {
                if (direction == 0) {
                    direction = 3;
                } else {
                    direction--;
                }
            }
        }

        System.out.println(score);
    }

    static int bfs(int x, int y, int score) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row + 1][col + 1];
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dRow[d];
                int ny = now.y + dCol[d];
                if (nx <= 0 || nx > row || ny <= 0 || ny > col) {
                    continue;
                }
                if (!visited[nx][ny] && score == board[nx][ny]) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}