import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, m;
    private static int[][] store;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        setStore();
        bfs();
        printAnswer();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
    }

    private static void setStore() throws IOException {
        store = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                store[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bfs() {
        offerTomato();
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (store[nx][ny] == 0) {
                    queue.offer(new Pair(nx, ny));
                    store[nx][ny] = store[p.getX()][p.getY()] + 1;
                }
            }
        }
    }

    private static void offerTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (store[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
    }

    private static void printAnswer() {
        if (isFail()) {
            System.out.println(-1);
        } else {
            int max = findDay();
            System.out.println(max);
        }
    }

    private static boolean isFail() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (store[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int findDay() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < store[i][j]) {
                    max = store[i][j];
                }
            }
        }
        return max - 1;
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