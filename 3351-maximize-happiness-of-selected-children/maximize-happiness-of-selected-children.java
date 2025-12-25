class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long totalHappiness = 0;
        int n = happiness.length;
        for (int i = 0; i < k; i++) {
            int adjustedHappiness = happiness[n - i - 1] - i;
            totalHappiness += Math.max(adjustedHappiness, 0);
        }
        return totalHappiness;
    }
}