package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.FinalEnd;

@FinalEnd
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int dpMax = Math.max(nums[0], 0);
        int dpMin = Math.min(nums[0], 0);
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int tempMax;
            int tempMin;
            if (nums[i] >= 0) {
                tempMax = Math.max(nums[i], nums[i] * dpMax);
                tempMin = Math.min(nums[i], nums[i] * dpMin);
            } else {
                tempMax = Math.max(nums[i], nums[i] * dpMin);
                tempMin = Math.min(nums[i], nums[i] * dpMax);
            }
            dpMax = tempMax;
            dpMin = tempMin;
            max = Math.max(dpMax, max);
        }
        return max;
    }
}
