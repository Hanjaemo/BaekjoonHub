import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        List<String> dict = new ArrayList<>();
        for (int i=0;i<arr.length;i++) {
            dfs(dict, arr[i]);
        }
        
        for (int i=0;i<dict.size();i++) {
            if (dict.get(i).equals(word)) {
                return i + 1;
            }
        }
        
        return 0;
    }
    
    public void dfs(List<String> dict, String str) {
        if (str.length() > 5) {
            return;
        }
        
        if (!dict.contains(str)) {
            dict.add(str);
        }
        
        for (int i=0;i<arr.length;i++) {
            dfs(dict, str+arr[i]);
        }
    }
}