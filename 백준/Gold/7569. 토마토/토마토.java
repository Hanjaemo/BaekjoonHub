import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Scanner sc = new Scanner(System.in);
    private static StringTokenizer st;
    private static int col, row, height;
    private static int[][][] store;
    private static final Queue<Tomato> queue = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0, 0, 0};
    private static final int[] dy = {0, 1, 0, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};
    private static int result;

    public static void main(String[] args) throws IOException {
        input();
        setStore();
        bfs();
        System.out.println(answer());
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
    }

    private static void setStore() throws IOException {
        store = new int[height][row][col];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    store[i][j][k] = Integer.parseInt(st.nextToken());
                    if (store[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = tomato.getX() + dx[i];
                int ny = tomato.getY() + dy[i];
                int nz = tomato.getZ() + dz[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || nz < 0 || nz >= height) {
                    continue;
                }
                if (store[nz][nx][ny] == 0) {
                    queue.offer(new Tomato(nz, nx, ny));
                    store[nz][nx][ny] = store[tomato.getZ()][tomato.getX()][tomato.getY()] + 1;
                }
            }
        }
    }

    private static int answer() {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (store[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, store[i][j][k]);
                }
            }
        }
        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}

class Tomato {
    private int x;
    private int y;
    private int z;

    public Tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}