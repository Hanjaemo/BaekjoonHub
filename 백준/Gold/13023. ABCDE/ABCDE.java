import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> arr;
    static boolean[] visited;
    static boolean arrived;

    public static void main(String[] args) throws IOException {
        // 사람 수 n, 관계 수 m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // for (i=0~m-1)
            // 배열에 인접 리스트 저장
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // dfs
        boolean result = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 1);
            if (arrived) {
                break;
            }
        }

        // 결과 출력
        if (arrived) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int vertex, int depth) {
        // if 깊이가 5일 때 : arrived = true
        if (depth == 5) {
            arrived = true;
            return;
        }

        // if 이미 방문한 노드 : 종료
        if (visited[vertex]) {
            return;
        }

        // 방문처리
        visited[vertex] = true;

        // for (int i : arr[v])
            // if 방문 X : dfs(i, depth+1)
        for (int i = arr.get(vertex).size() - 1; i >= 0; i--) {
            if (!visited[arr.get(vertex).get(i)]) {
                dfs(arr.get(vertex).get(i), depth + 1);
            }
        }
        visited[vertex] = false;
    }
}