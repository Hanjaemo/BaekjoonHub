import java.util.*;

class Solution {
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] distance;
    
    public int solution(int n, int[][] road, int k) {
        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<road.length;i++) {
            int a = road[i][0];
            int b = road[i][1];
            int d = road[i][2];
            graph.get(a).add(new Edge(b, d));
            graph.get(b).add(new Edge(a, d));
        }
        
        for (List<Edge> list : graph) {
            Collections.sort(list);
        }
        
        dijkstra(n, 1);
        
        int answer = 0;
        for (int i=1;i<=n;i++) {
            if (distance[i] <= k) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int n, int start) {
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            for (int i=0;i<graph.get(now.n).size();i++) {
                Edge adj = graph.get(now.n).get(i);
                if (distance[adj.n] > distance[now.n] + adj.d) {
                    distance[adj.n] = distance[now.n] + adj.d;
                    queue.add(new Edge(adj.n, distance[adj.n]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int n, d;
    
    public Edge(int n, int d) {
        this.n = n;
        this.d = d;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.d - o.d;
    }
}