import java.time.*;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Homework> homeworks = new ArrayList<>();
        for (int i=0;i<plans.length;i++) {
            String name = plans[i][0];
            String[] splitTime = plans[i][1].split(":");
            int start = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            int playtime = Integer.parseInt(plans[i][2]);
            homeworks.add(new Homework(name, start, playtime));
        }
        
        Collections.sort(homeworks);
        
        // for (Homework h : homeworks) {
        //     System.out.println(h.name + "," + h.start + "," + h.playtime);
        // }
        
        Deque<Homework> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        
        for (int i=0;i<homeworks.size()-1;i++) {
            Homework now = homeworks.get(i);
            Homework next = homeworks.get(i+1);
            int end = now.start + now.playtime;
            if (end > next.start) {
                stack.push(now);
                now.playtime = end - next.start;
            } else {
                result.add(now.name);
                int remain = next.start - end;
                while (!stack.isEmpty() && remain > 0) {
                    Homework last = stack.peek();
                    int pt = last.playtime;
                    last.playtime -= remain;
                    remain -= pt;
                    
                    if (last.playtime <= 0) {
                        result.add(stack.pop().name);
                    }
                }
            }
        }
        
        result.add(homeworks.get(homeworks.size()-1).name);
        
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        String[] answer = new String[result.size()];
        for (int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}

class Homework implements Comparable<Homework> {
    String name;
    int start;
    int playtime;
    
    public Homework(String n, int s, int p) {
        name = n;
        start = s;
        playtime = p;
    }
    
    @Override
    public int compareTo(Homework o) {
        return this.start - o.start;
    }
}