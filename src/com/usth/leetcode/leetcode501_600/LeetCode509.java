package com.usth.leetcode.leetcode501_600;

import com.usth.annotation.Undone;

@Undone
public class LeetCode509 {
    // 递归

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /* 递归 + 记忆化
    int[] dp;
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return solve(n,dp);
    }

    private int solve(int n, int[] dp) {
        if (dp[n] == -1) {
            dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        }
        return dp[n];
    }
    */

    /* DP
    int[] dp;
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
     */
}
