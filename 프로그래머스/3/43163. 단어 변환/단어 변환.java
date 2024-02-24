import java.util.*;

class Solution {
    static int[] arr;
        
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        arr = new int[words.length];
        
        bfs(begin, target, words);
        
        int max = 0;
        for (int i=0;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
        }
        
        return max;
    }
    
    public void bfs(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        while (!queue.isEmpty()) {
            String now = queue.poll();
            if (now.equals(target)) {
                return;
            }
            for (int i=0;i<words.length;i++) {
                if (arr[i] > 0) {
                    continue;
                }
                
                String next = words[i];
                
                int sameCount = 0;
                for (int j=0;j<next.length();j++) {
                    if (now.charAt(j) == next.charAt(j)) {
                        sameCount++;
                    }
                }
                
                if (sameCount == now.length()-1) {
                    queue.add(next);
                    if (Arrays.asList(words).contains(now)) {
                        arr[i] = arr[Arrays.asList(words).indexOf(now)] + 1;
                    } else {
                        arr[i] = 1;
                    }
                }
            }
        }
    }
}