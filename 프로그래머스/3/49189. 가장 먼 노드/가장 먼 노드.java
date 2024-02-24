import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
        
    public int solution(int n, int[][] edge) {
        
        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0;i<edge.length;i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] distance = new int[n + 1];
        for (int i=2;i<=n;i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        dijkstra(distance, 1);
        
        int max = 0;
        for (int i=0;i<distance.length;i++) {
            max = Math.max(max, distance[i]);
        }
        
        int answer = 0;
        for (int i=0;i<distance.length;i++) {
            if (max == distance[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int[] distance, int start) {
        boolean[] visited = new boolean[distance.length];
        Queue<Node> queue = new PriorityQueue<>();
        
        queue.add(new Node(start, 0));
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i=0;i<graph.get(now.n).size();i++) {
                int adj = graph.get(now.n).get(i);
                if (!visited[adj]) {
                    distance[adj] = Math.min(distance[now.n]+1, distance[adj]);
                    queue.add(new Node(adj, distance[adj]));
                    visited[adj] = true;
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int n, d;
    
    public Node(int n, int d) {
        this.n = n;
        this.d = d;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.d - other.d;
    }
}