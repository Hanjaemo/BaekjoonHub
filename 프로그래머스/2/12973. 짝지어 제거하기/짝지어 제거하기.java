import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++) {
            char now = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(now);
                continue;
            }
            if (now == stack.peek()) {
                stack.pop();
            } else {
                stack.push(now);
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}