import java.util.*;

class Solution {
    static Map<String, String> referrals = new HashMap<>();
    static Map<String, Integer> benefits = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 추천인 map 초기화
        for (int i=0;i<enroll.length;i++) {
            if (referral[i].equals("-")) {
                referrals.put(enroll[i], "-");
                continue;
            }
            referrals.put(enroll[i], referral[i]);
        }
        
        // 이익 map 초기화
        for (int i=0;i<enroll.length;i++) {
            benefits.put(enroll[i], 0);
        }
        
        // 순환하면서 이익 map 채우기
        for (int i=0;i<seller.length;i++) {
            int cost = amount[i] * 100;
            if (cost / 10 > 0) {
                benefits.put(seller[i], benefits.get(seller[i]) + cost - cost / 10);
                dfs(referrals.get(seller[i]), cost / 10);
            } else {
                benefits.put(seller[i], benefits.get(seller[i]) + cost - cost / 10);
            }
            
        }
        
        int[] answer = new int[enroll.length];
        for (int i=0;i<enroll.length;i++) {
            answer[i] = benefits.get(enroll[i]);
        }
        
        return answer;
    }
    
    public void dfs(String referral, int amount) {
        if (referral.equals("-")) {
            return;
        }
        
        if (amount / 10 > 0) {
            benefits.put(referral, benefits.get(referral) + amount - amount / 10);
            dfs(referrals.get(referral), amount / 10);
        } else {
            benefits.put(referral, benefits.get(referral) + amount - amount / 10);
        }
    }
}