class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        
        int[] freq = new int[total + 1]; // 1..n^2
        
        // Count frequency of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }
        
        int a = -1, b = -1;
        for (int num = 1; num <= total; num++) {
            if (freq[num] == 2) {
                a = num; // repeating
            } else if (freq[num] == 0) {
                b = num; // missing
            }
        }
        
        return new int[]{a, b}; 
    }
}