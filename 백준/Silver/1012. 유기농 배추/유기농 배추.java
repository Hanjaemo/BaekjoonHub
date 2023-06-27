import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int col, row, posCount;
    private static int[][] map;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input();
            setMap();
            System.out.println(bfs());
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        posCount = Integer.parseInt(st.nextToken());
    }

    private static void setMap() throws IOException {
        map = new int[row][col];
        for (int i = 0; i < posCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y= Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }
    }

    private static int bfs() {
        boolean[][] visit = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                queue.offer(new Pair(i, j));
                visit[i][j] = true;
                count++;
                while (!queue.isEmpty()) {
                    Pair p = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = p.getX() + dx[k];
                        int ny = p.getY() + dy[k];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                            continue;
                        }
                        if (map[nx][ny] == 1 && !visit[nx][ny]) {
                            queue.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return count;
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