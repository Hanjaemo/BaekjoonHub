import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 배열 arr
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 도시의 수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // arr 초기화
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        // 여행 계획에 속한 도시들의 수 m
        int m = Integer.parseInt(br.readLine());

        // for (i=1~n)
            // 연결 정보 입력
            // for (j=1~n)
                // if 입력 받은 정보 == 1 : i와 j 연결
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connection = Integer.parseInt(st.nextToken());
                if (connection == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력
        List<Integer> cities = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cities.add(Integer.parseInt(st.nextToken()));
        }

        // 여행 계획에 있는 도시들이 모두 연결되어 있는지 확인하여 결과 출력
        int o = arr[cities.get(0)];
        for (Integer city : cities) {
            if (arr[city] != o) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int getParent(int node) {
        if (arr[node] == node) {
            return node;
        }
        return arr[node] = getParent(arr[node]);
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    private static int find(int node) {
        return getParent(node);
    }
}