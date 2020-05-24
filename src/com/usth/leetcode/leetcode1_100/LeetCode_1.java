package com.usth.leetcode.leetcode1_100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] {map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
