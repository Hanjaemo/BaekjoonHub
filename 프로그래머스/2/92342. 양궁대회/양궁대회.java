import java.util.*;

class Solution {
    static int max = 0;
    static List<int[]> wins = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        dfs(info, new int[info.length], n, 0, 0);
        if (wins.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(wins, (a, b) -> {
            for (int i=10;i>=0;i--) {
                if (a[i] != b[i]) {
                    return b[i] - a[i];
                }
            }
            return 0;
        });
        for (int[] win : wins) {
            System.out.println(Arrays.toString(win));
        }
        
        
        return wins.get(0);
    }
    
    public void dfs(int[] info, int[] lion, int n, int arrow, int start) {
        if (arrow == n) {
            int totalInfo = 0;
            int totalLion = 0;
            for (int i=0;i<lion.length;i++) {
                if (lion[i] == 0 && info[i] == 0) {
                    continue;
                }
                if (lion[i] > info[i]) {
                    totalLion += 10-i;
                } else {
                    totalInfo += 10-i;
                }
            }
            
            if (totalLion > totalInfo) {
                if (max < totalLion-totalInfo) {
                    max = totalLion-totalInfo;
                    wins.clear();
                    wins.add(Arrays.copyOf(lion, lion.length));
                }
                if (max == totalLion-totalInfo) {
                    wins.add(Arrays.copyOf(lion, lion.length));
                }
            }
            
            return;
        }
        
        for (int i=start;i<info.length;i++) {
            if (lion[i] > info[i]) {
                continue;
            }
            lion[i]++;
            dfs(info, lion,n,  arrow+1, i);
            lion[i]--;
        }
    }
    
    // public boolean isSmallThan(int[] lion) {
    //     if (answer == null) {
    //         return true;
    //     }
    //     for (int i=10;i>=0;i--) {
    //         if (answer[i] > lion[i]) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}