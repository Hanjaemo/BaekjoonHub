import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int x=0;x<=d;x+=k) {
            long xx = (long) Math.pow(x, 2);
            long dd = (long) Math.pow(d, 2);
            int maxY = (int) Math.sqrt(dd - xx);
            answer += maxY/k + 1;
        }
        
        return answer;
    }
}