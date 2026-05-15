class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));
        int cl=1, ce=pairs[0][1];
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0]>ce) {
                cl++;
                ce=pairs[i][1];
            }
        }
        return cl;
    }
}