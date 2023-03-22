package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hash = new int[102];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i] + 1]++;
        }
        for (int i = 0; i < hash.length - 1; i++) {
            hash[i] = hash[i + 1] + hash[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = hash[nums[i]];
        }
        return res;
    }
}
