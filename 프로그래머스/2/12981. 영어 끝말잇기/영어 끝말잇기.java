import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
//         Queue<Info> queue = new LinkedList<>();
//         for (int i=0;i<words;.length;i++) {
//             queue.offer(new Info(i%n, words[i], i/n+1));
//         }
        
        List<String> used = new ArrayList<>();
//         while (!queue.isEmpty()) {
//             Info now = queue.poll();
//             // if (now)
//         }
        
        used.add(words[0]);
        for (int i=1;i<words.length;i++) {
            String word = words[i];
            String prev = used.get(i-1);
            if (used.contains(word) || prev.charAt(prev.length()-1) != word.charAt(0)) {
                return new int[]{i%n+1, i/n+1};
            }
            used.add(word);
        }
        return new int[]{0,0};
    }
}

class Info {
    int num;
    String word;
    int cycle;
    
    public Info(int n, String w, int c) {
        num = n;
        word = w;
        cycle = c;
    }
}