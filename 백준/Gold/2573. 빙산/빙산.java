import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0. 시간은 1부터 시작
 * 1. 배열 순회하며 빙산 녹이기
 * 2. BFS로 덩어리 개수 카운트
 * 3. if 덩어리 개수 >= 2 : 시간 출력 및 종료
 * 4. if 전부 녹음 : 0 출력 및 종료
 * 5. 시간 1 증가
 */
public class Main {
    static int row, col;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1;
        while (true) {
            int[][] newMap = createMapWithCountForAroundWater(map);
            melt(map, newMap);
            int count = countChunk(map);
            if (count >= 2) {
                System.out.println(answer);
                break;
            }
            if (isAllMelt(map)) {
                System.out.println(0);
                return;
            }
            answer++;
        }
    }

    public static int[][] createMapWithCountForAroundWater(int[][] map) {
        int[][] newMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dRow[d];
                    int nc = j + dCol[d];
                    if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                        continue;
                    }
                    if (map[nr][nc] == 0) {
                        count++;
                    }
                }
                newMap[i][j] = count;
            }
        }
        return newMap;
    }

    public static void melt(int[][] map, int[][] newMap) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                int countForAroundWater = newMap[i][j];
                for (int k = 0; k < countForAroundWater; k++) {
                    if (map[i][j] == 0) {
                        break;
                    }
                    map[i][j]--;
                }
            }
        }
    }

    public static int countChunk(int[][] map) {
        boolean[][] visited = new boolean[row][col];

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(map, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int[][] map, boolean[][] visited, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                    continue;
                }
                if (map[nr][nc] > 0 && !visited[nr][nc]) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean isAllMelt(int[][] map) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}