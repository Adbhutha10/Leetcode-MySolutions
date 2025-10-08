import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            long required = (success + spells[i] - 1) / spells[i]; // ceiling division
            int index = binarySearch(potions, required);
            ans[i] = m - index; // all potions from index to end are successful
        }
        return ans;
    }

    // Find first index where potion >= required
    private int binarySearch(int[] potions, long required) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < required)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
