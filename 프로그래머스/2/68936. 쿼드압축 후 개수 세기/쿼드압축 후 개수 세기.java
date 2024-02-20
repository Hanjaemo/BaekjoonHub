class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void compress(int[][] arr, int r, int c, int len) {
        if (len == 1) {
            answer[arr[r][c]]++;
            return;
        }

        if (canCompress(arr, r, c, len)) {
            answer[arr[r][c]]++;
            return;
        } else {
            int half = len / 2;
            compress(arr, r, c, half);
            compress(arr, r, c + half, half);
            compress(arr, r + half, c, half);
            compress(arr, r + half, c + half, half);
        }
    }
    
    private boolean canCompress(int[][] arr, int r, int c, int len) {
        boolean canCompress = true;
        int start = arr[r][c];
        for (int i=r;i<r+len;i++) {
            for (int j=c;j<c+len;j++) {
                if (start != arr[i][j]) {
                    canCompress = false;
                }
            }
        }
        return canCompress;
    }
}