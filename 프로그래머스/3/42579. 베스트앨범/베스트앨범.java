import java.util.*;

// 가장 많이 재생 2개
// 1. value 큰 순대로 저장
// 2. 장르 내 value 큰 순대로 저장
// 3. 동일할 시 고유번호 오름차순
// genres {
//      identifier {
//          val
//      }
// }
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        int n = plays.length;
        for (int i=0;i<n;i++) {
            if (map.containsKey(genres[i])) {
                Map<Integer, Integer> genre = map.get(genres[i]);
                genre.put(i, plays[i]);
            } else {
                Map<Integer, Integer> genre = new HashMap<>();
                genre.put(i, plays[i]);
                map.put(genres[i], genre);
            }
        }
        
        // 장르별 내림차순 정렬
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> {
            return getSum(map.get(b)) - getSum(map.get(a));
        });
        
        // 정답
        List<Integer> list = new ArrayList<>();
        for (String key : keys) {
            Map<Integer, Integer> genre = map.get(key);
            List<Integer> ids = new ArrayList<>(genre.keySet());
            Collections.sort(ids, (a, b) -> {
                if (genre.get(a) == genre.get(b)) {
                    return a - b;
                }
                return genre.get(b) - genre.get(a);
            });
            
            if (ids.size() == 1) {
                list.add(ids.get(0));
                continue;
            }
            for (int i=0;i<2;i++) {
                int id = ids.get(i);
                list.add(id);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int getSum(Map<Integer, Integer> genre) {
        int sum = 0;
        for (int v : genre.values()) {
            sum += v;
        }
        return sum;
    }
}