import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};
    static Map<Integer, String> convertDirectionInfo = new HashMap<>();
    static Deque<Point> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            convertDirectionInfo.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        snake.add(new Point(1, 1));

        int time = 0;
        int direction = 0;
        while (true) {
            time++;

            boolean isDie = move(board, direction);
            if (isDie) {
                System.out.println(time);
                return;
            }

            if (convertDirectionInfo.containsKey(time)) {
                direction = rotate(direction, convertDirectionInfo.get(time));
            }
        }
    }

    private static boolean move(int[][] board, int direction) {
        if (!snake.isEmpty()) {
            Point head = snake.peekFirst();
            int nr = head.r + dRow[direction];
            int nc = head.c + dCol[direction];
            if (isOutOfBoard(nr, nc) || snake.contains(new Point(nr, nc))) {
                return true;
            }

            if (board[nr][nc] == -1) { // 이동 방향에 사과가 있을 경우
                snake.addFirst(new Point(nr, nc));
                board[nr][nc] = 0;
            } else {
                snake.addFirst(new Point(nr, nc));
                snake.pollLast();
            }
        }
        return false;
    }

    private static boolean isOutOfBoard(int nr, int nc) {
        return nr < 1 || nr > N || nc < 1 || nc > N;
    }

    // 90도 회전
    public static int rotate(int currentDirection, String direction) {
        if (direction.equals("D")) {
            if (currentDirection == 3) {
                return 0;
            }
            return currentDirection + 1;
        } else {
            if (currentDirection == 0) {
                return 3;
            }
            return currentDirection - 1;
        }
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Point point = (Point) o;
        return r == point.r && c == point.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}
