import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int x=0;x<=d;x++) {
            long xx = (long) Math.pow(x, 2);
            long dd = (long) Math.pow(d, 2) / (long) Math.pow(k, 2);
            if (dd-xx < 0) {
                continue;
            }
            int maxY = (int) Math.sqrt(dd - xx);
            answer += maxY + 1;
        }
        
        return answer;
    }
}