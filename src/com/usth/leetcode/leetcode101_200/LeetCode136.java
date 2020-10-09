package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.FinalEnd;

@FinalEnd
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
