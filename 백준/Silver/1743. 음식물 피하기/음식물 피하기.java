import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int depth;

    public static void main(String[] args) throws IOException {
        // 통로의 세로 길이 row, 가로 길이 col, 음식물 쓰레기 개수 k
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // row x col 크기의 graph 생성
        graph = new int[row + 1][col + 1];

        // for (k번 반복)
            // 좌표를 입력 받아 graph에 1 저장
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
        }

        // visited 초기화
        visited = new boolean[row + 1][col + 1];

        int max = 0;
        depth = 0;
        // graph를 순회하며 방문하지 않은 좌표 중에서 음쓰가 존재하는 곳 dfs/bfs 탐색
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    max = Math.max(max, depth);
                    depth = 0;
                }
            }
        }

        // max 출력
        System.out.println(max);
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        depth++;

        for (int d = 0; d < 4; d++) {
            int nRow = r + dRow[d];
            int nCol = c + dCol[d];
            if (nRow < 1 || nRow > row || nCol < 1 || nCol > col) {
                continue;
            }
            if (!visited[nRow][nCol] && graph[nRow][nCol] == 1) {
                dfs(nRow, nCol);
            }
        }
    }

    public static int bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(r, c));
        visited[r][c] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nRow = now.row + dRow[d];
                int nCol = now.col + dCol[d];
                if (nRow < 1 || nRow > row || nCol < 1 || nCol > col) {
                    continue;
                }
                if (!visited[nRow][nCol] && graph[nRow][nCol] == 1) {
                    queue.add(new Point(nRow, nCol));
                    visited[nRow][nCol] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}