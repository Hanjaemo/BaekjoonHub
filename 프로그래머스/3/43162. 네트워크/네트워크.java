import java.util.*;

class Solution {
    static int[] arr;
    
    public int solution(int n, int[][] computers) {
        arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = i;
        }
        
        for (int i=0;i<computers.length;i++) {
            for (int j=0;j<computers[i].length;j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
                
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++) {
            set.add(find(arr[i]));
        }
        
        return set.size();
    }
    
    public int find(int node) {
        if (node == arr[node]) {
            return node;
        }
        return arr[node] = find(arr[node]);
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) {
            return;
        }
        
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}