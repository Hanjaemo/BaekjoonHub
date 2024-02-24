import java.util.*;

class Solution {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        
        for (int i=0;i<computers.length;i++) {
            for (int j=0;j<computers[i].length;j++) {
                graph.add(new ArrayList<>());
            }
        }
        
        for (int i=0;i<computers.length;i++) {
            for (int j=0;j<computers[i].length;j++) {
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for (int i=0;i<computers.length;i++) {
            bfs(i);
        }
        
        return answer;
    }
    
    // bfs
    public void bfs(int node) {
        if (visited[node]) {
            return;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i=0;i<graph.get(now).size();i++) {
                int adj = graph.get(now).get(i);
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
        
        answer++;
    }
}