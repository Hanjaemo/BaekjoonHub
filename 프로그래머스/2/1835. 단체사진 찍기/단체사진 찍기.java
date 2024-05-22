import java.util.*;

class Solution {
    
    public int solution(int n, String[] data) {
        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        int[] answer = new int[1];
        bt(data, friends, answer, new StringBuilder(), new boolean[friends.length], 0);
        return answer[0];
    }
    
    public void bt(String[] data, String[] friends, int[] answer, StringBuilder line, boolean[] visited, int depth) {
        if (depth == friends.length) {
            // 판단 후 카운팅
            if (correct(data, line.toString())) {
                answer[0]++;
            }
            return;
        }
        
        for (int i=0;i<friends.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                line.append(friends[i]);
                bt(data, friends, answer, line, visited, depth+1);
                visited[i] = false;
                if (line.length() < 2) {
                    line.replace(0, line.length(), "");
                } else {
                    line.replace(line.length() - 1, line.length(), "");
                }
            }
        }
    }
    
    public boolean correct(String[] data, String line) {
        for (int i=0;i<data.length;i++) {
            String d = data[i];
            int a = line.indexOf(d.charAt(0));
            int b = line.indexOf(d.charAt(2));
            char sign = d.charAt(3);
            int gap = d.charAt(4)-'0';
        
            int realGap = Math.abs(a - b) - 1;
            
            if (sign == '=') {
                if (realGap != gap) {
                    return false;
                }
            } else if (sign == '>') {
                if (realGap <= gap) {
                    return false;
                }
            } else {
                if (realGap >= gap) {
                    return false;
                }
            }
        }
        
        return true;
    }
}