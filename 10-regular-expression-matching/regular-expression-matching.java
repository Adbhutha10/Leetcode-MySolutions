class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);

                if (cp == '.' || cp == cs) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (cp == '*') {
                    char prev = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2] ||
                              ((prev == '.' || prev == cs) && dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
