import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            if (a[col-1] - b[col-1] == 0) {
                return b[0] - a[0];
            }
            return a[col-1] - b[col-1];
        });
        
        // for (int[] arr : data) {
        //     System.out.println(Arrays.toString(arr));
        // }
        
        int answer = 0;
        for (int i=row_begin;i<=row_end;i++) {
            int s_i = 0;
            int[] arr = data[i-1];
            for (int j=0;j<arr.length;j++) {
                s_i += arr[j] % i;
            }
            // System.out.println(s_i);
            if (i == row_begin) {
                answer = s_i;
            } else {
                answer = s_i ^ answer;
            }
            
        }
        
        return answer;
    }
}