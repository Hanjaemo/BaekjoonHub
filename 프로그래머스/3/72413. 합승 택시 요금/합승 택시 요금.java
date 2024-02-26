class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] distance= new int[n+1][n+1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i == j) {
                    continue;
                }
                distance[i][j] = 20000001; // 200 * 100000 + 1
            }
        }
        for (int k=0;k<fares.length;k++) {
            distance[fares[k][0]][fares[k][1]] = fares[k][2];
            distance[fares[k][1]][fares[k][0]] = fares[k][2];
        }
        
        fw(n, distance);
        
        // 도착지를 제외한 경유지에서 도착지로 향하는 최소 요금 구하기
        int min = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++) {
            min = Math.min(distance[s][i] + distance[i][a] + distance[i][b], min);
        }
        
        return min;
    }
    
    public void fw(int n, int[][] distance) {        
        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
}