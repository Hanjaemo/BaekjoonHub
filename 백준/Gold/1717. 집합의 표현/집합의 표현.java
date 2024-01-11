import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 배열 arr
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // n, m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // arr 초기화
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        // for (m번 반복)
            // 연산 종류 op, 집합 a와 b 입력
            // if (op == 0) : union(a,b)
            // else : find(a,b), 포함 여부 출력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else {
                if (find(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // 부모 노드 찾는 함수
    private static int getParent(int node) {
        if (arr[node] == node) {
            return node;
        }
        return arr[node] = getParent(arr[node]);
    }

    // union 연산
    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    // find 연산
    private static boolean find(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        return a == b;
    }
}