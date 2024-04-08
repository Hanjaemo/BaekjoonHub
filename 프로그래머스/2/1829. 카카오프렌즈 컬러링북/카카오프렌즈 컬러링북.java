import java.util.*;

class Solution {
    static int row, col;
    static boolean[][] visited;
    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};
    static int count = 0;
    static int maxArea = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        row = m;
        col = n;
        
        int[] answer = new int[2];
        visited = new boolean[row][col];
        
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(i, j, picture, answer);
                    answer[0]++;
                }
            }
        }

        return answer;
    }
    
    public void bfs(int r, int c, int[][] picture, int[] arr) {
        int number = picture[r][c];
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));
        visited[r][c] = true;
        
        int area = 1;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int d=0;d<4;d++) {
                int nr = now.r + dRow[d];
                int nc = now.c + dCol[d];
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                    continue;
                }
                if (picture[nr][nc] == number && !visited[nr][nc]) {
                    queue.add(new Pair(nr, nc));
                    visited[nr][nc] = true;
                    area++;
                }
            }
        }
        
        arr[1] = Math.max(arr[1], area);
    }
}

class Pair {
    int r, c;
    
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}