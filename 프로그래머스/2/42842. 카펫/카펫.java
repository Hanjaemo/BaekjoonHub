class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // for (w=1~brown)
            // h = (brown - w*2) / 2
            // if (yellow / w-2 == h) : 배열에 저장
        
        for (int w=3;w<=brown;w++) {
            int h = (brown - w*2) / 2;
            if (h + 2 > w) {
                continue;
            }
            if (yellow / (w-2) == h) {
                answer[0] = w;
                answer[1] = h + 2;
                break;
            }
        }
        
        return answer;
    }
}

