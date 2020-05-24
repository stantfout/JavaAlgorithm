package com.usth.leetcode.leetcode100_200;

public class LeetCode_136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
