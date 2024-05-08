import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<scoville.length;i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        while (pq.peek() < K) {
            int a = pq.poll();
            if (pq.isEmpty()) {
                return -1;
            }
            int b = pq.poll();
            pq.offer(a + b*2);
            answer++;
        }
        
        return answer;
    }
}