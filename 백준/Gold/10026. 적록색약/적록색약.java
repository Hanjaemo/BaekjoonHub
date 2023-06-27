import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static String[][] normalMap, blindMap;
    private static StringTokenizer st;
    private static final Queue<Pair> queue = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        inputMapSize();
        setMap();
        int normalAnswer = bfs(normalMap);
        int blindAnswer = bfs(blindMap);
        System.out.print(normalAnswer + " " + blindAnswer);
    }

    private static void inputMapSize() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    private static void setMap() throws IOException {
        normalMap = new String[n][n];
        blindMap = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (split[j].equals("G")) {
                    blindMap[i][j] = "R";
                } else {
                    blindMap[i][j] = split[j];
                }
                normalMap[i][j] = split[j];
            }
        }
    }

    private static int bfs(String[][] map) {
        boolean[][] visit = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
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
                        if (outOfRange(nx, ny)) {
                            continue;
                        }
                        if (map[nx][ny].equals(map[p.getX()][p.getY()]) && !visit[nx][ny]) {
                            queue.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return count;
    }

    private static boolean outOfRange(int nx, int ny) {
        return (nx < 0 || nx >= n || ny < 0 || ny >= n);
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