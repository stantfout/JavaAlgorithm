package com.usth.leetcode.leetcode401_500;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.Arrays;

@Undone
@GoodQuestion("动态规划")
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= sum; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }
        return dp[n - 1][sum];
    }
}
