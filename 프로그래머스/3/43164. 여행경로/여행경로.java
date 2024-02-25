import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> path = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(path);
        
        return path.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String depart, String route, int count) {
        if (count == tickets.length) {
            path.add(route);
            return;
        }
        
        for (int i=0;i<tickets.length;i++) {
            if (depart.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], route+" "+tickets[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}