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
    private static int[][] map;
    private static boolean[][] visit;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        setMapSize();
        setMap();
        bfs();
    }

    private static void setMapSize() throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
    }

    private static void setMap() throws IOException {
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bfs() {
        int count = 0;
        int area = 0;
        int maxArea = 0;
        visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                queue.offer(new Pair(i, j));
                visit[i][j] = true;
                count++;
                area = 0;
                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    area++;
                    for (int k = 0; k < 4; k++) {
                        int nx = pair.getX() + dx[k];
                        int ny = pair.getY() + dy[k];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                            continue;
                        }
                        if (map[nx][ny] == 1 && !visit[nx][ny]) {
                            queue.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
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