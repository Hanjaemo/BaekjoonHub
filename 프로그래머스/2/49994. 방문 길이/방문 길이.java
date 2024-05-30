import java.util.*;

class Solution {
    static Pairs[][] map = new Pairs[11][11];
    static int[] directions;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};
    static int answer = 0;
    
    public int solution(String dirs) {
        directions = new int[dirs.length()];
        for (int i=0;i<dirs.length();i++) {
            char c = dirs.charAt(i);
            if (c == 'U') {
                directions[i] = 0;
            } else if (c == 'D') {
                directions[i] = 1;
            } else if (c == 'R') {
                directions[i] = 2;
            } else {
                directions[i] = 3;
            }
        }
        
        for (int i=0;i<11;i++) {
            for (int j=0;j<11;j++) {
                map[i][j] = new Pairs();
            }
        }
        
        dfs(directions.length, new Pair(5, 5), 0);
        
        return answer;
    }
    
    public void dfs(int n, Pair now, int depth) {
        if (depth == n) {
            return;
        }
        
        int d = directions[depth];
        int nr = now.r + dRow[d];
        int nc = now.c + dCol[d];
        if (!(nr < 0 || nr >= 11 || nc < 0 || nc >= 11)) {
            Pair next = new Pair(nr, nc);
            if (visited(map[nr][nc], now)) {
                dfs(n, next, depth + 1);
            } else {
                answer++;
                map[nr][nc].add(now);
                map[now.r][now.c].add(next);
                dfs(n, next, depth + 1);
            }
        } else {
            dfs(n, now, depth + 1);
        }
    }
    
    public boolean visited(Pairs pairs, Pair now) {
        for (Pair p : pairs.set) {
            if (p.r == now.r && p.c == now.c) {
                return true;
            }
        }
        return false;
    }
}

class Pair {
    int r,c;
    
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Pairs {
    Set<Pair> set = new HashSet<>();
    
    public Pairs() {
    }

    public void add(Pair p) {
        set.add(p);
    }
}