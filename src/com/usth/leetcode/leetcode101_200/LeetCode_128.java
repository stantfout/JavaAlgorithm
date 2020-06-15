package com.usth.leetcode.leetcode101_200;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int now = num;
            int count = 1;
            while (set.contains(now + 1)) {
                now++;
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
