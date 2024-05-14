import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int[] arr = new int[cards.length+1];
        for (int i=0;i<cards.length;i++) {
            arr[i+1] = cards[i];
        }
        
        for (int i=1;i<arr.length;i++) {
            arr[i] = find(arr, i, new boolean[arr.length]);
        }
        
        List<Integer> groups = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        for (int i=1;i<arr.length;i++) {
            if (visited[i]) {
                continue;
            }
            int num = arr[i];
            int cnt = 0;
            for (int j=1;j<arr.length;j++) {
                if (num == arr[j]) {
                    cnt++;
                    visited[j] = true;
                }
            }
            groups.add(cnt);
        }
        
        Collections.sort(groups, Collections.reverseOrder());
        if (groups.size() < 2) {
            return 0;
        } else {
            return groups.get(0) * groups.get(1);
        }
    }
    
    public int find(int[] arr, int n, boolean[] visited) {
        if (n == arr[n] || visited[n]) {
            return n;
        }
        visited[n] = true;
        return arr[n] = find(arr, arr[n], visited);
    }
}