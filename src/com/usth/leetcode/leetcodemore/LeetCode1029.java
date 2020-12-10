package com.usth.leetcode.leetcodemore;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

@Undone
@GoodQuestion("动态规划/贪心优化")
public class LeetCode1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int a = 0; a <= i + 1; a++) {
                int b = i - a + 1;
                if (a == 0) {
                    dp[a][b] = dp[a][b - 1] + costs[i][1];
                } else if (b == 0) {
                    dp[a][b] = dp[a - 1][b] + costs[i][0];
                } else {
                    dp[a][b] = Math.min(dp[a - 1][b] + costs[i][0], dp[a][b - 1] + costs[i][1]);
                }
            }
        }
        return dp[n / 2][n / 2];
    }
}
