import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. x의 배수인 원판을 d 방향으로 k칸 회전
 * 2. 인접한 수 탐색 및 제거
 * 3. 제거된 인접한 수가 없다면 평균 계산 후 증감
 * 4. T만큼 반복
 */
public class Main {
    static int[][] map;
    static boolean[][] adjMap;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int turn = 0; turn < t; turn++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int i = x; i <= n; i++) {
                if (i % x == 0) {
                    rotate(i, d, k);
                }
            }

            adjMap = new boolean[n + 1][m];
            searchAdjAndToZero(n, m);

            if (notContainsAdj(n, m)) {
                double avg = calculateAvg(n, m);
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == 0) {
                            continue;
                        }
                        if (map[i][j] > avg) {
                            map[i][j]--;
                        } else if (map[i][j] < avg) {
                            map[i][j]++;
                        }
                    }
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (adjMap[i][j]) {
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    public static void rotate(int n, int d, int k) {
        int[] arr = map[n];
        if (d == 0) {
            for (int i = 0; i < k; i++) {
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else {
            for (int i = 0; i < k; i++) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
    }

    public static void searchAdjAndToZero(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int base = map[i][j];
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dRow[d];
                        int nc = j + dCol[d];
                        if (nr < 1) {
                            continue;
                        } else if (nr > n) {
                            continue;
                        } else if (nc < 0) {
                            toTrueIfAdj(base, nr, m - 1, i, j);
                            continue;
                        } else if (nc >= m) {
                            toTrueIfAdj(base, nr, 0, i, j);
                            continue;
                        }
                        toTrueIfAdj(base, nr, nc, i, j);
                    }
                }
            }
        }
    }

    private static void toTrueIfAdj(int base, int nr, int nc, int i, int j) {
        if (base == map[nr][nc]) {
            adjMap[nr][nc] = true;
            adjMap[i][j] = true;
        }
    }

    public static boolean notContainsAdj(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (adjMap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double calculateAvg(int n, int m) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                total += map[i][j];
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    cnt++;
                }
            }
        }
        return (double) total / cnt;
    }
}