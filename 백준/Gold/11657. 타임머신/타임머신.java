import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Edge> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] distance = new long[n + 1];
        distance[1] = 0;
        for (int i = 2; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.add(new Edge(s, e, w));
        }

        bellmanFord(distance);
    }

    private static void bellmanFord(long[] distance) {
        for (int i = 1; i < distance.length; i++) {
            for (Edge now : graph) {
                if (distance[now.s] != Integer.MAX_VALUE && distance[now.e] > distance[now.s] + now.w) {
                    distance[now.e] = distance[now.s] + now.w;
                }
            }
        }

        for (Edge now : graph) {
            if (distance[now.s] != Integer.MAX_VALUE && distance[now.e] > distance[now.s] + now.w) {
                distance[now.e] = distance[now.s] + now.w;
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}

class Edge {
    int s, e, w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}