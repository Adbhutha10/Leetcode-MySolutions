class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        boolean[] sorted = new boolean[n]; 
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean needDelete = false;
            for (int row = 1; row < n; row++) {
                if (!sorted[row] && 
                    strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }
            if (needDelete) {
                deletions++;
                continue;
            }
            for (int row = 1; row < n; row++) {
                if (!sorted[row] && 
                    strs[row - 1].charAt(col) < strs[row].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }
        return deletions;
    }
}
