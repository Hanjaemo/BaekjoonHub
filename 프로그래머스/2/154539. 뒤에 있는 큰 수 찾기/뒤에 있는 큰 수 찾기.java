import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Number> list = new ArrayList<>();
        for (int i=0;i<numbers.length;i++) {
            list.add(new Number(numbers[i]));
        }
        
        Deque<Number> stack = new ArrayDeque<>();
        int[] result = new int[list.size()];
        
        for (int i=0;i<list.size();i++) {
            Number now = list.get(i);
            while (!stack.isEmpty()) {
                if (now.n > stack.peek().n) {
                    stack.pop().setP(now.n);
                } else {
                    break;
                }
            }
            stack.push(now);
        }
        
        while (!stack.isEmpty()) {
            stack.pop().setP(-1);
        }
                     
        for (int i=0;i<list.size();i++) {
            result[i] = list.get(i).p;
        }
        
        return result;
    }
}

class Number {
    int n,p;
    
    public Number(int n) {
        this.n = n;
    }
    
    public void setP(int p) {
        this.p = p;
    }
}