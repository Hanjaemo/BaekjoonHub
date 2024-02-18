class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers[0], 0, numbers, target);
        dfs(-numbers[0], 0, numbers, target);
        
        return count;
    }
    
    public void dfs(int num, int depth, int[] numbers, int target) {
        if (depth == numbers.length-1) {
            if (num == target) {
                count++;
            }
            return;
        }
        
        dfs(num + numbers[depth+1], depth+1, numbers, target);
        dfs(num - numbers[depth+1], depth+1, numbers, target);
    }
}