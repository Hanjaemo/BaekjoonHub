import java.util.*;

class Solution {
    static List<List<Edge>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        for (int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<road.length;i++) {
            int s = road[i][0];
            int e = road[i][1];
            int d = road[i][2];
            graph.get(s).add(new Edge(e, d));
            graph.get(e).add(new Edge(s, d));
        }
        
        int[] distance = new int[N+1];
        for (int i=2;i<=N;i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        for (int i=1;i<=N;i++) {
            Collections.sort(graph.get(i));
        }
        
        dijkstra(1, distance);
        return answer(distance, K);
    }
    
    public void dijkstra(int startNode, int[] distance) {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startNode, 0));
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            for (int i=0;i<graph.get(now.n).size();i++) {
                Edge adj = graph.get(now.n).get(i);
                if (distance[adj.n] > distance[now.n] + adj.d) {
                    distance[adj.n] = distance[now.n] + adj.d;
                    pq.add(new Edge(adj.n, distance[adj.n]));
                }
            }
        }
    }
    
    public int answer(int[] distance, int K) {
        int cnt = 0;
        for (int i=1;i<distance.length;i++) {
            if (distance[i] <= K) {
                cnt++;
            }
        }
        
        return cnt;
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