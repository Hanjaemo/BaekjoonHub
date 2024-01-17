import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VALUE = 10_000_001;

    public static void main(String[] args) throws IOException {
        // 도시 개수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 버스 개수 m
        int m = Integer.parseInt(br.readLine());

        // 2차원 인접 행렬 배열 dist
        int[][] dist = new int[n + 1][n + 1];
        // dist 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = MAX_VALUE;
                }
            }
        }

        // for (m번 반복)
            // 시작 도시 a, 도착 도시 b, 비용 c
            // dist[a][b] = min(dist[a][b], c)
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        // for (i=1~n)
            // 경유지 m = i
            // for (j=1~n)
                // 시작 도시 s = j
                // for (k=1~n)
                    // 도착 도시 e = k
                    // dist[s][e] = min(dist[s][e], dist[s][m]+dist[m][e])
        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    dist[start][end] = Math.min(dist[start][end], dist[start][mid] + dist[mid][end]);
                }
            }
        }

        // for (i=1~n)
            // i에서 j로 가는데 필요한 비용 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}