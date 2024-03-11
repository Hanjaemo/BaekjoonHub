class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int y=yellow;y>=1;y--) {
            if (yellow % y == 0) {
                int w = y;
                int h = yellow / y;
                if ((w + 2) * 2 > brown) {
                    continue;
                }
                if ((w + 2) * 2 + (h * 2) == brown) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}