package com.bo.coding.others;

public class LCP19 {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] dp = new int[n][3];
        dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        dp[0][1] = Integer.MAX_VALUE;
        dp[0][2] = Integer.MAX_VALUE;
        dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][1]) + isRed;
            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][1],dp[i - 1][2]) + isYellow;
            }
        }
        return dp[n - 1][2];
    }
}
