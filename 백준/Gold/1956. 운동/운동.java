import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VALUE = 10_000_001;
    public static void main(String[] args) throws IOException {
        // 마을 개수 n, 도로 개수 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 행렬 dist
        int[][] dist = new int[n + 1][n + 1];

        // dist 내 모든 요소를 최댓값으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = MAX_VALUE;
            }
        }

        // for (m번 반복)
            // 에지 정보 입력 받아 dist에 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        // for (k=1~n)
            // for (i=1~n)
                // for (j=1~n)
                    // if (dist[i][j] > dist[i][k] + dist[k][j]
                        // dist[i][j] = dist[i][k] + dist[k][j]
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // dist를 탐색하여 자기 자신을 가리키는 요소 중 가장 작은 값 출력
            // 모두 최댓값이라면 -1 출력
        int min = MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        if (min < MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}