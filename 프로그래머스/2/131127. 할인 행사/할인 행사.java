import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i=0;i<=discount.length-10;i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j=0;j<want.length;j++) {
                map.put(want[j], number[j]);
            }
            
            String[] discountCopy = Arrays.copyOf(discount, discount.length);
            for (int j=i;j<i+10;j++) {
                if (map.containsKey(discountCopy[j])) {
                    map.put(discountCopy[j], map.get(discountCopy[j]) - 1);
                }
                
            }
            
            boolean isRight = true;
            for (String key : map.keySet()) {
                if (map.get(key) != 0) {
                    isRight = false;
                }
            }
            
            if (isRight) {
                answer++;
            }
        }
        
        return answer;
    }
}