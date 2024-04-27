import java.util.*;

class Solution {
    public long solution(int[] weights) {
        int[][] rates = {{1, 1}, {1, 2}, {2, 3}, {3, 4}};
        
        Arrays.sort(weights);
        
        long answer = 0;
        for (int i=0;i<weights.length;i++) {
            int weight = weights[i];
            for (int j=0;j<rates.length;j++) {
                if ((weight * rates[j][1]) % rates[j][0] != 0) {
                    continue;
                }
                int x = (weight * rates[j][1]) / rates[j][0];
                answer += upperBound(weights, i + 1, x) - lowerBound(weights, i + 1, x);
            }
        }
        
        return answer;
    }
    
    public int upperBound(int[] arr, int start, int target) {
        int s = start;
        int e = arr.length;
        while (s < e) {
            int m = (s + e) / 2;
            if (target < arr[m]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
    
    public int lowerBound(int[] arr, int start, int target) {
        int s = start;
        int e = arr.length;
        while (s < e) {
            int m = (s + e) / 2;
            if (target <= arr[m]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}