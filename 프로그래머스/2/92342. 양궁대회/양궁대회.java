import java.util.*;

class Solution {
    static int[] lion;
    static int max = -1;
    static List<int[]> list = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        lion = new int[info.length];
        backtracking(info, 0, 0, n);
        
        if (list.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(list, (o1, o2) -> {
            for (int i=10;i>=0;i--) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        });
        
        return list.get(0);
    }
    
    public void backtracking(int[] info, int depth, int start, int n) {
        if (depth == n) {
            int totalPeach = 0;
            int totalLion = 0;
            for (int i=0;i<=10;i++) {
                if (lion[i] == 0 && info[i] == 0) {
                    continue;
                }
                int score = 10-i;
                if (lion[i] > info[i]) {
                    totalLion += score;
                } else {
                    totalPeach += score;
                }
            }
            
            if (totalLion > totalPeach) {
                int scoreDiff = totalLion - totalPeach;
                if (max < scoreDiff) {
                    max = scoreDiff;
                    list.clear();
                    list.add(lion.clone());
                } else if (max == scoreDiff) {
                    list.add(lion.clone());
                }
            }
            
            return;
        }
        
        for (int i=start;i<info.length;i++) {
            if (lion[i] > info[i]) {
                continue;
            }
            lion[i]++;
            backtracking(info, depth+1, i, n);
            lion[i]--;
        }
        
    }
}