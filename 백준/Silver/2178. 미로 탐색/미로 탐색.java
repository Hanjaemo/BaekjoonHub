import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int row, col;
    private static int[][] miro;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        setMiroSize();
        setMiro();
        bfs();
    }

    private static void setMiroSize() throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
    }

    private static void setMiro() throws IOException {
        miro = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                miro[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    private static void bfs() {
        boolean[][] visit = new boolean[row][col];
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (miro[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                queue.offer(new Pair(i, j));
                visit[i][j] = true;
                dist[i][j] = 0;
                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = pair.getX() + dx[k];
                        int ny = pair.getY() + dy[k];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                            continue;
                        }
                        if (miro[nx][ny] == 1 && !visit[nx][ny]) {
                            queue.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                            dist[nx][ny] = dist[pair.getX()][pair.getY()] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(dist[row - 1][col - 1] + 1);
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