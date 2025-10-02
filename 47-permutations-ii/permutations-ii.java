import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // sort to make duplicate skipping easy
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, ans);
        return ans;
    }
    
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip used numbers
            if (used[i]) continue;
            
            // Skip duplicates: only use the first unused number of the duplicate group
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            
            current.add(nums[i]);
            used[i] = true;
            
            backtrack(nums, current, used, ans);
            
            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    
    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,1,2};
        System.out.println(sol.permuteUnique(nums));
    }
}
