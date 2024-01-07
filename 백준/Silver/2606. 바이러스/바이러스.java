import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 배열 arr
    static List<List<Integer>> arr = new ArrayList<>();
    // 방문 기록 배열 visited
    static boolean[] visited;
    // 큐 queue
    static Queue<Integer> queue = new PriorityQueue<>();
    // 1번 컴퓨터와 연결된 컴퓨터 수 count
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // 컴퓨터 개수 n, 연결된 컴퓨터의 쌍 m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // arr에 인접 리스트 저장
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // visited 초기화
        visited = new boolean[n + 1];

        // bfs(1)
        bfs(1);

        System.out.println(count);
    }

    private static void bfs(int startNode) {
        // startNode 방문 처리
        visited[startNode] = true;

        // startNode 인접 노드 큐에 저장
        for (int i = 0; i < arr.get(startNode).size(); i++) {
            queue.add(arr.get(startNode).get(i));
        }

        // while (큐에 노드 존재)
            // 현재 컴퓨터 now = queue.poll()
            // now 방문처리
            // count++
            // for (now와 인접한 노드)
                // if 방문X && 큐에 존재X : 큐에 저장
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            count++;
            for (int i = 0; i < arr.get(now).size(); i++) {
                Integer adj = arr.get(now).get(i);
                if (!visited[adj] && !queue.contains(adj)) {
                    queue.add(adj);
                }
            }
        }
    }
}