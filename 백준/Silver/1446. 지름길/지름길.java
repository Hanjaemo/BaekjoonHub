import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();
        int[] dp = new int[10001];
        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
        }
        
        for (int i = 0; i < d; i++) {
            if (dp[i] < dp[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }
            List<Edge> edges = graph.get(i);
            for (Edge edge : edges) {
                if (dp[i] + edge.weight < dp[edge.node]) {
                    dp[edge.node] = dp[i] + edge.weight;
                }
            }
        }

        System.out.println(dp[d]);
    }
}

class Edge {
    int node, weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}