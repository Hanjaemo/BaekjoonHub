class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        
        int n = sticker.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // 1번 스티커를 뜯는 경우
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i=2;i<n;i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
            
        // 2번 스티커를 뜯는 경우
        dp2[1] = sticker[1];
        for (int i=2;i<n;i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}