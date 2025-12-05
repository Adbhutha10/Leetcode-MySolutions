public class Solution {

        public void nextPermutation(int[] nums) {

            if (nums == null || nums.length == 0) {
                return;
            }
            for (int i = nums.length - 2; i >= 0; --i) { 
                if (nums[i] < nums[i + 1]) { 
                    for (int j = nums.length - 1; j > i; --j) {
                        if (nums[j] > nums[i]) {
                            swap(nums, i, j);
                            reverse(nums, i + 1, nums.length - 1);
                            return;
                        }
                    }

                }
            }

            reverse(nums, 0, nums.length - 1); // for没有return，就整个翻转
        }

        private void swap(int[] nums, int i, int j) {

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

        }

        private void reverse(int[] nums, int i, int j) {

            while (i < j) {

                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
                j--;
            }
        }
    }