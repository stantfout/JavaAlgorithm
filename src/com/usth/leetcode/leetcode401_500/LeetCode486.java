package com.usth.leetcode.leetcode401_500;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

@Undone
@GoodQuestion("动态规划")
public class LeetCode486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = i + 1; j < n; j++) {
//                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//            }
//        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
