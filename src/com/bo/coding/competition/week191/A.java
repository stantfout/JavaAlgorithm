package com.bo.coding.competition.week191;

import java.util.Arrays;

public class A {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
