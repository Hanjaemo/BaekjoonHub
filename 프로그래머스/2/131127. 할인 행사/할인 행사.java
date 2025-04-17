import java.util.*;

class Solution {
    private static final int MEMBER_AUTH_DAY = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        Integer[] boxedNumber = Arrays.stream(number).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNumber, Collections.reverseOrder());
        int maxNumber = boxedNumber[0];
        
        int answer = 0;
        for (int i=0;i<=discount.length-MEMBER_AUTH_DAY;i++) { // 0~4
            int start = i;
            int end = i+MEMBER_AUTH_DAY-1;
            int cnt = 0;
            int[] count = new int[number.length];
            for (int j=start;j<=end;j++) { // 0~9
                for (int k=0;k<want.length;k++) {
                    if (want[k].equals(discount[j])) {
                        count[k]++;
                        break;
                    }
                }
            }
            boolean isSatisfied = true;
            for (int j=0;j<number.length;j++) {
                if (number[j] > count[j]) {
                    isSatisfied = false;
                    break;
                }
            }
            if (isSatisfied) {
                answer++;
            }
        }

        return answer;
    }
}