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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 개수 n 입력
        int n = Integer.parseInt(br.readLine());

        // 버스 개수 m 입력
        int m = Integer.parseInt(br.readLine());

        // 그래프 정보 저장하는 arr 생성
        List<List<Node>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        // 최단 거리 배열 dist 생성
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        // 방문 기록 저장 배열 visited 생성
        boolean[] visited = new boolean[n + 1];
        // 우선 순위 큐 queue 생성
        Queue<Node> queue = new PriorityQueue<>();

        // for (m번 반복)
            // 출발 도시 s, 도착 도시 e, 비용 cost 입력
            // arr.get(s).add(new Node(e, cost))
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(s).add(new Node(e, cost));
        }

        // 출발점 start, 도착점 end 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // dist[start] = 0
        dist[startCity] = 0;

        // 출발점 큐에 저장
        queue.add(new Node(startCity, 0));

        // while (큐에 노드 존재)
            // 큐에서 뽑은 노드 now
            // if now.v를 이미 방문한 경우 : continue
            // now.v 방문 처리
            // for (now.v의 연결 노드 탐색)
                // now.v의 i번째 연결 노드 next
                // if dist[next.v] > dist[now.v] + next.cost
                    // dist[next.v] = dist[now.v] + next.cost
                    // 큐에 Node(next.v, dist[next.v]) 저장
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;
            for (int i = 0; i < arr.get(now.vertex).size(); i++) {
                Node next = arr.get(now.vertex).get(i);
                if (dist[next.vertex] > dist[now.vertex] + next.cost) {
                    dist[next.vertex] = dist[now.vertex] + next.cost;
                    queue.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        // 도착점까지 최소 비용 출력
        System.out.println(dist[endCity]);
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost > o.cost) {
            return 1;
        } else {
            return -1;
        }
    }
}