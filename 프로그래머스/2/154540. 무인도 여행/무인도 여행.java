import java.util.*;

class Solution {
    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        for (int i=0;i<maps.length;i++) {
            map[i] = maps[i].split("");
        }
        
        visited = new boolean[map.length][map[0].length];
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[i].length;j++) {
                if (!visited[i][j] && !map[i][j].equals("X")) {
                    bfs(map, i, j);
                }
            }
        }
        
        if (list.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i=0;i<answer.length;i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void bfs(String[][] map, int i, int j) {
        int result = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        visited[i][j] = true;
        
        result += Integer.parseInt(map[i][j]);
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int d=0;d<4;d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                    continue;
                }
                if (!visited[nr][nc] && !map[nr][nc].equals("X")) {
                    queue.add(new Pair(nr, nc));
                    visited[nr][nc] = true;
                    result += Integer.parseInt(map[nr][nc]);
                }
            }
        }
        
        list.add(result);
    }
}

class Pair {
    int r, c;
    
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}