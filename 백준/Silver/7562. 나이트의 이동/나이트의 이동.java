import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] board;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int l = Integer.parseInt(br.readLine());
            setBoard(l);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());
            System.out.println(bfs(nextX, nextY));
            cleanBoard();
            queue.clear();
        }
    }

    private static void setBoard(int l) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        board = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == x && j == y) {
                    board[i][j] = 1;
                    queue.offer(new Pair(i, j));
                }
            }
        }
    }

    private static int bfs(int nextX, int nextY) {
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[p.getX()][p.getY()] + 1;
                    queue.offer(new Pair(nx, ny));
                }
                if (nx == nextX && ny == nextY) {
                    return board[nx][ny] - 1;
                }
            }
        }
        return 0;
    }

    private static void cleanBoard(){
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
    }
}

class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}