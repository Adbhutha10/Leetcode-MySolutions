class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);
        int cur=k;
        while(set.contains(cur)) cur+=k;
        return cur;
    }
}