package com.usth.leetcode.leetcode501_600;

public class LeetCode509 {
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
}
