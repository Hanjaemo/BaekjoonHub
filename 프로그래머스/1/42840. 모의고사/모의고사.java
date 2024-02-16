import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int probCount = answers.length;
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[3];
        for (int i=0;i<probCount;i++) {
            if (a[i%a.length] == answers[i]) {
                cnt[0]++;
            }
            if (b[i%b.length] == answers[i]) {
                cnt[1]++;
            }
            if (c[i%c.length] == answers[i]) {
                cnt[2]++;
            }
        }
        
        int max = 0;
        for (int i=0;i<3;i++) {
            max = Math.max(max, cnt[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<3;i++) {
            if (max == cnt[i]) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}