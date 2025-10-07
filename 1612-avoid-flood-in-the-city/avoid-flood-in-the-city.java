import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>(); // lake -> last rain day
        TreeSet<Integer> dryDays = new TreeSet<>();   // indices of zero days

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                ans[i] = -1; // raining day
                
                if (full.containsKey(lake)) {
                    // Find a dry day after the last rain of this lake
                    Integer dryDay = dryDays.higher(full.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // flood unavoidable
                    }
                    ans[dryDay] = lake;  // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                
                full.put(lake, i); // mark lake as full
            } else {
                dryDays.add(i);   // store this day for potential drying
                ans[i] = 1;       // default, might change later
            }
        }
        return ans;
    }
}
