package com.usth.leetcode.leetcode201_300;

public class LeetCode_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int len = 0;
        dp[len] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int left = 0;
                int right = len;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (dp[mid] <= nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return len;
    }
    /*
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
     */
}
