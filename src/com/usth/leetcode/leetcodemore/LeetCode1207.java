package com.usth.leetcode.leetcodemore;

import com.usth.annotation.Undone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Undone
public class LeetCode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }
}
