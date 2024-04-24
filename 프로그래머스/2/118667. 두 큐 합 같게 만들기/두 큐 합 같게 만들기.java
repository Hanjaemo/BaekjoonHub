import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        for (int i=0;i<queue1.length;i++) {
            q1.add((long) queue1[i]);
        }
        Queue<Long> q2 = new LinkedList<>();
        for (int i=0;i<queue2.length;i++) {
            q2.add((long) queue2[i]);
        }
        
        long total = sum(queue1) + sum(queue2);
        if (total % 2 != 0) {
            return -1;
        }
        
        int answer = 0;
        long sum1 = sum(queue1);
        long sum2 = sum(queue2);
        while (sum1 != sum2) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            if (sum1 > total / 2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                answer++;
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                answer++;
            }
        }
        
        return answer;
    }
    
    public long sum(int[] queue) {
        long sum = 0;
        for (int i=0;i<queue.length;i++) {
            sum+=queue[i];
        }
        return sum;
    }
}