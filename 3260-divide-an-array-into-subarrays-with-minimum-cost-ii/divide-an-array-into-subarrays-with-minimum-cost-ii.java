class Solution {
    private final TreeMap<Integer, Integer> left = new TreeMap<>();
    private final TreeMap<Integer, Integer> right = new TreeMap<>();
    private long sum;
    private int leftSize;
    public long minimumCost(int[] nums, int k, int dist) {
        --k;
        sum = nums[0];
        for (int i = 1; i < dist + 2; ++i) {
            sum += nums[i];
            left.merge(nums[i], 1, Integer::sum);
        }
        leftSize = dist + 1;
        while (leftSize > k) {
            moveLeftToRight();
        }
        long ans = sum;
        for (int i = dist + 2; i < nums.length; ++i) {
            int rem = nums[i - dist - 1];
            if (left.containsKey(rem)) {
                if (left.merge(rem, -1, Integer::sum) == 0) {
                    left.remove(rem);
                }
                sum -= rem;
                --leftSize;
            } else {
                if (right.merge(rem, -1, Integer::sum) == 0) {
                    right.remove(rem);
                }
            }
            int add = nums[i];
            if (add < left.lastKey()) {
                left.merge(add, 1, Integer::sum);
                ++leftSize;
                sum += add;
            } else {
                right.merge(add, 1, Integer::sum);
            }
            while (leftSize < k) {
                moveRightToLeft();
            }
            while (leftSize > k) {
                moveLeftToRight();
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
    private void moveLeftToRight() {
        int x = left.lastKey();
        sum -= x;
        if (left.merge(x, -1, Integer::sum) == 0) {
            left.remove(x);
        }
        --leftSize;
        right.merge(x, 1, Integer::sum);
    }
    private void moveRightToLeft() {
        int x = right.firstKey();
        if (right.merge(x, -1, Integer::sum) == 0) {
            right.remove(x);
        }
        left.merge(x, 1, Integer::sum);
        sum += x;
        ++leftSize;
    }
}
