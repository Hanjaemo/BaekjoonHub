import java.util.*;

class Solution {
    static int[][] map = new int[102][102];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i=0;i<rectangle.length;i++) {
            initMap(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }
        
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return map[itemY*2][itemX*2]/2;
    }
    
    // 1. 사각형 칠하기
            // 테두리는 1, 내부는 2
            // 이미 2로 채워진 칸은 그대로
    public void initMap(int sx, int sy, int ex, int ey) {
        for (int i=sx;i<=ex;i++) {
            if (map[sy][i] != 2) {
                map[sy][i] = 1;
            }
            if (map[ey][i] != 2) {
                map[ey][i] = 1;
            }
        }
        for (int i=sy;i<=ey;i++) {
            if (map[i][sx] != 2) {
                map[i][sx] = 1;
            }
            if (map[i][ex] != 2) {
                map[i][ex] = 1;
            }
        }
        for (int i=sx+1;i<=ex-1;i++) {
            for (int j=sy+1;j<=ey-1;j++) {
                map[j][i] = 2;
            }
        }
    }
    
    // 2. bfs 최단거리
    public void bfs(int charX, int charY, int itemX, int itemY) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        queue.add(new Pair(charX, charY));
        visited[charY][charX] = true;
        map[charY][charX] = 0;
        
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (now.x == itemX && now.y == itemY) {
                return;
            }
            for (int d=0;d<4;d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx <= 0 || nx > 100 || ny <= 0 || ny > 100) {
                    continue;
                }
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    map[ny][nx] = map[now.y][now.x] + 1;
                    queue.add(new Pair(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }
    }
}

class Pair {
    int x, y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}