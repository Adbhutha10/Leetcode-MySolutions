class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int mid = (l + r) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && nums[i] > 2L * nums[j]) j++;
            count += j - (mid + 1);
        }

        Arrays.sort(nums, l, r + 1);   // instead of writing full merge
        return count;
    }
}