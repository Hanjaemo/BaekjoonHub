import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    // n, m, x
    static int n, m, x;
    // graph
    static List<List<Node>> graph = new ArrayList<>();
    // 정답 배열 answer
    static int[] answer;

    public static void main(String[] args) throws IOException {
        // 마을 수 n, 도로 수 m, 파티 마을 x 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        answer = new int[n + 1];

        // graph 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // for (m번 반복)
            // 시작점, 끝점, 소요시간 입력 받아 graph 구현
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, d));
        }

        // for (i=1~n)
            // if i != x : 다익스트라(i)
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                dijkstra(i);
            }
        }

        // 돌아가는 다익스트라
        returnDijkstra(x);

        // answer 배열에서 가장 큰 값 출력
        int max = 0;
        for (int i : answer) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        // 우선 순위 큐 생성
        Queue<Node> queue = new PriorityQueue<>();

        // 최단 거리 배열 dist 초기화
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = MAX_VALUE;
        }

        // dist[start] = 0
        dist[start] = 0;
        // 큐에 start 노드 저장
        queue.offer(new Node(start, dist[start]));

        // while (큐에 원소 존재)
            // 큐에서 꺼낸 노드 now
            // if now.v == x
                // answer[start] = dist[now.v]
                // 종료
            // for (now와 연결된 노드 탐색)
                // now가 가리키는 노드 next
                // if next.d + now.d < dist[next.v]
                    // dist[next] 업데이트
                    // 큐에 노드(next.v, dist[next.v]) 저장
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.v == x) {
                answer[start] = dist[now.v];
                return;
            }
            for (int i = 0; i < graph.get(now.v).size(); i++) {
                Node next = graph.get(now.v).get(i);
                if (next.d + now.d < dist[next.v]) {
                    dist[next.v] = next.d + now.d;
                    queue.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    private static void returnDijkstra(int x) {
        // 우선 순위 큐 생성
        Queue<Node> queue = new PriorityQueue<>();
        // 방문 기록 배열 visited
        boolean[] visited = new boolean[n + 1];
        // 최단 거리 배열 dist 초기화
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = MAX_VALUE;
        }

        // dist[x] = 0
        dist[x] = 0;
        // 큐에 x 노드 저장
        queue.offer(new Node(x, dist[x]));

        // while (큐에 원소 존재)
            // 큐에서 꺼낸 노드 now
            // if now.v가 방문하지 않은 노드
                // now.v 방문 처리
                // answer[now.v] += now.d
            // for (now와 연결된 노드 탐색)
                // now가 가리키는 노드 next
                // if next.d + now.d < dist[next.v]
                    // dist[next] 업데이트
                    // 큐에 노드(next.v, dist[next.v]) 저장
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                answer[now.v] += now.d;
            }
            for (int i = 0; i < graph.get(now.v).size(); i++) {
                Node next = graph.get(now.v).get(i);
                if (next.d + now.d < dist[next.v]) {
                    dist[next.v] = next.d + now.d;
                    queue.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int v;
    int d;

    public Node(int v, int d) {
        this.v = v;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
}