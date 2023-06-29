import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int w, h, answer;
    private static char[][] map;
    private static final Queue<Pair> fireQ = new LinkedList<>();
    private static final Queue<Pair> sangQ = new LinkedList<>();
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            inputMapSize();
            setMap();
            solve();
            clear();
        }
        System.out.println(sb);
    }

    private static void inputMapSize() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
    }

    private static void setMap() throws IOException {
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == '*') {
                    fireQ.offer(new Pair(i, j));
                }
                if (map[i][j] == '@') {
                    sangQ.offer(new Pair(i, j));
                }
            }
        }
    }

    private static void solve() {
        answer = 0;
        bfs();
        if (answer == 0) {
            sb.append("IMPOSSIBLE\n");
        } else {
            sb.append(answer + "\n");
        }
    }

    private static void bfs() {
        while (!sangQ.isEmpty()) {
            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                Pair fire = fireQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = fire.getX() + dx[j];
                    int ny = fire.getY() + dy[j];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }
                    if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                        fireQ.offer(new Pair(nx, ny));
                        map[nx][ny] = '*';
                    }
                }
            }
            int sangSize = sangQ.size();
            for (int i = 0; i < sangSize; i++) {
                Pair sang = sangQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = sang.getX() + dx[j];
                    int ny = sang.getY() + dy[j];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        answer = sang.getTime() + 1;
                        return;
                    }
                    if (map[nx][ny] == '.') {
                        sangQ.offer(new Pair(nx, ny, sang.getTime() + 1));
                        map[nx][ny] = '@';
                    }
                }
            }
        }

    }

    private static void clear() {
        fireQ.clear();
        sangQ.clear();
    }
}

class Pair {
    private int x;
    private int y;
    private int time;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }
}