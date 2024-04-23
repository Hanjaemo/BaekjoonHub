import java.util.*;

class Solution {
    static String[][] map;
    static int[][] distMap;
    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};
    
    public int solution(String[] board) {
        map = new String[board.length][board[0].length()];
        distMap = new int[board.length][board[0].length()];
        
        for (int i=0;i<board.length;i++) {
            String[] split = board[i].split("");
            for (int j=0;j<split.length;j++) {
                map[i][j] = split[j];
            }
        }
        
        int answer = 0;
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[i].length;j++) {
                if (map[i][j].equals("R")) {
                    answer = bfs(i,j);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public int bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (map[now.r][now.c].equals("G")) {
                return distMap[now.r][now.c];
            }
            for (int d=0;d<4;d++) {
                int nr = now.r;
                int nc = now.c;
                while (true) {
                    if (isOut(nr, nc) || map[nr][nc].equals("D")) {
                        nr -= dRow[d];
                        nc -= dCol[d];
                        break;
                    }
                    
                    nr += dRow[d];
                    nc += dCol[d];
                }
                
                if (distMap[nr][nc] == 0 && !map[nr][nc].equals("R")) {
                    distMap[nr][nc] = distMap[now.r][now.c] + 1;
                    queue.add(new Pair(nr, nc));
                }
            }
            
        //     for (int[] a : distMap) {
        //     for (int b : a) {
        //         System.out.print(b + " ");
        //     }
        //     System.out.println();
        // }
        //     System.out.println("=====");
        }
        
        return -1;
    }
    
    public boolean isOut(int nr, int nc) {
        return nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length;
    }
}

class Pair {
    int r, c;
    
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}