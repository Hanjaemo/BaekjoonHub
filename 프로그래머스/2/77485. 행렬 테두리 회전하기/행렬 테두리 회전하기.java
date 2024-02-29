class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] matrix = new int[rows+1][columns+1];
        for (int i=0;i<rows;i++) {
            for (int j=1;j<=columns;j++) {
                matrix[i+1][j] = i * columns + j;
            }
        }
        
        // 회전
        for (int rot=0;rot<queries.length;rot++) {
            int r1 = queries[rot][0];
            int c1 = queries[rot][1];
            int r2 = queries[rot][2];
            int c2 = queries[rot][3];
            answer[rot] = rotation(r1,c1,r2,c2,matrix);
        }
        
        return answer;
    }
    
    public int rotation(int r1, int c1, int r2, int c2, int[][] matrix) {
        int tmp = matrix[r1][c1];
        int min = tmp;
        for (int i=r1;i<r2;i++) {
            matrix[i][c1] = matrix[i+1][c1];
            min = Math.min(min, matrix[i][c1]);
        }
        for (int i=c1;i<c2;i++) {
            matrix[r2][i] = matrix[r2][i+1];
            min = Math.min(min, matrix[r2][i]);
        }
        for (int i=r2;i>r1;i--) {
            matrix[i][c2] = matrix[i-1][c2];
            min = Math.min(min, matrix[i][c2]);
        }
        for (int i=c2;i>c1;i--) {
            matrix[r1][i] = matrix[r1][i-1];
            min = Math.min(min, matrix[r1][i]);
        }
        matrix[r1][c1+1] = tmp;
        
        return min;
    }
}