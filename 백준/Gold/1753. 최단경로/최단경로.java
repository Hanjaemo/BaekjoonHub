import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 노드 수 n, 에지 수 e 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 출발 노드 start 입력
        int k = Integer.parseInt(br.readLine());

        // 최단 거리 배열 dist 생성
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == k) {
                dist[i] = 0;
                continue;
            }
            dist[i] = Integer.MAX_VALUE;
        }

        // 노드와 연결 노드, 가중치를 저장하는 리스트 arr 생성
        List<List<Node>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        // for (e번 반복)
            // 출발 노드, 도착 노드, 가중치 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, weight));
        }

        // 우선 순위 큐 생성 (작은 값 우선)
        Queue<Node> queue = new PriorityQueue<>();
        // 큐에 시작 노드 저장
        queue.offer(new Node(k, 0));

        // 방문 기록 배열 visited
        boolean[] visited = new boolean[n + 1];
        // while (큐에 요소 존재)
            // 큐에서 뺀 노드 now
            // if 방문한 노드 : continue
            // 노드 방문 처리
            // for (arr.get(now) 탐색)
                // now와 연결된 노드 큐에 저장
                // 연결 노드의 최단 거리 배열 업데이트
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;
            for (int i = 0; i < arr.get(now.vertex).size(); i++) {
                Node next = arr.get(now.vertex).get(i);
                if (dist[next.vertex] > dist[now.vertex] + next.weight) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    queue.offer(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        // 최단 거리 배열 출력
            // if 방문한 노드 : INF 출력
            // else : 값 출력
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        if (this.weight > other.weight) {
            return 1;
        } else {
            return -1;
        }
    }
}