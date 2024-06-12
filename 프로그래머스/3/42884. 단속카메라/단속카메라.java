import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] a, int[] b) -> b[0] - a[0]);
        
        int answer = 0;
        int last = routes[0][0];
        answer++;
        for (int i=1;i<routes.length;i++) {
            if (routes[i][0] <= last && last <= routes[i][1]) {
                continue;
            }
            last = routes[i][0];
            answer++;
        }   
        
        return answer;
    }
}