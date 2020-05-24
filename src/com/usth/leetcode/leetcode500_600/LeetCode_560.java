package com.usth.leetcode.leetcode500_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<> ();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int key = sum - k;
            if (map.containsKey(key)) {
                res += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
