class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int idx = -1;
            for (int j = i; j < n; j++) {
                if (pos[j] <= i) {
                    swaps += j - i;
                    idx = j;
                    break;
                }
            }
            if (idx == -1) return -1;
            for (int j = idx; j > i; j--) {
                int temp = pos[j];
                pos[j] = pos[j - 1];
                pos[j - 1] = temp;
            }
        }
        return swaps;
    }
}