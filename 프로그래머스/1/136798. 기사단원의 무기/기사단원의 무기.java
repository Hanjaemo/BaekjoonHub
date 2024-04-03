import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] arr = new int[number+1];
        arr[1] = 1;
        for (int i=2;i<=number;i++) {
            int atk = count(i);
            if (atk > limit) {
                arr[i] = power;
            } else {
                arr[i] = atk;
            }
        }
        
        int answer = 0;
        for (int i=1;i<=number;i++) {
            answer += arr[i];
        }
        
        return answer;
    }
    
    public int count(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i=1;i<=n/2;i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        return set.size();
    }
}

// 1. 약수 구해서 배열에 저장
// 2. 배열 탐색하며 limit 초과 시 power로 수정
// 3. 배열의 모든 요소 합 반환