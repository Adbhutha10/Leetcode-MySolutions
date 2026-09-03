class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int n:nums) {
            if(map.containsKey(n) && map.get(n)>=1) return true;
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        return false;
    }
}