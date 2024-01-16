import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_POSITION = 100000;

    public static void main(String[] args) throws IOException {
        // 수빈이 위치 n, 동생 위치 k
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(dijkstra(n, k));
        }
    }

    private static int dijkstra(int n, int k) {
        // 최단 거리 배열 초기화
        int[] dist = new int[MAX_POSITION + 1];
        for (int i = 1; i <= MAX_POSITION; i++) {
            dist[i] = MAX_POSITION;
        }
        dist[n] = 0;
        
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(n, dist[n]));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (dist[now.v] < now.d) {
                continue;
            }

            int nv1 = now.v * 2;
            if (valid(nv1) && dist[nv1] > now.d) {
                dist[nv1] = Math.min(dist[nv1], now.d);
                queue.offer(new Node(nv1, dist[nv1]));
            }

            int nv2 = now.v + 1;
            if (valid(nv2) && dist[nv2] > now.d + 1) {
                dist[nv2] = Math.min(dist[nv2], now.d + 1);
                queue.offer(new Node(nv2, dist[nv2]));
            }

            int nv3 = now.v - 1;
            if (valid(nv3) && dist[nv3] > now.d + 1) {
                dist[nv3] = Math.min(dist[nv3], now.d + 1);
                queue.offer(new Node(nv3, dist[nv3]));
            }
        }
        
        return dist[k];
    }

    private static boolean valid(int v) {
        return 0 <= v && v <= MAX_POSITION;
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