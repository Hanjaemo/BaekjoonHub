class Solution {
    // 1. 처음 명함 크기로 맞춤
    // 2. 가로, 세로 중 더 큰 값을 더 큰 쪽에 대입
    public int solution(int[][] sizes) {
        int w = sizes[0][0];
        int h = sizes[0][1];
        for (int i=0;i<sizes.length;i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            if (w > h) {
                if (w < max) {
                    w = max;
                }
                if (h < min) {
                    h = min;
                }
            } else {
                if (h < max) {
                    h = max;
                }
                if (w < min) {
                    w = min;
                }
            }
        }
        return w * h;
    }
}