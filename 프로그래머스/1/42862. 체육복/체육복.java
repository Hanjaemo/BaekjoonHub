import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] visitLost = new boolean[lost.length];
        boolean[] visitReserve = new boolean[reserve.length];
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i=0;i<reserve.length;i++) {
            for (int j=0;j<lost.length;j++) {
                if (reserve[i] == lost[j]) {
                    visitReserve[i] = true;
                    visitLost[j] = true;
                    break;
                }
            }
        }
        
        for (int i=0;i<reserve.length;i++) {
            if (visitReserve[i]) {
                continue;
            }
            int r = reserve[i];
            for (int j=0;j<lost.length;j++) {
                int l = lost[j];
                if ((r+1 == l || r-1 == l) && !visitLost[j]) {
                    visitLost[j] = true;
                    break;
                }
            }
        }
        
        int lostCount = 0;
        for (int i=0;i<lost.length;i++) {
            if (!visitLost[i]) {
                lostCount++;
            }
        }
        
        return n - lostCount;
    }
}