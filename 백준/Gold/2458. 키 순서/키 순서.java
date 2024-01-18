import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_VALUE = 10_000_001;
    public static void main(String[] args) throws IOException {
        // 학생 수 n, 비교 수 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 행렬 dist
        int[][] dist = new int[n + 1][n + 1];

        // dist에서 자기 자신은 1, 나머지는 무한으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = MAX_VALUE;
                }
            }
        }

        // for (m번 반복)
            // 비교 정보 입력 받아 dist에 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        // for (k=1~n)
            // for (i=1~n)
                // for (j=1~n)
                    // if dist[i][j] > dist[i][k] + dist[k][j]
                        // dist[i][j] = 1
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        // 각 요소마다 알고 있는 학생 수를 저장하는 배열 counts
        int[] counts = new int[n + 1];
        // for (i=1~n)
            // for (j=1~n)
                // if (dist[i][j] == 1) : counts[i]++
            // for (j=1~n)
                // if (dist[j][i] == 1) : counts[i]++
            // counts[i]--
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 1) {
                    counts[i]++;
                }
            }
            for (int j = 1; j <= n; j++) {
                if (dist[j][i] == 1) {
                    counts[i]++;
                }
            }
            counts[i]--;
        }

        // counts에서 값이 6인 요소의 개수 출력
        int count = 0;
        for (int i : counts) {
            if (i == n) {
                count++;
            }
        }
        System.out.println(count);
    }
}