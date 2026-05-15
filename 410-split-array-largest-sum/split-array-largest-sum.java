class Solution {
    public static boolean canSplit(int[] arr, int k, int ms) {
        int cs=0, sa=1;
        for(int n:arr) {
            if(cs+n>ms) {
                sa++;
                cs=n;
                if(sa>k)
                    return false;
            }
            else
                cs+=n;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int l=0, h=0;
        for(int n: nums) {
            l=Math.max(l, n);
            h+=n;
        }
        int ans=h;
        while(l <= h) {
            int mid=l+(h-l)/2;
            if(canSplit(nums, k, mid)) {
                ans=mid;
                h=mid-1;
            } else
                l=mid+1;
        }
        return ans;
    }
}