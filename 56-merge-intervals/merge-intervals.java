class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] curr=intervals[0];
        ans.add(curr);
        for (int[] i:intervals) {
            if(i[0]<=curr[1]) {
                curr[1]=Math.max(curr[1], i[1]);
            }
            else {
                curr = i;
                ans.add(curr);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}