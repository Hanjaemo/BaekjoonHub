import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                if (ch == ')') {
                    return false;
                } else {
                    stack.push(ch);
                }
            } else {
                if (stack.peek() == '(') {
                   if (ch == '(') {
                        stack.push(ch);
                    } else {
                        stack.pop();
                    }
                }
            }
            
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}