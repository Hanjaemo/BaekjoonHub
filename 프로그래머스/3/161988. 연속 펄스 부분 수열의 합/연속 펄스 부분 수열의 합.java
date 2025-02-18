class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[][] dp = new long[2][n];
        dp[0][0] = sequence[0];
        dp[1][0] = -sequence[0];
        
        for (int i=1;i<n;i++) {
            dp[0][i] = Math.max(dp[1][i-1], 0) + sequence[i];
            dp[1][i] = Math.max(dp[0][i-1], 0) - sequence[i];
        }
        
        long answer = 0;
        for (int i=0;i<n;i++) {
            answer = Math.max(answer, dp[0][i]);
            answer = Math.max(answer, dp[1][i]);
        }
        return answer;
    }
}