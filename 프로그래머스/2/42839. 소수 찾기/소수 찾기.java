import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        return set.size();
    }
    
    public void dfs(String numbers, String s, int depth) {
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i=0;i<numbers.length();i++) {
            if (!visited[i]) {
                visited[i] = true;
                int num = Integer.parseInt(s + numbers.charAt(i));
                if (isPrime(num)) {
                    set.add(num);
                }
                dfs(numbers, s + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i=2;i<num;i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}