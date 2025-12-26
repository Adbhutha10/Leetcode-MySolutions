class Solution {
    public int bestClosingTime(String customers) {
        int totalHours = customers.length();
        int[] prefixYCount = new int[totalHours + 1];
        for (int i = 0; i < totalHours; ++i) {
            prefixYCount[i + 1] = prefixYCount[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int bestClosingHour = 0;
        int minimumPenalty = Integer.MAX_VALUE;
        for (int closingHour = 0; closingHour <= totalHours; ++closingHour) {
            int penaltyForNBeforeClosing = closingHour - prefixYCount[closingHour];
            int penaltyForYAfterClosing = prefixYCount[totalHours] - prefixYCount[closingHour];
            int totalPenalty = penaltyForNBeforeClosing + penaltyForYAfterClosing;
            if (minimumPenalty > totalPenalty) {
                bestClosingHour = closingHour;
                minimumPenalty = totalPenalty;
            }
        }
        return bestClosingHour;
    }
}
