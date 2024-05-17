import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int answer = 0;
        for (int i=2;i<=arrayA[0];i++) {
            if (divideUp(arrayA, i) && nonDivideUp(arrayB, i)) {
                answer = Math.max(answer, i);
            }
        }
        
        for (int i=2;i<=arrayB[0];i++) {
            if (divideUp(arrayB, i) && nonDivideUp(arrayA, i)) {
                answer = Math.max(answer, i);
            }
        }
        
        return answer;
    }
    
    public boolean divideUp(int[] arr, int n) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean nonDivideUp(int[] arr, int n) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] % n == 0) {
                return false;
            }
        }
        return true;
    }
}