import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    // 배열 선언
    static List<List<Integer>> arr = new ArrayList<>();
    // 경로 배열 선언
    static List<Integer> route = new ArrayList<>();
    // 방문 배열 선언
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 노드 개수 n, 에지 개수 m, 시작 노드 v 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 배열에 인접 리스트 저장
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

        // 노드 정렬
        for (int i = 1; i < arr.size(); i++) {
            Collections.sort(arr.get(i));
        }

        // 경로, 방문 배열 초기화
        visited = new boolean[n + 1];

        // dfs
        dfs(v, 1);
        // dfs 경로 출력
        printResult();

        // 경로, 방문 배열 초기화
        route.clear();
        visited = new boolean[n + 1];

        // bfs
        bfs(v);
        // bfs 경로 출력
        printResult();
    }

    private static void printResult() {
        String result = route.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void dfs(int v, int depth) {
        // if 이미 방문 : 종료
        if (visited[v]) {
            return;
        }

        // 방문 처리
        visited[v] = true;
        // 경로 추가
        route.add(v);
        // for (i=0~arr.get(v).size()-1)
            // dfs(arr.get(v).get(i), depth+1)
        for (int i = 0; i < arr.get(v).size(); i++) {
            dfs(arr.get(v).get(i), depth + 1);
        }
    }

    private static void bfs(int v) {
        // v 방문 처리
        visited[v] = true;
        // 경로에 v 추가
        route.add(v);
        // 큐에 인접 노드 저장
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.get(v).size(); i++) {
            queue.offer(arr.get(v).get(i));
        }

        // while (큐에 요소 존재)
            // 큐에서 빼낸 요소를 v에 저장
            // if (방문x)
                // 방문 처리
                // 경로 추가
                // 큐에 인접 노드 저장
        while (!queue.isEmpty()) {
            v = queue.poll();
            if (!visited[v]) {
                visited[v] = true;
                route.add(v);
                for (int i = 0; i < arr.get(v).size(); i++) {
                    Integer adj = arr.get(v).get(i);
                    if (!visited[adj] && !queue.contains(adj)) {
                        queue.offer(adj);
                    }
                }
            }
        }
    }
}