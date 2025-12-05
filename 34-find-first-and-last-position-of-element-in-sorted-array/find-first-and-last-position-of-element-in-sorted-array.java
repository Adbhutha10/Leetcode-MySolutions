class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, target);
        int r = lowerBound(nums, target + 1);

        if (l == r) return new int[]{-1, -1};  
        return new int[]{l, r - 1};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
