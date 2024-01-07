import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 배열 arr
    static List<List<Integer>> arr;
    // 방문 배열 visited
    static boolean[] visited;
    // 연결 요소 개수 count
    static int count;

    public static void main(String[] args) throws IOException {
        // 노드 개수 n, 에지 개수 m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 arr, visited, count 초기화
        arr = new ArrayList<>();
        visited = new boolean[n + 1];
        count = 0;

        // 배열 arr에 인접리스트 저장
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // for (i=1~n)
            // if 방문하지 않은 노드 : count++
            // dfs 탐색
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
            }
            dfs(i);
        }

        // 연결 요소 개수 출력
        System.out.println(count);
    }

    private static void dfs(int v) {
        // if 이미 방문한 노드 : 종료
        if (visited[v]) {
            return;
        }

        // 방문 처리
        visited[v] = true;

        // for (i=0~arr.get(v).size()-1)
            // if 방문하지 않은 노드 : dfs 탐색
        for (int i = 0; i < arr.get(v).size(); i++) {
            int now = arr.get(v).get(i);
            if (!visited[now]) {
                dfs(now);
            }
        }
    }
}