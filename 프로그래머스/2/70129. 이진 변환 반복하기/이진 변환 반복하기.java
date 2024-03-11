import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[2];
        
        while (!s.equals("1")) {
            int len = 0;
            for (int i=0;i<s.length();i++) {
                if (s.charAt(i) == '0') {
                    result[1]++;
                } else {
                    len++;
                }
            }
            
            Deque<Integer> stack = new ArrayDeque<>();
            while (len > 0) {
                stack.push(len % 2);
                len /= 2;
            }            
            
            
            
            // int num = 0;
            s = "";
            while (!stack.isEmpty()) {
                s += stack.pop() + "";
                // num = num * 10 + stack.pop();
            }
            
            result[0]++;
            
            // s = num + "";
        }
        
        return result;
    }
}