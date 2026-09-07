class Solution {

    int mod = (int)1e9 + 7;

    public int distinctSubseqII(String s) {

        int n = s.length();
        int tot = 0;

        int[] end = new int[26];

        for(char ch : s.toCharArray()) {

            int ind = ch - 'a';

            int old = tot;

            int mew = (old + 1 - end[ind] + mod) % mod;

            tot = (tot + mew) % mod;
            end[ind] = (end[ind] + mew) % mod;
        }

        return tot;
    }
}