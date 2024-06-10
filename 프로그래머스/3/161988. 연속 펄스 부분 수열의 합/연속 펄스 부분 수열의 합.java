import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        int size = sequence.length;
        
        // 펄스 수열 생성
        int[] p1 = makePulse(1, size);
        int[] p2 = makePulse(-1, size);
        
        // 펄스 곱
        int[] prod1 = pulseProduct(p1, sequence);
        int[] prod2 = pulseProduct(p2, sequence);
        
        // 누적합
        long[] sumProd1 = makeSumArr(prod1);
        long[] sumProd2 = makeSumArr(prod2);
        
        // 부분합
        long[] partSumProd1 = makePartSumArr(sumProd1);
        long[] partSumProd2 = makePartSumArr(sumProd2);
        
        // 최댓값
        long answer = -100000;
        for (long i : partSumProd1) {
            answer = Math.max(answer, i);
        }
        
        for (long i : partSumProd2) {
            answer = Math.max(answer, i);
        }
        
        return answer;
    }
    
    public int[] makePulse(int startSign, int size) {
        int[] pulseArr = new int[size];
        for (int i=0;i<size;i++) {
            pulseArr[i] = startSign;
            startSign *= -1;
        }
        return pulseArr;
    }
    
    public int[] pulseProduct(int[] arr, int[] pulseArr) {
        int[] productArr = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            productArr[i] = arr[i] * pulseArr[i];
        }
        return productArr;
    }
    
    public long[] makeSumArr(int[] arr) {
        long[] sumArr = new long[arr.length];
        sumArr[0] = arr[0];
        for (int i=1;i<arr.length;i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }
        return sumArr;
    }
    
    public long[] makePartSumArr(long[] sumProdArr) {
        long[] dp = new long[sumProdArr.length];
        dp[0] = sumProdArr[0];
        long min = Math.min(0, dp[0]);
        for (int i=1;i<sumProdArr.length;i++) {
            dp[i] = Math.max(sumProdArr[i] - min, sumProdArr[i]);
            min = Math.min(min, sumProdArr[i]);
        }
        return dp;
    }
}